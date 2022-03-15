package com.microservices.gateway;

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class RouteLocator {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return (RouteLocator) builder.routes()
                .route("microservicesApi", r -> r.path("/api/usuario/login")
                        .uri("lb://microserviceApi"))
                .build();
    }
}
