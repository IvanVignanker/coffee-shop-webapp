package com.coffeeshop.service.customer;

import com.coffeeshop.model.customer.web.productDetails.ProductDetailsDTOResponse;

import java.util.List;

public interface ProductSearchService {
    ProductDetailsDTOResponse findProductById(Long id);
    List<ProductDetailsDTOResponse> searchByParameters();
}
