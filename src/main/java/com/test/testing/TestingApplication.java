package com.test.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import java.util.List;

@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) {
		// SpringApplication.run(TestingApplication.class, args);
		
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://devbackerp.teljoy.io:6443/aianalytics/ziwoCall/filter/page?page=0&size=20&callerNumbers=%2B971504018903&ids=2979924";
		
		try {
			ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
			System.out.println("Response Status: " + response.getStatusCode());
			
			Map<String, Object> responseBody = response.getBody();
			if (responseBody != null) {
				System.out.println("Content:");
				List<Map<String, Object>> content = (List<Map<String, Object>>) responseBody.get("content");
				for (Map<String, Object> item : content) {
					System.out.println(item);
				}
				
				System.out.println("\nPageable:");
				Map<String, Object> pageable = (Map<String, Object>) responseBody.get("pageable");
				System.out.println(pageable);
			}
		} catch (Exception e) {
			System.out.println("Error occurred: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
