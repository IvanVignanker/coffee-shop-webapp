package com.coffeeshop.service.admin.productItem;

import com.coffeeshop.exception.OptimisticLockException;
import com.coffeeshop.exception.OutOfStockException;
import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productItem.status.ProductStatus;
import com.coffeeshop.model.customer.entity.product.productQuantity.ProductQuantity;
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
    public List<ProductItem> findAndMarkAsSold(Map<Long, Integer> items) {
        List<ProductItem> productItems = new ArrayList<>();
        for (Map.Entry<Long, Integer> map : items.entrySet()) {
            productItems.addAll(productItemService.
                    findAndMarkAsSoldChild(map.getKey(), map.getValue()));
        }
        return productItems;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = OutOfStockException.class)
    public List<ProductItem> findAndMarkAsSoldChild(Long productId, Integer quantity) {
        ProductItem item = null;
        List<ProductItem> items = new ArrayList<>();
        try {
            Product product = productRepository.findById(productId)
                    .orElseThrow(ProductNotFoundException::new);

            items = productItemRepository
                    .findAllByProductIdAndStatus(product.getId(), ProductStatus.AVAILABLE);
            for (int i = 0; i < quantity; i++) {
                items.get(i).setStatus(ProductStatus.SOLD);
            }
            removeQuantity(productId, quantity);
        } catch (OptimisticLockException opt) {
            opt.httpStatus();
        }
        return items;
    }

    public void removeQuantity(Long productId, Integer quantity) {
        if (quantity > 0) {
                ProductQuantity productQuantity = productQuantityRepository
                        .findByProductId(productId).orElseThrow(ProductNotFoundException::new);
                productQuantity.setQuantity(productQuantity.getQuantity()-quantity);
        }
    }
}
