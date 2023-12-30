package com.example.eco.dto;

import com.example.eco.entities.Point;
import jakarta.persistence.Transient;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Point}
 */
@Data
public class PointDto implements Serializable {
    private Long id;
    private IngLatDto ingLat;
    @Transient
    private List<MaterialDto> type;
    private String openTime;
    private String closeTime;
    private String title;
}