package com.smashsense.racketservice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RacketDTO {

    private String name;
    private String brand;
    private String weight;
    private String balance;
    private String price;
    private String pros;
    private String cons;
    private String image;

}
