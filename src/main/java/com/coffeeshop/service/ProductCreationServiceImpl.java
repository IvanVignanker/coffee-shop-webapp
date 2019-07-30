package com.coffeeshop.service;

import com.coffeeshop.model.entity.product.product.Product;
import com.coffeeshop.model.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.model.entity.product.productImage.ProductImage;
import com.coffeeshop.model.entity.product.productItem.ProductItem;
import com.coffeeshop.model.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.model.web.productCreationResponse.request.ProductRequest;
import com.coffeeshop.model.web.productCreationResponse.response.ProductCreationResponse;
import com.coffeeshop.repository.product.*;
import com.coffeeshop.service.converters.ProductRequestConverter;
import com.coffeeshop.service.converters.ProductResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductCreationServiceImpl implements ProductCreationService {

    @Autowired
    ProductRequestConverter productRequestConverter;

    @Autowired
    ProductResponseConverter productResponseConverter;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCoffeeRepository productCoffeeRepository;

    @Autowired
    ProductItemRepository productItemRepository;

    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    ProductQuantityRepository productQuantityRepository;

    @Override
    @Transactional
    public ProductCreationResponse createProduct(ProductRequest productRequest) {
        Product product = productRequestConverter.converterToEntity(
                productRequest.getProductCreationRequest());
        productRepository.save(product);
        Long id = product.getId();

        ProductCoffee productCoffee =
                productRequestConverter.converterToCoffeeEntity(
                        productRequest.getProductCoffeeCreation(), product);
        ProductItem productItem =
                productRequestConverter.converterToItemEntity(
                        productRequest.getProductItemCreation(), product);
        ProductImage productImage =
                productRequestConverter.converterToImageEntity(
                        productRequest.getProductImageCreation(), product);
        ProductQuantity productQuantity =
                productRequestConverter.converterToQuantityEntity(
                        productRequest.getProductQuantityCreation(), product);

        productCoffeeRepository.save(productCoffee);
        productItemRepository.save(productItem);
        productImageRepository.save(productImage);
        productQuantityRepository.save(productQuantity);

        ProductCreationResponse productCreationResponse =
                productResponseConverter.converterToWeb(product, productCoffee, productItem,
                        productImage, productQuantity);
        return productCreationResponse;
    }

    @Override
    public void makeAvailable(Long id) {
        Product product = productRepository.findById(id).orElseThrow(null);
        if (product.getAvailable().equals(true)) {
            System.out.println("Product already available");
        } else {
            product.setAvailable(true);
            System.out.println("Product status has been changed");
        }
    }

    @Override
    public void makeUnavailable(Long id) {
        Product product = productRepository.findById(id).orElseThrow(null);
        if (product.getAvailable().equals(false)) {
            System.out.println("Product already available");
        } else {
            product.setAvailable(false);
            System.out.println("Product status has been changed");
        }
    }
}