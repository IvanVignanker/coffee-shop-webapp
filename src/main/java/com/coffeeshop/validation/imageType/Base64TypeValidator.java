package com.coffeeshop.validation.imageType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.tika.Tika;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.Base64;

public class Base64TypeValidator implements ConstraintValidator<Base64Type, String> {

    @Override
    public void initialize(Base64Type type) {}

    public Base64TypeValidator() {}

    @Override
    public boolean isValid(String base64Type, ConstraintValidatorContext constraintValidatorContext) {
        if (base64Type == null) {
            return true;
        }
        if (base64Type.isEmpty()) {
            return false;
        }
        if (checkType(base64Type)) {
            return true;
        }
        return false;
    }

    private boolean checkType(String base64Type) {
        byte[] imageByteArray = Base64.getDecoder().decode(base64Type);
        String contentType = new Tika().detect(imageByteArray);

        return (contentType.contains("JPEG") || contentType.contains("jpeg")
            ||  contentType.contains("JPG") || contentType.contains("jpg")
            ||  contentType.contains("JFIF") ||  contentType.contains("jfif"));
    }
}