package com.social_backend.social;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.social_backend.social","com.social_backend.social.config"})
public class SocialApplication {

	public static void main(String[] args) {

        SpringApplication.run(SocialApplication.class, args);
	}

}
