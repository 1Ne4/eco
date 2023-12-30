package com.example.eco.controllers;

import com.example.eco.dto.NewsDto;
import com.example.eco.mappers.NewsMapper;
import com.example.eco.repositories.NewsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"https://greenlink-368f3.web.app", "localhost:4200", "http://eko-ekb-front.website.yandexcloud.net"})
@RequestMapping("/news")
public class NewsController {
    private final NewsRepository newsRepository;
    private final NewsMapper newsMapper;

    public NewsController(NewsRepository newsRepository, NewsMapper newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    @GetMapping("/get")
    public ResponseEntity<List<NewsDto>> getAll() {
        return ResponseEntity.of(Optional.ofNullable((newsMapper.toDtos(newsRepository.findAll()))));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createNews(@RequestBody NewsDto newsDto) {
        newsRepository.save(newsMapper.toEntity(newsDto));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable @Validated Long id) {
        newsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
