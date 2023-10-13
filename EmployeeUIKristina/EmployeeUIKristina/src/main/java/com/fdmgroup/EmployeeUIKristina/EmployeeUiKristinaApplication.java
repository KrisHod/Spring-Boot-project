package com.fdmgroup.EmployeeUIKristina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class EmployeeUiKristinaApplication {

	private static final String BASE_URL = "http://localhost:8085";

	public static void main(String[] args) {
		SpringApplication.run(EmployeeUiKristinaApplication.class, args);
	}

	@Bean
	public WebClient.Builder builder() {
		return WebClient.builder();
	}

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl(BASE_URL).defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();
	}

}
