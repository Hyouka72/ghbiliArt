package com.khewang.ghbiliapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GhbiliapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GhbiliapiApplication.class, args);
	}

}
