package com.github.eokasta.springtest.client;

import com.github.eokasta.springtest.model.PokemonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PokeAPIClient {

    private final WebClient webClient;

    public PokeAPIClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<PokemonResponse> getPokemons(int limit) {
        return webClient.get().uri(String.format("/pokemon/?limit=%s", limit))
                .retrieve()
                .bodyToMono(PokemonResponse.class);
    }

}
