package com.example.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class ServerApplication {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		SpringApplication.run(ServerApplication.class, args);
	}
}
