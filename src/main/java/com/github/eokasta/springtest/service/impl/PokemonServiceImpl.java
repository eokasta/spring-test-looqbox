package com.github.eokasta.springtest.service.impl;

import com.github.eokasta.springtest.model.HighlightPokemon;
import com.github.eokasta.springtest.model.Pokemon;
import com.github.eokasta.springtest.repository.PokemonRepository;
import com.github.eokasta.springtest.service.PokemonService;
import com.github.eokasta.springtest.util.SortUtil;
import com.github.eokasta.springtest.util.StringUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getPokemons(String query, SortUtil.Type sortType) {
        final List<Pokemon> pokemons;

        if (query == null) {
            pokemons = pokemonRepository.getAll();
        } else {
            pokemons = pokemonRepository.getByNameWithContains(query);
        }

        return SortUtil.sort(pokemons, sortType);
    }

    @Override
    public List<HighlightPokemon> getPokemonsHighlight(String query, SortUtil.Type sortType) {
        return toHighlightPokemonList(query, getPokemons(query, sortType));
    }

    public List<Pokemon> getPokemons(String query, String sort) {
        SortUtil.Type sortType = SortUtil.Type.ALPHABETICAL;
        if (sort != null) {
            try {
                sortType = SortUtil.Type.valueOf(sort.toUpperCase());
            } catch (IllegalArgumentException exception) {
                throw new IllegalStateException("Could not find sort type: " + sort, exception);
            }
        }

        return getPokemons(query, sortType);
    }

    public List<HighlightPokemon> getPokemonsHighlight(String query, String sort) {
        return toHighlightPokemonList(query, getPokemons(query, sort));
    }

    private List<HighlightPokemon> toHighlightPokemonList(String query, List<Pokemon> pokemons) {
        return pokemons
                .stream()
                .map(pokemon -> new HighlightPokemon(pokemon, StringUtil.formatWithHighlight(pokemon.getName(), query)))
                .toList();
    }

}
