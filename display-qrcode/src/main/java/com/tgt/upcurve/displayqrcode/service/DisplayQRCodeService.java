package com.tgt.upcurve.displayqrcode.service;
import com.tgt.upcurve.displayqrcode.repository.ImageRepository;
import org.springframework.stereotype.Service;

@Service
public class DisplayQRCodeService {
    private final ImageRepository imageRepository;

    public DisplayQRCodeService(ImageRepository imageRepository)
    {
        this.imageRepository = imageRepository;
    }

    public byte[] getQRCode(){
        return imageRepository.generateImage(1,1).getImageCode();
    }
}
