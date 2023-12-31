package com.example.eco.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @OneToOne
    @JoinColumn(name = "ing_lat_id")
    private IngLat ingLat;
    @ManyToMany
    private List<Material> type;
    private String openTime;
    private String closeTime;
    private String title;
}
