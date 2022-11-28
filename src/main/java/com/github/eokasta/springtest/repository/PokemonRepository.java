package com.github.eokasta.springtest.repository;

import com.github.eokasta.springtest.model.Pokemon;
import com.github.eokasta.springtest.model.PokemonResponse;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PokemonRepository {

    private final Map<String, Pokemon> pokemonMap;

    public PokemonRepository() {
        this.pokemonMap = new LinkedHashMap<>();
    }

    public List<Pokemon> getByNameWithContains(String name) {
        if (name == null || name.isBlank()) {
            return null;
        }

        return pokemonMap.values()
                .stream()
                .filter(pokemon -> pokemon.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    public List<Pokemon> getAll() {
        return pokemonMap.values().stream().toList();
    }

    public void insert(Pokemon pokemon) {
        pokemonMap.put(pokemon.getName(), pokemon);
    }

    public void update(PokemonResponse response) {
        pokemonMap.clear();
        response.getPokemons().forEach(this::insert);
    }

}
