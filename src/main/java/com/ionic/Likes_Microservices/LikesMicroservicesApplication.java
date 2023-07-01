package com.ionic.Likes_Microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class
LikesMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LikesMicroservicesApplication.class, args);
	}

}
