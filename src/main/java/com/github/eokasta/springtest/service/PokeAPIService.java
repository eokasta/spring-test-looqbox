package com.github.eokasta.springtest.service;

import com.github.eokasta.springtest.model.PokemonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service("pokeAPIService")
public class PokeAPIService {

    @Autowired
    private WebClient webClient;

    public PokemonResponse getPokemons(final int limit) {
        return webClient.get().uri(String.format("/pokemon/?limit=%s", limit))
              .retrieve()
              .bodyToFlux(PokemonResponse.class)
              .blockFirst();
    }

}
