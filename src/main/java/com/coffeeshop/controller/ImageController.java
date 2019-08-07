package com.coffeeshop.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api")
public class ImageController {

    @GetMapping(value = "/customer/products/{productId}/images/{imageId}",
                produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getImageWithMediaType(@PathVariable("productId") Long productId,
    @PathVariable("imageId") String imageId)  throws IOException {
        final InputStream in = getClass().getResourceAsStream("/images/black-coffee-bean-seed-shape-600w-1273417555.jpg");
        return IOUtils.toByteArray(in);
    }
}
