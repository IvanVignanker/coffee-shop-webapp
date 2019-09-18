package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.exception.ProductException;
import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.admin.response.ProductItemResponse;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.repository.custom.ProductItemRepositoryCustom;
import com.coffeeshop.repository.product.ProductItemRepository;
import com.coffeeshop.repository.product.ProductQuantityRepository;
import com.coffeeshop.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private ProductItemRepositoryCustom productItemRepositoryCustom;

    @Override
    public void createProductItems(List<ProductItemRequest> productMainRequests) {
        for (ProductItemRequest productItemRequest : productMainRequests) {
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
                productQuantity.setQuantity(productQuantity.getQuantity() + productMainRequest.getWeightKG());
            }
        }
    }

    @Override
    @Transactional
    public List<ProductItemResponse> findAndMarkAsSold(Map<Long, Integer> items) {
        List<ProductItem> markedAsSoldItems = new ArrayList<>();
        for (Map.Entry<Long, Integer> map : items.entrySet()) {
            List<ProductItem> checkingProductItemsLengths = new ArrayList<>();
            Product product = productRepository.findById(map.getKey())
                    .orElseThrow(ProductNotFoundException::new);
            checkingProductItemsLengths.addAll(productItemRepository
                    .findAllByProductIdAndStatus(map.getKey(), AVAILABLE));
            if (!checkingProductItemsLengths.isEmpty() && checkingProductItemsLengths.size() >= map.getValue()) {
                productItemService.findAndMarkAsSold(product, map.getValue());
            }
        }
        markedAsSoldItems.addAll(productItemRepository.findAllByStatus(SOLD));
        return markedAsSoldItems.stream().map(item -> ProductItemResponse.builder()
                .productId(item.getProduct().getId())
                .id(item.getId())
                .status(item.getStatus())
                .build()).collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = ProductException.class)
    public List<ProductItem> findAndMarkAsSold(Product product, Integer amount) throws ProductException {
        List<ProductItem> markedAsSoldItems = new ArrayList<>();
        markedAsSoldItems.addAll(productItemRepositoryCustom
                .findProductItemByProductAndProductStatusLimitIs(product, AVAILABLE, amount));
        try {
            for (int i = 0; i < amount; i++) {
                markedAsSoldItems.get(i).setStatus(SOLD);
                markedAsSoldItems.add(markedAsSoldItems.get(i));
            }
            productItemRepository.saveAll(markedAsSoldItems);
        } catch (ProductException e) {
            e.httpStatus();
        }
        return markedAsSoldItems;
    }
}
