package com.example.eco.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String title;

    String content;

    String theme;
}
