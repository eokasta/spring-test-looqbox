package com.github.eokasta.springtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class PokeAPIConfig {

    /**
     * Build WebClient with base url of PokeAPI.
     *
     * @param builder the WebClient builder
     * @return the WebClient with base url defined
     */
    @Bean
    public WebClient buildWebClient(WebClient.Builder builder) {
        return builder.baseUrl("https://pokeapi.co/api/v2").build();
    }

}
