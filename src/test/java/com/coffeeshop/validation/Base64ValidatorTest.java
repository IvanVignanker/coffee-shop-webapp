package com.coffeeshop.validation;

import io.leangen.geantyref.TypeFactory;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class Base64ValidatorTest {

    private Base64Size base64SizeAnnotation;
    private Base64Validator validator;
    private final String COFFEE_IMAGE_TEST = "src/test/java/resources/coffee-2.jpg";
    private final String COFFEE_IMAGE_TEST_ERROR = "src/test/java/resources/A_small_cup_of_coffee.JPG";

    @SneakyThrows
    private Base64Size getInstanceOfAnnotation(int size) {
        Map<String, Object> annotationParams = new HashMap<>();
        annotationParams.put("maxSizeKB", size);
        base64SizeAnnotation = TypeFactory.annotation(Base64Size.class, annotationParams);
        getValidator(base64SizeAnnotation);
        return base64SizeAnnotation;
    }

    private Base64Validator getValidator(Base64Size base64SizeAnnotation) {
        validator = new Base64Validator();
        validator.initialize(base64SizeAnnotation);
        return validator;
    }

    //empty
    @Test
    public void testEmptyBase64ImageSize() {
        validator = getValidator(getInstanceOfAnnotation(9));
        assertTrue(validator.isValid("", null));
    }

    //null
    @Test
    public void testNullBase64ImageSize(){
        validator = getValidator(getInstanceOfAnnotation(9));
        assertTrue(validator.isValid(null, null));
    }

    //valid image
    @Test
    public void testValidBase64ImageSize() {
        validator = getValidator(getInstanceOfAnnotation(9));
        String image = encoder(COFFEE_IMAGE_TEST);
        assertTrue(validator.isValid(image,null));
    }

    //not valid image
    @Test
    public void testNotValidBase64ImageSize() {
        validator = getValidator(getInstanceOfAnnotation(9));
        String image = encoder(COFFEE_IMAGE_TEST_ERROR);
        assertFalse(validator.isValid(image, null));
    }

    @SneakyThrows()
    private String encoder(String imageSrc){
        String base64 = "" ;
        InputStream inputStream = new FileInputStream(imageSrc);
        byte[] imageToBytes = IOUtils.toByteArray(inputStream);
        base64 = Base64.getEncoder().encodeToString(imageToBytes);
        return base64;
    }
}