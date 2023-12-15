package com.example.eco.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.eco.entities.IngLat}
 */
@Value
public class IngLatDto implements Serializable {
    Double cord1;
    Double cord2;
}