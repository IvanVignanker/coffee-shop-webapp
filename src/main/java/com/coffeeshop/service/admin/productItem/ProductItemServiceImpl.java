package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.exception.ProductException;
import com.coffeeshop.exception.ProductExceptionType;
import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;
import com.coffeeshop.model.customer.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.repository.custom.ProductItemRepositoryCustom;
import com.coffeeshop.repository.custom.ProductItemRepositoryCustomImpl;
import com.coffeeshop.repository.product.ProductItemRepository;
import com.coffeeshop.repository.product.ProductQuantityRepository;
import com.coffeeshop.repository.product.ProductRepository;
import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.coffeeshop.exception.ProductExceptionType.*;
import static com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus.AVAILABLE;
import static com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus.SOLD;

@Service
public class ProductItemServiceImpl implements ProductItemService {

    @Autowired
    private ProductItemRepository productItemRepository;

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductQuantityRepository productQuantityRepository;

    @Autowired
    private ProductItemRepositoryCustomImpl productItemRepositoryCustom;

    @Override
    public void createProductItems(List<ProductItemRequest> productMainRequests) {
        for (ProductItemRequest productItemRequest: productMainRequests) {
            productItemService.createProductItem(productItemRequest);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = ProductNotFoundException.class)
    public void createProductItem(ProductItemRequest productMainRequest) throws ProductNotFoundException {
        try {
            Product product = productRepository.findById(productMainRequest
                    .getProductId()).orElseThrow(ProductNotFoundException::new);

            Integer counter = productMainRequest.getWeightKG();
            for (; counter > 0; counter--) {
                productItemRepository.save(ProductItem.builder()
                        .product(product).weightKG(1).build());
            }
            addQuantity(productMainRequest);
        } catch (ProductNotFoundException e) {
            e.httpStatus();
        }
    }

    public void addQuantity(ProductItemRequest productMainRequest) {
        Product product = productRepository.findById(productMainRequest.getProductId())
                .orElseThrow(ProductNotFoundException::new);

        if (productMainRequest.getWeightKG() > 0) {
            if (productQuantityRepository.findByProductId(productMainRequest.getProductId()).equals(Optional.empty())) {
                productQuantityRepository.save(ProductQuantity.builder().product(product)
                        .quantity(productMainRequest.getWeightKG()).version(1).build());
            } else {
                ProductQuantity productQuantity = productQuantityRepository.findByProductId(productMainRequest.getProductId())
                        .orElseThrow(ProductNotFoundException::new);
                productQuantity.setQuantity(productQuantity.getQuantity()+productMainRequest.getWeightKG());
            }
        }
    }

    @Override
    @Transactional
    public List<ProductItemResponse> findAndMarkAsSold(Map<Long, Integer> items) {
        List<ProductItem> productItems = new ArrayList<>();
        for (Map.Entry<Long, Integer> map : items.entrySet()) {
            Product product = productRepository.findProductByIdAndAvailableIsTrue(map.getKey())
            .orElseThrow(() -> new ProductException(map.getKey(), PRODUCT_NOT_AVAILABLE));
            List<ProductItem> markAsSoldList = productItemService.findAndMarkAsSoldChild(map.getKey(), map.getValue());
            if (markAsSoldList.isEmpty()) throw new ProductException(map.getKey(), OUT_OF_STOCK);
            productItems.addAll(markAsSoldList);
        }
        return productItems.stream().map(productItem ->
                ProductItemResponse.builder()
                        .id(productItem.getId())
                        .productId(productItem.getProduct().getId())
                        .status(productItem.getStatus())
                        .weightKG(productItem.getWeightKG())
                        .build()).collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = ProductException.class)
    public List<ProductItem> findAndMarkAsSoldChild(Long productId, Integer quantity) throws ProductException {
        List<ProductItem> items = new ArrayList<>();
        try {
            Product product = productRepository.findById(productId)
                    .orElseThrow(ProductNotFoundException::new);
            items = productItemRepositoryCustom
                    .findProductItemByProductAndProductStatusLimitIs(product, AVAILABLE, quantity);
            if (items.size() < 0) {
                throw new ProductException(productId, ILLEGAL_QUANTITY);
            }
            for (ProductItem productItem: items) {
                productItem.setStatus(SOLD);
            }
            productItemRepository.saveAll(items);
        } catch (ProductException e) {
            e.httpStatus();
        }
        return items.size() == quantity ? items : new ArrayList<>();
    }

    //no action required
    @Override
    @Transactional
    public List<ProductItem> findAndMarkAsSold(Integer amount) {
        return new ArrayList<>();
    }
}
