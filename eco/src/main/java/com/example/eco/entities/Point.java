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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ing_lat_id")
    private IngLat ingLat;
    @ElementCollection
    private List<String> type;
    private String openTime;
    private String closeTime;
    private String title;
    private String address;
}
