package com.coffeeshop.validation.imageType;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Base64TypeValidatorTest {

    private final String COFFEE_IMAGE_TEST_PNG = "src/test/java/resources/308425_preview.png";
    private final String COFFEE_IMAGE_TEST_GIF = "src/test/java/resources/302421825060201.gif";
    private final String COFFEE_IMAGE_TEST_PDF = "src/test/java/resources/s8usx-xutxv.pdf";
    private final String COFFEE_IMAGE_TEST_JPG = "src/test/java/resources/coffee-2.jpg";
    private final String COFFEE_IMAGE_TEST_ZIP = "src/test/java/resources/archive.zip";
    private final String COFFEE_IMAGE_TEST_JPEG = "src/test/java/resources/f91516da1f314fcf828689db80d16677.jpeg";

    private Base64TypeValidator validator = new Base64TypeValidator();

    @Test
    public void testValidBase64ImageType() {
        String imageNull = null;
        String imageJPG = encoder(COFFEE_IMAGE_TEST_JPG);
        String imageJPEG = encoder(COFFEE_IMAGE_TEST_JPEG);
        assertTrue(validator.isValid(imageNull,null));
        assertTrue(validator.isValid(imageJPG, null));
        assertTrue(validator.isValid(imageJPEG, null));
    }

    @Test
    public void testNotValidBase64ImageType() {
        String imageEmpty = "";
        String imagePDF = encoder(COFFEE_IMAGE_TEST_PDF);
        String imageGIF = encoder(COFFEE_IMAGE_TEST_GIF);
        String imageZIP = encoder(COFFEE_IMAGE_TEST_ZIP);
        String imagePNG = encoder(COFFEE_IMAGE_TEST_PNG);
        assertFalse(validator.isValid(imageEmpty,null));
        assertFalse(validator.isValid(imagePDF,null));
        assertFalse(validator.isValid(imageGIF,null));
        assertFalse(validator.isValid(imageZIP,null));
        assertFalse(validator.isValid(imagePNG,null));
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