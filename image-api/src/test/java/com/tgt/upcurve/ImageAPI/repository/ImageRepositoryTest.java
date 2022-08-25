package com.tgt.upcurve.ImageAPI.repository;

import com.tgt.upcurve.ImageAPI.ImageApiApplication;
import com.tgt.upcurve.ImageAPI.entity.ImageEntity;
import com.tgt.upcurve.ImageAPI.utility.JsonUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ImageApiApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ImageRepositoryTest {
    @Autowired
    ImageRepository imageRepository;
    private static final String ORDER_JSON_FILE_PATH = "/imageData.json";

    @Test
    public void testGetImageByImageId() throws Exception {
        ImageEntity image = JsonUtility.getImageRequest(ORDER_JSON_FILE_PATH);
        ImageEntity saveImageEntity = imageRepository.save(image);
        Optional<ImageEntity> fetchedImageEntity = imageRepository.findById(Long.valueOf(1));
        assert fetchedImageEntity != null;
    }

    @Test
    public void testGeneratedImageOfOrderIdAndCustomerId() throws Exception {
        ImageEntity image = JsonUtility.getImageRequest(ORDER_JSON_FILE_PATH);
        String qrContent = 10 + "-" + 1;
        byte[] newQRCode = qrContent.getBytes(StandardCharsets.UTF_8);
        ImageEntity savedImageEntity = imageRepository.save(image);
        assert savedImageEntity!=null;
    }

    @Test
    public void testSaveImageEntity() throws Exception {
        ImageEntity image = JsonUtility.getImageRequest(ORDER_JSON_FILE_PATH);
        ImageEntity savedImageEntity = imageRepository.save(image);
        Assertions.assertNotNull(savedImageEntity);
    }
}