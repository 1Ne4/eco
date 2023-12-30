package com.example.eco.controllers;

import com.example.eco.dto.MaterialDto;
import com.example.eco.mappers.MaterialMapper;
import com.example.eco.repositories.MaterialRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"https://greenlink-368f3.web.app", "localhost:4200", "http://eko-ekb-front.website.yandexcloud.net"})
@RequestMapping("/material")
public class MaterialController {
    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    public MaterialController(MaterialRepository materialRepository, MaterialMapper materialMapper) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
    }


    @GetMapping("/get")
    public ResponseEntity<List<MaterialDto>> getAll() {
        return ResponseEntity.of(Optional.ofNullable((materialMapper.toDtos(materialRepository.findAll()))));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createMaterial(@RequestBody MaterialDto materialDto) {
        materialRepository.save(materialMapper.toEntity(materialDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable @Validated Long id) {
        materialRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
