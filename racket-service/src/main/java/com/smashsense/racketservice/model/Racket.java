package com.smashsense.racketservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity // This tells the spring boot(via JPA) that this class is a database entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Allows me to construct the Racket Object
public class Racket {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String weight;
    private String balance;
    private String price;
    private String pros;
    private String cons;
    private String image;

}
