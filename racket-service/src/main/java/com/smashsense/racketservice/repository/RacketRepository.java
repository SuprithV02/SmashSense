package com.smashsense.racketservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smashsense.racketservice.model.Racket;

public interface RacketRepository extends JpaRepository<Racket, Long> {
    List<Racket> findByBrandIgnoreCase(String brand);
}
