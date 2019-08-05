package com.coffeeshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Base64Validator implements ConstraintValidator<Base64Size, String> {

    private int maxSize;

    @Override
    public void initialize(Base64Size size) {
        this.maxSize=size.maxSizeKB();
    }

    @Override
    public boolean isValid(String base64, ConstraintValidatorContext constraintValidatorContext) {
        if (base64 == null) {
            return true;
        }
        if (base64.isEmpty()) {
            return true;
        }
        if (calculateSize(base64) <= maxSize) {
            return true;
        } else return false;
    }

    public int calculateSize(String base64) {
        int res = 0;
        int padding = 0;
        if (base64.endsWith("==")) {
            padding = 2;
        }
        if (base64.endsWith("=")) {
            padding =1;
        }
        res = (int)(Math.ceil(base64.length()/4)*3)-padding;
        return (res/1024);
    }
}