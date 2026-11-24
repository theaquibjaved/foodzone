package com.aquib.food_zone.repositories;

import com.aquib.food_zone.entity.Donor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Integer> {
    Page<Donor> findByCityIgnoreCase(String city, Pageable pageable);
    Page<Donor> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Donor> findByNameAndCityIgnoreCase(String name, String city, Pageable pageable);
}
