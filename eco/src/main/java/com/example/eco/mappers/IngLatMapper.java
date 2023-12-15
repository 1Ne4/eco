package com.example.eco.mappers;

import com.example.eco.dto.IngLatDto;
import com.example.eco.entities.IngLat;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface IngLatMapper {
    IngLat toEntity(IngLatDto ingLatDto);

    IngLatDto toDto(IngLat ingLat);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    IngLat partialUpdate(IngLatDto ingLatDto, @MappingTarget IngLat ingLat);
}
