package com.coffeeshop.repository.custom;

import com.coffeeshop.model.customer.web.productList.ProductListDTORequest;
import com.coffeeshop.model.customer.web.productList.ProductListDTOResponse;

public interface ProductSearchRepositoryCustom {
    ProductListDTOResponse searchProductByName(ProductListDTORequest productListDTORequest);
}
