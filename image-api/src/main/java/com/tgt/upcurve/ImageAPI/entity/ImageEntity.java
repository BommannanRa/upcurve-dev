package com.tgt.upcurve.ImageAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "images" )
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "image_code")
    private byte[] imageCode;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now(ZoneId.of("UTC"));

    }


}
