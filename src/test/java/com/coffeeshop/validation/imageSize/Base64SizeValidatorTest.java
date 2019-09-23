package com.coffeeshop.validation.imageSize;

import com.coffeeshop.Runner;
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

public class Base64SizeValidatorTest {

    private Base64Size base64SizeAnnotation;
    private Base64SizeValidator validator;

    private static final int MAX_TEST_SIZE_9KB = 9;

    private static final String COFFEE_IMAGE_TEST_8KB = "src/test/java/resources/imagetype/small_pdf_8KB.pdf";
    private static final String COFFEE_IMAGE_TEST_402KB = "src/test/java/resources/imageSize/big_jpg_402KB.JPG";

    @SneakyThrows
    private Base64Size getInstanceOfAnnotation(int size) {
        Map<String, Object> annotationParams = new HashMap<>();
        annotationParams.put("maxSizeKB", size);
        base64SizeAnnotation = TypeFactory.annotation(Base64Size.class, annotationParams);
        getValidator(base64SizeAnnotation);
        return base64SizeAnnotation;
    }

    private Base64SizeValidator getValidator(Base64Size base64SizeAnnotation) {
        validator = new Base64SizeValidator();
        validator.initialize(base64SizeAnnotation);
        return validator;
    }

    @Test
    public void testValidEmptyBase64ImageSizePositive() {
        validator = getValidator(getInstanceOfAnnotation(MAX_TEST_SIZE_9KB));
        assertTrue(validator.isValid("", null));
    }

    @Test
    public void testValidNullBase64ImageSizePositive(){
        validator = getValidator(getInstanceOfAnnotation(MAX_TEST_SIZE_9KB));
        assertTrue(validator.isValid(null, null));
    }

    @Test
    public void testValidBase64ImageSizePositive() {
        validator = getValidator(getInstanceOfAnnotation(MAX_TEST_SIZE_9KB));
        String image = encoder(COFFEE_IMAGE_TEST_8KB);
        assertTrue(validator.isValid(image,null));
    }

    @Test
    public void testValidBase64ImageSizeNegative() {
        validator = getValidator(getInstanceOfAnnotation(MAX_TEST_SIZE_9KB));
        String image = encoder(COFFEE_IMAGE_TEST_402KB);
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
