package com.dsw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Dsw2Application {

	public static void main(String[] args) {
		SpringApplication.run(Dsw2Application.class, args);
	}

}
