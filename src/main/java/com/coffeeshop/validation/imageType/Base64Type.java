package com.coffeeshop.validation.imageType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = Base64TypeValidator.class)
public @interface Base64Type {
    String message() default "Image type not allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
