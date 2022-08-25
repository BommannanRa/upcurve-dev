package com.tgt.upcurve.ImageAPI.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tgt.upcurve.ImageAPI.entity.ImageEntity;

import java.awt.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonUtility {
        public static final ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        public static String writeValueAsString(Object inputs) throws JsonProcessingException {
            return objectMapper.writeValueAsString(inputs);
        }

        public static <T> T readValue(String json, Class<T> clazz) throws Exception {
            return objectMapper.readValue(json, clazz);
        }

        public static <T> T readValue(String json, TypeReference<T> typeReference) throws Exception {
            return objectMapper.readValue(json, typeReference);
        }

        public static <T> List<T> readValueList(String json, Class<T> clazz) throws Exception {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
            return objectMapper.readValue(json, type);
        }

        public static String getResourceAsString(String path) throws Exception {
            URI uriPath = JsonUtility.class.getResource(path).toURI();
            return Files.readString(Paths.get(uriPath));
        }

        public static ImageEntity getImageRequest(String fileName) throws Exception {
            return JsonUtility.readValue(JsonUtility.getResourceAsString(fileName), ImageEntity.class);
        }

}
