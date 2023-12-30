package com.example.eco.dto;

import com.example.eco.entities.Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Material}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaterialDto implements Serializable {
    private Long id;
    private String type;
}