package com.pulawskk.dbsgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local-discovery")
public class LoadBalancedRoutesConfig {

    @Bean
    public RouteLocator loadBalancedRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/burgers/*", "/api/v1/burgers")
                        .uri("lb://dbs-food")
                        .id("dbs-food"))
                .route(r -> r.path("/api/v1/orders")
                        .uri("lb://dbs-order")
                        .id("dbs-order"))
                .build();
    }
}
