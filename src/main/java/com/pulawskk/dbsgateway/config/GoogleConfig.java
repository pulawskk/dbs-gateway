package com.pulawskk.dbsgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class GoogleConfig {

    @Bean
    RouteLocator googleRouteConfig(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/googlesearch")
                        .filters(f -> f.rewritePath("/googlesearch(?<segment>/?.*)", "/${segment}"))
                        .uri("https://www.google.com")
                        .id("google"))
                .build();
    }
}
