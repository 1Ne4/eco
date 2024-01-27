package com.example.eco.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@Entity
public class IngLat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double cord1;
    private Double cord2;
}