package com.smashsense.racketservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.smashsense.racketservice.dto.RacketDTO;
import com.smashsense.racketservice.service.RacketService;

@RestController
@RequestMapping("/rackets")
public class RacketController {
    
    @Autowired
    private RacketService racketService;

    @GetMapping("/{id}")
    public List<RacketDTO> getAllRackets(@PathVariable Long id) {
        return racketService.getAllRackets();
    }

    @GetMapping("/brand/{brand}")
    public List<RacketDTO> getByBrand(@PathVariable String brand) {
        return racketService.getRacketByBrand(brand);
    }

    @PostMapping
    public RacketDTO addRacket(@RequestBody RacketDTO racketDTO) {
        return racketService.addRacket(racketDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteRacket(@PathVariable Long id) {
        racketService.deleteRacket(id);
    }

}
