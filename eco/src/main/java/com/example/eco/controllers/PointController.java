package com.example.eco.controllers;

import com.example.eco.dto.PointDto;
import com.example.eco.mappers.IngLatMapper;
import com.example.eco.mappers.PointMapper;
import com.example.eco.repositories.IngLatRepository;
import com.example.eco.repositories.PointRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"https://greenlink-368f3.web.app", "http://localhost:4200", "http://eko-ekb-front.website.yandexcloud.net","*"})
@RequestMapping("/point")
public class PointController {
    private final PointRepository pointRepository;
    private final PointMapper pointMapper;

    private final IngLatMapper ingLatMapper;
    private final IngLatRepository ingLatRepository;

    public PointController(PointRepository pointRepository, PointMapper pointMapper, IngLatMapper ingLatMapper, IngLatRepository ingLatRepository) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
        this.ingLatMapper = ingLatMapper;
        this.ingLatRepository = ingLatRepository;
    }

    @GetMapping("/get")
    public ResponseEntity<List<PointDto>> getAll() {
        return ResponseEntity.of(Optional.ofNullable((pointMapper.toDtos(pointRepository.findAll()))));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createPoint(@RequestBody PointDto pointDto) {
        pointRepository.save(pointMapper.toEntity(pointDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePoint(@PathVariable @Validated Long id) {
        pointRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
