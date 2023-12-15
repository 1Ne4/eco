package com.example.eco.mappers;

import com.example.eco.entities.Point;
import com.example.eco.dto.PointDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(uses = {MaterialMapper.class},componentModel = "spring")
public interface PointMapper {
    Point toEntity(PointDto pointDto);

    PointDto toDto(Point point);

    List<PointDto> toDtos(List<Point> points);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Point partialUpdate(PointDto pointDto, @MappingTarget Point point);
}
