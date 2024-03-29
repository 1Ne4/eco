package com.example.eco.dto;

import com.example.eco.entities.Point;
import javax.persistence.*;
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
    @ElementCollection
    private List<String> type;
    private String openTime;
    private String closeTime;
    private String title;
    private String address;
}