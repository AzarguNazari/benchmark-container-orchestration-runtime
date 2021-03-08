package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MonitorApp {

	private int total = 0;
	private String lastReceived;

	@Value("${initialTime}")
	private long initialTime;

	public static void main(String[] args) {
		SpringApplication.run(MonitorApp.class, args);
	}

	@PostMapping("/hello")
	public void receive(@RequestBody String received){
		lastReceived = received;
		total ++;
		System.out.println("Total: " + total + " | " + initialTime + " | time: " + lastReceived + " | totalTime = " + (Long.valueOf(received) - initialTime));
	}

}
