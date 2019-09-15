package com.coffeeshop.exception;

import com.coffeeshop.model.customer.web.error.ErrorResponse;
import org.springframework.http.HttpStatus;

public class OutOfStockException extends BaseException {

    private static final String DEFAULT_MESSAGE = "Out of bound";
    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    public OutOfStockException() {}

    public OutOfStockException(String message) {
        super(message);
    }

    @Override
    public ErrorResponse errorResponse() {
        return ErrorResponse.builder().message(DEFAULT_MESSAGE).build();
    }

    @Override
    public HttpStatus httpStatus() {
        return BAD_REQUEST;
    }
}
