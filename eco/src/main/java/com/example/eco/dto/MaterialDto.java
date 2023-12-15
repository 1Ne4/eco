package com.example.eco.dto;

import com.example.eco.entities.Material;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Material}
 */
@Value
public class MaterialDto implements Serializable {
    String type;
}