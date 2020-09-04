package com.pulawskk.dbsgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class LocalHostRouteConfig {

    @Bean
    public RouteLocator localHostRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/burgers/*", "/api/v1/burgers")
                    .uri("http://localhost:8882")
                    .id("dbs-food"))
                .route(r -> r.path("/api/v1/orders")
                    .uri("http://localhost:8884")
                    .id("dbs-order"))
                .build();
    }
}
