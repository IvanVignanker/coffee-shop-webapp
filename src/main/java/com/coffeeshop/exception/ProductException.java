package com.coffeeshop.exception;

import com.coffeeshop.model.customer.web.error.ErrorResponse;
import com.coffeeshop.model.customer.web.error.ProductExceptionResponse;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class ProductException extends BaseException {

    public Long productId;
    private final String DEFAULT_MESSAGE = "Product checkout error";
    private ProductExceptionType type;

    private static final HttpStatus PRECONDITION_FAILED = HttpStatus.PRECONDITION_FAILED;
    private static final Map<ProductExceptionType, String> map = new HashMap<>();

    static {
        map.put(ProductExceptionType.OUT_OF_STOCK, "Out of stock");
        map.put(ProductExceptionType.ILLEGAL_QUANTITY, "Illegal quantity");
        map.put(ProductExceptionType.PRODUCT_NOT_AVAILABLE, "Product not available");
    }

    private ProductException(){}

    public ProductException(Long productId, ProductExceptionType type){
        this.productId=productId;
        this.type=type;
    }

    @Override
    public ErrorResponse errorResponse() {
        return ErrorResponse.builder()
                .message(DEFAULT_MESSAGE)
                .errors(new ProductExceptionResponse(productId, map.get(type)))
                .build();
    }

    @Override
    public HttpStatus httpStatus() {
        return PRECONDITION_FAILED;
    }
}
