package com.example.eco.mappers;

import com.example.eco.dto.NewsDto;
import com.example.eco.entities.News;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NewsMapper {
    News toEntity(NewsDto newsDto);

    NewsDto toDto(News news);

    List<NewsDto> toDtos(List<News> news);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    News partialUpdate(NewsDto newsDto, @MappingTarget News news);
}