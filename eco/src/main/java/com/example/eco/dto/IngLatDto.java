package com.example.eco.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.example.eco.entities.IngLat}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngLatDto implements Serializable {
    private Long id;
    private Double cord1;
    private Double cord2;
}