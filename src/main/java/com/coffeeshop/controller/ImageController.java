package com.coffeeshop.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class ImageController {

    @GetMapping(value = "/customer/products/{productId}/images/{imageId}",
                produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType() throws IOException {
        final InputStream in = getClass().getResourceAsStream("/images/black-coffee-bean-seed-shape-600w-1273417555.jpg");
        return IOUtils.toByteArray(in);
    }

}





