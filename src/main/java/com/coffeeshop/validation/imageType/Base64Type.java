package com.coffeeshop.validation.imageType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = Base64TypeValidator.class)
public @interface Base64Type {
    String message() default "Invalid type of inputted image";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
