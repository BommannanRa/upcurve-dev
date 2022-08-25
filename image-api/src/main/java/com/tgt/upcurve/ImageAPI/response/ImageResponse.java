package com.tgt.upcurve.ImageAPI.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("image_code")
    private byte[] imageCode;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

}
