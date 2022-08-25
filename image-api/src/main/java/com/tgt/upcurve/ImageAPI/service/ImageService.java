package com.tgt.upcurve.ImageAPI.service;

import com.tgt.upcurve.ImageAPI.entity.ImageEntity;
import com.tgt.upcurve.ImageAPI.mapper.ImageMapper;
import com.tgt.upcurve.ImageAPI.repository.ImageRepository;
import com.tgt.upcurve.ImageAPI.response.ImageResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final QRCodeServiceImpl qrCodeService;

    @Value("${qr.code.width}")
    private Integer qrCodeWidth;
    @Value("${qr.code.height}")
    private Integer qrCodeHeight;

    public ImageService(ImageRepository imageRepository,QRCodeServiceImpl qrCodeService){
        this.imageRepository=imageRepository;
        this.qrCodeService = qrCodeService;
    }

    public ImageResponse generateImage(Integer orderId, Integer customerId) {
        String qrContent = orderId + "-" + customerId;
        byte[] newQRCode = qrCodeService.generateQRCode(qrContent, qrCodeWidth, qrCodeHeight);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageCode(newQRCode);
        return ImageMapper.INSTANCE.toResponse(imageRepository.saveAndFlush(imageEntity));
    }

    public ImageResponse getImage(Long imageId) {
        Optional<ImageEntity> image = null;
       image = imageRepository.findById(imageId);
       if (image.isPresent()) {
           return ImageMapper.INSTANCE.toResponse(image.get());
       }
       return null;
    }

    public ImageResponse saveImage(ImageEntity image) {
        ImageEntity savedImage = null;
        Optional<ImageEntity> existingImage = imageRepository.findById(image.getId());
        if(null == existingImage){
            savedImage = imageRepository.save(image);
        }
        return ImageMapper.INSTANCE.toResponse(savedImage);
    }

    public ImageResponse generateImage(String qrContent) {
        byte[] newQRCode = qrCodeService.generateQRCode(qrContent, qrCodeWidth, qrCodeHeight);
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageCode(newQRCode);
        return ImageMapper.INSTANCE.toResponse(imageRepository.saveAndFlush(imageEntity));
    }
}
