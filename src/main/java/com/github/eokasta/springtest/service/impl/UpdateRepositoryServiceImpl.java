package com.github.eokasta.springtest.service.impl;

import com.github.eokasta.springtest.client.PokeAPIClient;
import com.github.eokasta.springtest.model.PokemonResponse;
import com.github.eokasta.springtest.repository.PokemonRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateRepositoryServiceImpl implements Runnable {

    private final PokemonRepository pokemonRepository;
    private final PokeAPIClient pokeAPIClient;

    public UpdateRepositoryServiceImpl(PokemonRepository pokemonRepository, PokeAPIClient pokeAPIClient) {
        this.pokemonRepository = pokemonRepository;
        this.pokeAPIClient = pokeAPIClient;
    }

    @Override
    public void run() {
        pokeAPIClient.getPokemons(100000).subscribe(this::updateCache);
    }

    private void updateCache(PokemonResponse response) {
        pokemonRepository.update(response);
    }

}
