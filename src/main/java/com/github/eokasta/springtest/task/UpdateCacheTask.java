package com.github.eokasta.springtest.task;

import com.github.eokasta.springtest.cache.PokemonCache;
import com.github.eokasta.springtest.model.Pokemon;
import com.github.eokasta.springtest.model.PokemonResponse;
import com.github.eokasta.springtest.service.PokeAPIService;

import java.util.Map;

public class UpdateCacheTask implements Runnable {

    private final PokemonCache pokemonCache;
    private final PokeAPIService pokeAPIService;

    public UpdateCacheTask(PokemonCache pokemonCache, PokeAPIService pokeAPIService) {
        this.pokemonCache = pokemonCache;
        this.pokeAPIService = pokeAPIService;
    }

    @Override
    public void run() {
        final Map<String, Pokemon> pokemonMap = this.pokemonCache.getPokemonMap();

        final PokemonResponse response = pokeAPIService.getPokemons(100000);
        response.getPokemons().forEach(pokemon -> pokemonMap.put(pokemon.getName(), pokemon));
    }

}
