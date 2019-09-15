package com.coffeeshop.exception;

import com.coffeeshop.model.customer.web.error.ErrorResponse;
import org.springframework.http.HttpStatus;

public class OptimisticLockException extends BaseException {

    private static final String DEFAULT_MESSAGE = "ASK ED WHAT DOES IT MEAN :)";
    private static final HttpStatus BAD_REQUEST = HttpStatus.BAD_REQUEST;

    public OptimisticLockException() {}

    public OptimisticLockException(String message) {
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
