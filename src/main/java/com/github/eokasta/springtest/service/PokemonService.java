package com.github.eokasta.springtest.service;

import com.github.eokasta.springtest.model.HighlightPokemon;
import com.github.eokasta.springtest.model.Pokemon;
import com.github.eokasta.springtest.util.SortUtil;

import java.util.List;

public interface PokemonService {

    List<Pokemon> getPokemons(String query, SortUtil.Type sortType);

    List<HighlightPokemon> getPokemonsHighlight(String query, SortUtil.Type sortType);

    /**
     * Get list of {@link Pokemon}.
     *
     * @param query Query to filter pokemons.
     * @param sort sort type name.
     * @return If query is null, return all pokemons. If query is not null, return pokemons that name starts with query.
     */
    List<Pokemon> getPokemons(String query, String sort);

    /**
     * Get list of {@link HighlightPokemon}.
     *
     * @param query Query to filter pokemons.
     * @param sort sort type name.
     * @return If query is null, return null. If query is not null, return pokemons that name starts with query.
     */
    List<HighlightPokemon> getPokemonsHighlight(String query, String sort);

}
