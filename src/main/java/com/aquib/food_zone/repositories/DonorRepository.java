package com.aquib.food_zone.repositories;

import com.aquib.food_zone.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Integer> {
}
