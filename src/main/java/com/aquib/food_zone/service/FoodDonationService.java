package com.aquib.food_zone.service;

import org.springframework.stereotype.Service;

@Service
public class FoodDonationService {

    private final DonorService donorService;

    public FoodDonationService(DonorService donorService) {
        this.donorService = donorService;
    }


}
