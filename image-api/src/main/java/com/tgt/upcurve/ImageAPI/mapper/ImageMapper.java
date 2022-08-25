package com.tgt.upcurve.ImageAPI.mapper;

import com.tgt.upcurve.ImageAPI.entity.ImageEntity;
import com.tgt.upcurve.ImageAPI.response.ImageResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ImageMapper {
    ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);
    ImageResponse toResponse(ImageEntity image);
    List<ImageResponse> toResponseList(List<ImageEntity> imageList);

}
