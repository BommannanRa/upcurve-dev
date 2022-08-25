package com.tgt.upcurve.displayqrcode.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("image_code")
    private byte[] imageCode;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

}