package com;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// spring 會自動掃描com底下的所有package 
//@ComponentScan(basePackages = "com.example")
//@ComponentScan(basePackages = "com.jpa")
public class Application {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logger.info("Debug log message");
	}
	
}
