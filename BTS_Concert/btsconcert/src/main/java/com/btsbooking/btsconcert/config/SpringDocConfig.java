package com.btsbooking.btsconcert.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.*;

@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("BTS Concert Booking API")
                .version("1.0")
                .description("API for fans to book BTS concert tickets and view upcoming events"));
    }
}
