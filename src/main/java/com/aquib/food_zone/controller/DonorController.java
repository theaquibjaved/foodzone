package com.aquib.food_zone.controller;

import com.aquib.food_zone.dto.DonorPatchRequest;
import com.aquib.food_zone.dto.DonorRequest;
import com.aquib.food_zone.dto.DonorResponse;
import com.aquib.food_zone.entity.Donor;
import com.aquib.food_zone.service.DonorService;
import com.aquib.food_zone.service.FoodDonationService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Page<DonorResponse> getAllDonors(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String name,
            Pageable pageable){

        Page<Donor> donors = null;

        if (city != null && !city.isBlank() && name != null && !name.isBlank()) {
            donors =  donorService.getDonorsByNameAndCity(name, city, pageable);
        } else if(city != null && !city.isBlank()){
            donors =  donorService.getDonorsByCity(city, pageable);
        } else if(name != null && !name.isBlank()){
            donors =  donorService.getDonorsByName(name, pageable);
        } else {
            donorService.getAllDonors(pageable);
        }

        return donors.map(donor -> {
            DonorResponse response = new DonorResponse();
            response.id = donor.getId();
            response.name = donor.name;
            response.city = donor.city;
            return response;
                }
        );
    }

    @GetMapping("/api/donors/{id}")
    public DonorResponse getDonor(@PathVariable int id){
        Donor donor = donorService.getDonorById(id);
        DonorResponse donorResponse = new DonorResponse();
        donorResponse.id = donor.getId();
        donorResponse.name = donor.name;
        donorResponse.city = donor.city;
        return donorResponse;
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
