package com.tgt.upcurve.ImageAPI.controller;

import com.tgt.upcurve.ImageAPI.response.ImageResponse;
import com.tgt.upcurve.ImageAPI.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image_api/v1")
public class ImageController {
    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/generate_image/order_id/{order_id}/customer_id/{customer_id}")
    public ImageResponse generateImage(@PathVariable("order_id") Integer orderId, @PathVariable("customer_id") Integer customerId) {
        return imageService.generateImage(orderId, customerId);
    }

    @GetMapping("/generate_image/content/{content}")
    public ImageResponse generateImage(@PathVariable("content") String content) {
        return imageService.generateImage(content);
    }

        @GetMapping("/get_image/{id}")
    public ImageResponse getImage(@PathVariable("id") Long imageId) {
        return imageService.getImage(imageId);

    }
}

