package com.example.eco.dto;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.eco.entities.News}
 */
@Data
public class NewsDto implements Serializable {
    private Long id;
    private String title;
    private String content;
    private String theme;
}