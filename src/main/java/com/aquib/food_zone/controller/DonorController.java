package com.aquib.food_zone.controller;

import com.aquib.food_zone.dto.DonorRequest;
import com.aquib.food_zone.dto.DonorResponse;
import com.aquib.food_zone.entity.Donor;
import com.aquib.food_zone.service.FoodDonationService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class DonorController {
    private final FoodDonationService foodDonationService;

    public DonorController(FoodDonationService foodDonationService) {
        this.foodDonationService = foodDonationService;
    }

    @GetMapping("/test")
    public String test(){
        return foodDonationService.donationServiceMesasge();
    }

    @GetMapping("/api/donors/{id}")
    public String getDonor(@PathVariable String id){
        return id;
    }

    @GetMapping("/api/donors")
    public String getCity(@RequestParam String city){
        return city;
    }

    @PostMapping("/api/donors")
    public ResponseEntity<Donor> postDonor(@RequestBody Donor donor){

        return ResponseEntity
                .status(201)
                .body(donor);
    }

}
