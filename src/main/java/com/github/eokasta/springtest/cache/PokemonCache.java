package com.github.eokasta.springtest.cache;

import com.github.eokasta.springtest.model.Pokemon;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class PokemonCache {

    private final Map<String, Pokemon> pokemonMap;

    public PokemonCache() {
        this.pokemonMap = new LinkedHashMap<>();
    }

    public Map<String, Pokemon> getPokemonMap() {
        return pokemonMap;
    }
}
