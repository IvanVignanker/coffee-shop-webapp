package com.coffeeshop.repository;

import com.coffeeshop.model.customer.web.productList.ProductListDTORequest;
import org.springframework.validation.BindingResult;

import javax.persistence.Query;
import java.util.List;

public interface ProductSearchRepositoryCustom {
    List<Query> searchProductByName(ProductListDTORequest productListDTORequest, BindingResult result);
}
