package com.example.eco.dto;

import com.example.eco.entities.Point;
import jakarta.persistence.Transient;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

/**
 * DTO for {@link Point}
 */
@Value
public class PointDto implements Serializable {
    IngLatDto ingLat;
    @Transient
    List<MaterialDto> type;
    LocalTime openTime;
    LocalTime closeTime;
}