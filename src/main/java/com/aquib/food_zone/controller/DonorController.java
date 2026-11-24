package com.aquib.food_zone.controller;

import com.aquib.food_zone.dto.DonorPatchRequest;
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
import java.util.List;

@RestController
public class DonorController {
    private final FoodDonationService foodDonationService;
    private final DonorService donorService;

    public DonorController(FoodDonationService foodDonationService, DonorService donorService) {
        this.foodDonationService = foodDonationService;
        this.donorService = donorService;
    }

    @GetMapping("/api/donors")
    public List<Donor> getAllDonors(){
        return donorService.getAllDonors();
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

    @PutMapping("/api/donors/{id}")
    public ResponseEntity<DonorResponse> updateDonor(
            @PathVariable int id,
            @Valid @RequestBody DonorRequest donorRequest) {

        Donor donor = new Donor();
        donor.name = donorRequest.name;
        donor.city = donorRequest.city;

        Donor updatedDonor = donorService.updateDonor(id, donor);

        DonorResponse response = new DonorResponse();
        response.id = updatedDonor.getId();
        response.name = updatedDonor.name;
        response.city = updatedDonor.city;

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/api/donors/{id}")
    public ResponseEntity<DonorResponse> patchDonor(
            @PathVariable int id,
            @Valid @RequestBody DonorPatchRequest donorPatchRequest) {

        Donor updatedDonor = donorService.patchDonor(id, donorPatchRequest);

        DonorResponse response = new DonorResponse();
        response.id = updatedDonor.getId();
        response.name = updatedDonor.name;
        response.city = updatedDonor.city;

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/api/donors/{id}")
    public ResponseEntity<Void> deleteDonor(@PathVariable int id) {
        donorService.deleteDonor(id);
        return ResponseEntity.noContent().build();
    }


}
