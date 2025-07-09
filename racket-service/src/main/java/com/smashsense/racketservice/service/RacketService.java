package com.smashsense.racketservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smashsense.racketservice.dto.RacketDTO;
import com.smashsense.racketservice.exception.RacketNotFoundException;
import com.smashsense.racketservice.model.Racket;
import com.smashsense.racketservice.repository.RacketRepository;

@Service
public class RacketService {

    @Autowired
    private RacketRepository racketRepository;

    public List<RacketDTO> getAllRackets() {
        return racketRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public List<RacketDTO> getRacketById(Long id) {
        Racket racket = racketRepository.findById(id)
                .orElseThrow(() -> new RacketNotFoundException("Racket Not Found"));

        return List.of(mapToDTO(racket));
    }

    public List<RacketDTO> getRacketByBrand(String brand) {
        return racketRepository.findByBrandIgnoreCase(brand).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public RacketDTO addRacket(RacketDTO racketDto) {
        Racket racket = mapToEntity(racketDto);

        return mapToDTO(racketRepository.save(racket));
    }

    public String deleteRacket(Long id) {
        if (!racketRepository.existsById(id)) {
            throw new RacketNotFoundException("Racket not found with id: " + id);
        }
        racketRepository.deleteById(id);
        return "Racket deleted successfully.";
    }

    // Helper Functions
    // This method converts a Racket entity (from DB) to a RacketDTO (used for API
    // response or frontend)
    private RacketDTO mapToDTO(Racket racket) {
        return RacketDTO.builder() // Start building a new RacketDTO object using Lombok's builder pattern
                .name(racket.getName()) // Set the name from the Racket entity
                .brand(racket.getBrand()) // Set the brand (e.g., Yonex, Li-Ning)
                .weight(racket.getWeight()) // Set the weight (in grams, for example)
                .balance(racket.getBalance()) // Set the balance point (e.g., head-heavy, even-balance)
                .price(racket.getPrice()) // Set the price (as double or BigDecimal)
                .pros(racket.getPros()) // Set the list/string of pros (advantages of the racket)
                .cons(racket.getCons()) // Set the cons (disadvantages or drawbacks)
                .image(racket.getImage()) // Set the image URL of the racket
                .build(); // Finish building the RacketDTO and return it
    }

    private Racket mapToEntity(RacketDTO dto) {
        return Racket.builder()
                .name(dto.getName())
                .brand(dto.getBrand())
                .weight(dto.getWeight())
                .balance(dto.getBalance())
                .price(dto.getPrice())
                .pros(dto.getPros())
                .cons(dto.getCons())
                .image(dto.getImage())
                .build();
    }

}
