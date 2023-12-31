package com.example.eco.mappers;

import com.example.eco.entities.Material;
import com.example.eco.dto.MaterialDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    Material toEntity(MaterialDto materialDto);

    MaterialDto toDto(Material material);


    List<MaterialDto> toDtos(List<Material> materials);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Material partialUpdate(MaterialDto materialDto, @MappingTarget Material material);
}
