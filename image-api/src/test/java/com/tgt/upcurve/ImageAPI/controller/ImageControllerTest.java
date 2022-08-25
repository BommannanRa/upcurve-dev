package com.tgt.upcurve.ImageAPI.controller;

import com.tgt.upcurve.ImageAPI.entity.ImageEntity;
import com.tgt.upcurve.ImageAPI.utility.JsonUtility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class ImageControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static final String URI_GET_IMAGE_BY_IMAGE_ID = "/image_api/v1/get_image/{id}";
    private static final String ORDER_JSON_FILE_PATH = "/imageData.json";
    private static final String URI_GET_ORDER_ID_CUSTOMER_ID = "/image_api/v1/generate_image/order_id/{order_id}/customer_id/{customer_id}";
    private static final String URI_SAVE = "/image_api/v1";

    @Test
    public void test_GenerateImage() throws Exception {
        MvcResult responseFetch = mockMvc.perform(get(URI_GET_ORDER_ID_CUSTOMER_ID, 1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String fetchedResponse = responseFetch.getResponse().getContentAsString();
        ImageEntity fetchedImage = JsonUtility.readValue(fetchedResponse, ImageEntity.class);
        Assertions.assertEquals(fetchedImage.getId(), fetchedImage.getId());
        Assertions.assertNotNull(fetchedImage.getImageCode());
    }

    @Test
    public void test_Generated_GetImage() throws Exception {
        MvcResult responseFetch = mockMvc.perform(get(URI_GET_IMAGE_BY_IMAGE_ID, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        String fetchedResponse = responseFetch.getResponse().getContentAsString();
        ImageEntity fetchedImageEntity = JsonUtility.readValue(fetchedResponse, ImageEntity.class);
        Assertions.assertNotNull(fetchedImageEntity.getImageCode());
        Assertions.assertEquals(1, fetchedImageEntity.getId());
    }
}