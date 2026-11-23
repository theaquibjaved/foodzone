package com.aquib.food_zone.dto;

import jakarta.validation.constraints.NotBlank;

public class DonorRequest {
    @NotBlank
    public String name;
    @NotBlank
    public String city;
}
