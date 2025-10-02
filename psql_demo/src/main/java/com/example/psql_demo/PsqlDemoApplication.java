package com.example.psql_demo;

import com.example.psql_demo.ops.carOps;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PsqlDemoApplication {

	@Autowired
	private carOps operations;

	public static void main(String[] args) {
		SpringApplication.run(PsqlDemoApplication.class, args);
	}

	@PostConstruct
	public void triggerOps(){
		operations.setCarData();
		operations.getCarData();
		operations.updateCar();
		operations.deleteCar();
	}
}
