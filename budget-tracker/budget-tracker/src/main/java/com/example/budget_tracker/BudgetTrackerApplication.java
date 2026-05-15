package com.example.budgettracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.budgettracker")
public class BudgetTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BudgetTrackerApplication.class, args);
	}
}