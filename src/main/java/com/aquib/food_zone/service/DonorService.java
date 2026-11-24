package com.aquib.food_zone.service;

import com.aquib.food_zone.dto.DonorPatchRequest;
import com.aquib.food_zone.entity.Donor;
import com.aquib.food_zone.exception.DonorNotFoundException;
import com.aquib.food_zone.repositories.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {
    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(int id) {
        return donorRepository.findById(id)
                .orElseThrow(() ->  new DonorNotFoundException("Donor with ID "+id+" not found."));
    }

    public Donor createDonor(Donor donor){
        return donorRepository.save(donor);
    }

    public Donor updateDonor(int id, Donor donor) {
        Donor existingDonor = getDonorById(id);

        existingDonor.name = donor.name;
        existingDonor.city = donor.city;

        return donorRepository.save(existingDonor);
    }

    public Donor patchDonor(int id, DonorPatchRequest request) {
        Donor existingDonor = getDonorById(id);

        if(request.name != null)
            existingDonor.name = request.name;

        if(request.city != null)
            existingDonor.city = request.city;

        return donorRepository.save(existingDonor);
    }

    public void deleteDonor(int id) {
        Donor donor = getDonorById(id);
        donorRepository.delete(donor);
    }
}
