package com.aquib.food_zone.controller;

import com.aquib.food_zone.dto.DonorRequest;
import com.aquib.food_zone.dto.DonorResponse;
import com.aquib.food_zone.entity.Donor;
import com.aquib.food_zone.service.DonorService;
import com.aquib.food_zone.service.FoodDonationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DonorController {
    private final FoodDonationService foodDonationService;
    private final DonorService donorService;

    public DonorController(FoodDonationService foodDonationService, DonorService donorService) {
        this.foodDonationService = foodDonationService;
        this.donorService = donorService;
    }



    @GetMapping("/api/donors/{id}")
    public Donor getDonor(@PathVariable int id){
        return donorService.getDonorById(id);
    }


    @PostMapping("/api/donors")
    public ResponseEntity<DonorResponse> postDonor(@Valid @RequestBody DonorRequest donorRequest){
        Donor donor = new Donor();
        donor.name = donorRequest.name;
        donor.city = donorRequest.city;

        Donor createdDonor = donorService.createDonor(donor);
        DonorResponse donorResponse = new DonorResponse();

        donorResponse.id = createdDonor.getId();
        donorResponse.name = createdDonor.name;
        donorResponse.city = createdDonor.city;

        return ResponseEntity
                .status(201)
                .body(donorResponse);
    }

    @GetMapping("/api/donors")
    public Collection<Donor> getAllDonors(Donor donor){
        return donorService.getAllDonors();
    }

}
