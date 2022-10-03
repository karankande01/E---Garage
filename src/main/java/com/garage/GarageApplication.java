package com.garage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.garage.controller","com.garage.service"})
@EntityScan("com.garage.model")
@EnableJpaRepositories("com.garage.repository")
public class GarageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GarageApplication.class, args);
	}

}
