package com.coffeeshop.runner;

import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.admin.request.ProductCoffeeCreation;
import com.coffeeshop.model.admin.request.ProductCreationRequest;
import com.coffeeshop.model.admin.request.ProductItemRequest;
import com.coffeeshop.model.admin.request.ProductRequest;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productImage.ProductImage;
import com.coffeeshop.repository.product.ProductImageRepository;
import com.coffeeshop.repository.product.ProductRepository;
import com.coffeeshop.service.admin.productCreation.ProductCreationService;
import com.coffeeshop.service.admin.productItem.ProductItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
@Profile("dev")
public class ProductAndProductItemCreationRunner implements CommandLineRunner {

    @Autowired
    private ProductCreationService productCreationService;

    @Autowired
    private ProductItemService productItemService;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        int lenght = 10;
        for (int i = 1; i <= lenght; i++) {
            createProduct(i);
            createProductItem(i);
            for (int j = 3; j > 0; j--) {
                createImages(i);
            }
        }
        makeAvailable(lenght);
    }

    public void makeAvailable(int lenght) {
        for (int i = 1; i<=lenght; i++) {
            productCreationService.makeAvailable((long) i);
        }
    }

    public void createImages(int number) {
        String imageString = number+"SGVsbG8sIFdvcmxkIQ==";
        byte[] imageTest = imageString.getBytes();

        ProductImage productImage = ProductImage.builder()
                .product(productRepository.findById((long) number)
                        .orElseThrow(ProductNotFoundException::new))
                .image(imageTest)
                .build();
        productImageRepository.save(productImage);
    }

    public void createProductItem(int number) {
        ProductItemRequest productItemRequest = ProductItemRequest.builder()
                .productId(Long.valueOf(number))
                .weightKG(number < 10 ? 100 : number*10)
                .build();
        productItemService.createProductItem(productItemRequest);
    }

    public void createProduct(int number) {
        ProductRequest productRequest =
                ProductRequest.builder()
                        .productCreationRequest(ProductCreationRequest.builder()
                                .productName("Coffee title: "+number)
                                .shortDescription("Good coffee: "+number)
                                .description("Audio vocem de mirabili futuro, Matutinam vocem, rore humidam.")
                                .previewImage("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")
                                .unitPrice(ThreadLocalRandom.current().nextDouble(0, 250))
                                .build())
                        .productCoffeeCreation(ProductCoffeeCreation.builder()
                                .sour(ThreadLocalRandom.current().nextInt(1, 5))
                                .bitter(ThreadLocalRandom.current().nextInt(1, 5))
                                .strong(ThreadLocalRandom.current().nextInt(1, 5))
                                .ground(ThreadLocalRandom.current().nextBoolean())
                                .decaf(ThreadLocalRandom.current().nextBoolean())
                                .build()).build();
        productCreationService.createProduct(productRequest);
    }
}
