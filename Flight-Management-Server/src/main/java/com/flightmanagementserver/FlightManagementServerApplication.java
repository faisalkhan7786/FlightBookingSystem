package com.flightmanagementserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class FlightManagementServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementServerApplication.class, args);
	}
}