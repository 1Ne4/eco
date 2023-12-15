package com.example.eco.controllers;

import com.example.eco.dto.IngLatDto;
import com.example.eco.dto.PointDto;
import com.example.eco.entities.IngLat;
import com.example.eco.entities.Point;
import com.example.eco.mappers.IngLatMapper;
import com.example.eco.mappers.PointMapper;
import com.example.eco.repositories.IngLatRepository;
import com.example.eco.repositories.PointRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PointController {
    PointRepository pointRepository;
    PointMapper pointMapper;

    IngLatMapper ingLatMapper;
    IngLatRepository ingLatRepository;

    public PointController(PointRepository pointRepository, PointMapper pointMapper, IngLatMapper ingLatMapper, IngLatRepository ingLatRepository) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
        this.ingLatMapper = ingLatMapper;
        this.ingLatRepository = ingLatRepository;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PointDto>> getAll() {
        return ResponseEntity.of(Optional.ofNullable((pointMapper.toDtos(pointRepository.findAll()))));
    }

    @PostMapping("CreatePoint")
    public ResponseEntity<Void> createPoint(IngLatDto ingLatDto) {
        IngLat ingLat = ingLatRepository.save(ingLatMapper.toEntity(ingLatDto));
        var point = new Point();
        point.setIngLat(ingLat);
        pointRepository.save(point);
        return ResponseEntity.ok().build();
    }
}
