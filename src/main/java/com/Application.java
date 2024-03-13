package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// spring 會自動掃描com底下的所有package
//@ComponentScan(basePackages = "com.example")
//@ComponentScan(basePackages = "com.jpa")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
