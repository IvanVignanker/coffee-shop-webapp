package com.coffeeshop.validation.imageType;

import org.apache.tika.Tika;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Base64;

public class Base64TypeValidator implements ConstraintValidator<Base64Type, String> {

    @Override
    public void initialize(Base64Type type) {}

    public Base64TypeValidator() {}

    @Override
    public boolean isValid(String base64Type, ConstraintValidatorContext constraintValidatorContext) {
        if (base64Type == null) {
            System.out.println("null");
            return true;
        }
        if (base64Type.isEmpty()) {
            System.out.println("empty");
            return false;
        }
        if (checkType(base64Type)) {
            return true;
        }
        return false;
    }

    public boolean checkType(String base64Type) {
        byte[] imageByteArray = Base64.getDecoder().decode(base64Type);
        String contentType = new Tika().detect(imageByteArray);
        System.out.println(contentType);

        if (contentType.contains("jpeg") || contentType.contains("jpg")
                ||  contentType.contains("JPEG") || contentType.contains("JPG")
                ||  contentType.contains("jfif") || contentType.contains("JFIF")) {
            return true;
        } else return false;
    }
}
