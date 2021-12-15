package com.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEurekaClient
public class APIGatewayConfig {
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder)
	{
		return routeLocatorBuilder.routes()
				.route(p ->p
                        .path("/admin/all")
                        .uri("http://localhost:8081"))
				.route(p ->p
						.path("/admin/{flightNo}")
						.uri("http://localhost:8081"))
				.route(p ->p
						.path("/admin/add")
						.uri("http://localhost:8081"))
				.route(p ->p
						.path("/admin/update/{flightNo}")
						.uri("http://localhost:8081"))
				.route(p ->p
						.path("/admin/delete/{flightNo}")
						.uri("http://localhost:8081"))
				.route(p ->p
						.path("/admin/updateSeats/{flightNo}/{noOfPassengers}")
						.uri("http://localhost:8081"))
		       .build();
	}
	
	@Bean
	public RouteLocator myRoutes1(RouteLocatorBuilder routeLocatorBuilder)
	{
		return routeLocatorBuilder.routes()
				.route(p ->p
                        .path("/user/allflights")
                        .uri("http://localhost:8084"))
				.route(p ->p
                        .path("/user/status/{pnrNo}")
                        .uri("http://localhost:8084"))
				.route(p ->p
                        .path("/user/flightNo/{flightNo}")
                        .uri("http://localhost:8084"))
				.route(p ->p
                        .path("/user/{startPoint}/{endPoint}")
                        .uri("http://localhost:8084"))
		       .build();
	}
	
	@Bean
	public RouteLocator myRoutes2(RouteLocatorBuilder routeLocatorBuilder)
	{
		return routeLocatorBuilder.routes()
				.route(p ->p
                        .path("/user/all")
                        .uri("http://localhost:8082"))
				.route(p ->p
                        .path("/user/get/{pnrNo}")
                        .uri("http://localhost:8082"))
				.route(p ->p
                        .path("/user/book/add")
                        .uri("http://localhost:8082"))
				.route(p ->p
                        .path("/user/cancel/{pnrNo}")
                        .uri("http://localhost:8082"))
		       .build();
	}

	@Bean
	public RouteLocator myRoutes3(RouteLocatorBuilder routeLocatorBuilder)
	{
		return routeLocatorBuilder.routes()
				.route(p ->p
                        .path("/pay/all")
                        .uri("http://localhost:8083"))
				.route(p ->p
                        .path("/pay/add")
                        .uri("http://localhost:8083"))
				.route(p ->p
                        .path("/pay/cancel/{pnrNo}")
                        .uri("http://localhost:8083"))
		       .build();
	}
	
	@Bean
	public RouteLocator myRoutes4(RouteLocatorBuilder routeLocatorBuilder)
	{
		return routeLocatorBuilder.routes()
				.route(p ->p
                        .path("/checkIn/get/checkin/{pnrNo}")
                        .uri("http://localhost:8086"))
		       .build();
	}
}
