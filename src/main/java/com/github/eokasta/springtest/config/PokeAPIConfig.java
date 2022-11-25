package com.github.eokasta.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PokeAPIConfig {

    @Bean
    public WebClient urlWebClient(WebClient.Builder builder) {
        return builder.baseUrl("https://pokeapi.co/api/v2").build();
    }

}
