package com.example.eco.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String type;
}
