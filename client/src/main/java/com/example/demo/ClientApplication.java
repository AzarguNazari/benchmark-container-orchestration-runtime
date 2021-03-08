package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
public class ClientApplication implements ApplicationRunner {

	private static Logger LOGGER = LoggerFactory.getLogger(ClientApplication.class);

	@Value("${application.monitor.address}")
	private String monitorAddress;
	@Value("${application.monitor.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> request = new HttpEntity<>(System.currentTimeMillis() + "");
		ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://" + monitorAddress + ":" + port + "/hello", request, String.class);
		System.out.println("Message sent status: " + stringResponseEntity.getStatusCode());
	}
}
