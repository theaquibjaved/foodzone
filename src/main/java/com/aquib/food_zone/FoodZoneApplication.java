package com.aquib.food_zone;

import com.aquib.food_zone.service.FoodDonationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodZoneApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodZoneApplication.class, args);
	}

}
