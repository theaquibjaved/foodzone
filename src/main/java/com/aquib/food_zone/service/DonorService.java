package com.aquib.food_zone.service;

import com.aquib.food_zone.entity.Donor;
import com.aquib.food_zone.exception.DonorNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DonorService {
    final private Map<Integer, Donor> donors = new HashMap<>();
    private int id = 1;

    public Donor getDonorById(int id) {
        Donor donor = donors.get(id);

        if(donor == null)
            throw new DonorNotFoundException("Donor with ID "+id+" not found.");
        return donor;
    }

    public Donor createDonor(Donor donor){
        donor.setId(id);
        donors.put(this.id, donor);
        this.id++;
        return donor;
    }

    public Collection<Donor> getAllDonors() {
        return donors.values();
    }
}
