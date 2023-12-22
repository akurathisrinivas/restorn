package com.example.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class SpringBootKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaDemoApplication.class, args);
	}

}
