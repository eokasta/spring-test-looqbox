package com.github.eokasta.springtest.client;

import com.github.eokasta.springtest.model.PokemonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * This class is used to get all pokemons from PokeAPI.
 */
@Service
public class PokeAPIClient {

    private final WebClient webClient;

    public PokeAPIClient(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Get the pokemons from PokeAPI.
     *
     * @param limit of pokemon.
     * @return response of query.
     */
    public Mono<PokemonResponse> getPokemons(int limit) {
        return webClient.get().uri(String.format("/pokemon/?limit=%s", limit))
                .retrieve()
                .bodyToMono(PokemonResponse.class);
    }

}
