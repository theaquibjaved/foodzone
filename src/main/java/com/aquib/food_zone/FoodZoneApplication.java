package com.aquib.food_zone;

import com.aquib.food_zone.service.FoodDonationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FoodZoneApplication {

//	@Bean
//	CommandLineRunner runner(FoodDonationService service) {
//		return args -> System.out.println(service.donationServiceMesasge());
//	}

	public static void main(String[] args) {
		SpringApplication.run(FoodZoneApplication.class, args);
	}

}
