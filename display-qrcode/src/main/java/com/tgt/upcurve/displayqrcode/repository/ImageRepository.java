package com.tgt.upcurve.displayqrcode.repository;

import com.tgt.upcurve.displayqrcode.model.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="image-api", url="${apis.image}")
public interface ImageRepository {
    @RequestMapping(method = RequestMethod.GET, path="/generate_image/order_id/{order_id}/customer_id/{customer_id}")
    public Image generateImage(@Validated @PathVariable("order_id") Integer orderId, @Validated @PathVariable("customer_id") Integer customerId);
}