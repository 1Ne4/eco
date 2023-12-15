package com.example.eco.repositories;

import com.example.eco.entities.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Long> {
}