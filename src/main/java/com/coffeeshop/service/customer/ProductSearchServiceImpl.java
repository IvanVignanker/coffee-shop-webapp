package com.coffeeshop.service.customer;

import com.coffeeshop.converter.CommonConverter;
import com.coffeeshop.exception.ProductNotFoundException;
import com.coffeeshop.model.customer.entity.product.product.Product;
import com.coffeeshop.model.customer.entity.product.productCoffee.ProductCoffee;
import com.coffeeshop.model.customer.entity.product.productImage.ProductImage;
import com.coffeeshop.model.customer.entity.product.productItem.ProductItem;
import com.coffeeshop.model.customer.entity.product.productQuantity.ProductQuantity;
import com.coffeeshop.model.customer.web.productDetails.ProductDetailsDTOResponse;
import com.coffeeshop.repository.product.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSearchServiceImpl implements ProductSearchService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductQuantityRepository productQuantityRepository;

    @Autowired
    ProductItemRepository productItemRepository;

    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    ProductCoffeeRepository productCoffeeRepository;

    @Autowired
    CommonConverter commonConverter;

    @Autowired
    ProductSearchService productSearchService;

    @Override
    public ProductDetailsDTOResponse findProductById(Long id) throws ProductNotFoundException {
        ProductDetailsDTOResponse productDetailsDTOResponse = null;
        try {
            Product product = productRepository.findById(id)
                    .orElseThrow(ProductNotFoundException::new);
            Long productId = product.getId();

            List<ProductItem> productItem = productItemRepository.findAllByProductId(id)
                    .orElseThrow(ProductNotFoundException::new);

            List<ProductImage> images = productImageRepository.findAllByProductId(productId)
                    .orElseThrow(ProductNotFoundException::new);
            List urls = new ArrayList();
            for (ProductImage image: images) {
                urls.add(generateURLforImages(image));
            }

            ProductCoffee productCoffee = productCoffeeRepository.findAllByProductId(productId)
                    .orElseThrow(ProductNotFoundException::new);
            ProductQuantity productQuantity = productQuantityRepository.findByProductId(productId)
                    .orElseThrow(ProductNotFoundException::new);

            productDetailsDTOResponse = commonConverter
                    .getProductDetailsResponseConverter().convertToResponse(
                            product, productQuantity.getQuantity(), productItem.size(), urls, productCoffee);
        } catch (ProductNotFoundException e) {
            e.httpStatus();
        }
        return productDetailsDTOResponse;
    }

    public String generateURLforImages(ProductImage productImage) {
        Long productId = productImage.getProduct().getId();
        Long imageId = productImage.getId();
        return "http://localhost:8080/api/customer/products/"+productId+"/images/"+imageId;
    }

    @Override
    public List<ProductDetailsDTOResponse> searchByParameters() {
        List<Long> ids = productRepository.getAllIds();
        return ids.stream().map(id -> productSearchService.findProductById(id)).collect(Collectors.toList());
    }
}
