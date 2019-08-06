package com.coffeeshop.validation.imageSize;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = Base64SizeValidator.class)
public @interface Base64Size {
    String message() default "Invalid size of inputted image";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    int maxSizeKB() default 300;
}