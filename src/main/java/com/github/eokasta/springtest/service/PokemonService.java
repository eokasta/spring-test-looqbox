package com.github.eokasta.springtest.service;

import com.github.eokasta.springtest.model.HighlightPokemon;
import com.github.eokasta.springtest.model.Pokemon;

import java.util.List;

public interface PokemonService {

    /**
     * Get list of {@link Pokemon}.
     *
     * @param query Query to filter pokemons.
     * @return If query is null, return all pokemons. If query is not null, return pokemons that name starts with query.
     */
    List<Pokemon> getPokemons(String query);

    /**
     * Get list of {@link HighlightPokemon}.
     *
     * @param query Query to filter pokemons.
     * @return If query is null, return null. If query is not null, return pokemons that name starts with query.
     */
    List<HighlightPokemon> getPokemonsHighlight(String query);

}
