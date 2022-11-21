package com.example.banabada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BanabadaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanabadaApplication.class, args);
	}

}
