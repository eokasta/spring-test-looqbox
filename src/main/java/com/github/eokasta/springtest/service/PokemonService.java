package com.github.eokasta.springtest.service;

import com.github.eokasta.springtest.cache.PokemonCache;
import com.github.eokasta.springtest.model.HighlightPokemon;
import com.github.eokasta.springtest.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("pokemonService")
public class PokemonService {

    @Autowired
    private PokeAPIService pokeAPIService;

    @Autowired
    private PokemonCache pokemonCache;

    public List<Pokemon> getPokemons(final String query) {
        final Map<String, Pokemon> pokemonMap = pokemonCache.getPokemonMap();
        final List<Pokemon> pokemons;

        if (query == null) {
            pokemons = new ArrayList<>(pokemonMap.values());
        } else {
            pokemons = pokemonMap.values()
                  .stream()
                  .filter(pokemon -> pokemon.getName().toLowerCase().startsWith(query.toLowerCase()))
                  .collect(Collectors.toList());
        }

        // TODO: apply sort

        return pokemons;
    }

    public List<HighlightPokemon> getPokemonsHighlight(final String query) {
        final List<HighlightPokemon> pokemons = getPokemons(query)
              .stream()
              .map(pokemon -> new HighlightPokemon(pokemon, formatWithHighlight(pokemon.getName(), query)))
              .collect(Collectors.toList());

        // TODO: apply sort

        return pokemons;
    }

    private String formatWithHighlight(final String pokemonName, final String query) {
        return pokemonName.replaceFirst("(?i)" + query, "<pre>" + query + "</pre>");
    }

}
