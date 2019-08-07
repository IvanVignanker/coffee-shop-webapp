package com.coffeeshop.service;

import com.coffeeshop.converter.CommonRequestConverter;
import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.admin.web.productCreationResponse.response.ProductMainCreationResponse;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.model.admin.web.productCreationResponse.request.ProductRequest;
import com.coffeeshop.model.admin.web.productCreationResponse.response.ProductCreationResponse;
import com.coffeeshop.repository.product.*;
import com.coffeeshop.converter.productCreationConverter.response.ProductResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProductCreationServiceImpl implements ProductCreationService {

    @Autowired
    private CommonRequestConverter commonConverter;

    @Autowired
    private ProductResponseConverter productResponseConverter;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCoffeeRepository productCoffeeRepository;

    @Override
    @Transactional
    public ProductCreationResponse createProduct(ProductRequest productRequest) {
        Product product = commonConverter.getProductRequestConverter().converterToEntity(
                productRequest.getProductCreationRequest());
        productRepository.save(product);

        ProductCoffee productCoffee =
                commonConverter.getProductCoffeeRequestConverter().converterToCoffeeEntity(
                        productRequest.getProductCoffeeCreation(), product);
        productCoffeeRepository.save(productCoffee);

        ProductCreationResponse productCreationResponse =
                productResponseConverter.converterToWeb(product, productCoffee);

        return productCreationResponse;
    }

    @Override
    @Transactional
    public ProductMainCreationResponse makeAvailable(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        if (product.getAvailable().equals(true)) {
            System.out.println("Product already available");
        } else {
            product.setAvailable(true);
            productRepository.save(product);
            System.out.println("Product status has been changed");
        }
        ProductMainCreationResponse productMainCreationResponse =
                productResponseConverter.converterJustProductToWeb(product);
        return  productMainCreationResponse;
    }

    @Override
    @Transactional
    public ProductMainCreationResponse makeUnavailable(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        if (product.getAvailable().equals(false)) {
            System.out.println("Product already available");
        } else {
            product.setAvailable(false);
            productRepository.save(product);
            System.out.println("Product status has been changed");
        }
        ProductMainCreationResponse productMainCreationResponse =
                productResponseConverter.converterJustProductToWeb(product);
        return  productMainCreationResponse;
    }
}