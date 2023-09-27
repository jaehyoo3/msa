package com.msa.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CustormersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustormersApplication.class, args);
	}

}
