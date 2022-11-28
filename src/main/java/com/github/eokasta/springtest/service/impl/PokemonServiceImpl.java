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

    public List<Pokemon> getPokemons(String query) {
        final List<Pokemon> pokemons;

        if (query == null) {
            pokemons = pokemonRepository.getAll();
        } else {
            pokemons = pokemonRepository.getByNameWithContains(query);
        }

        return SortUtil.sort(pokemons, SortUtil.Type.ALPHABETICAL);
    }

    public List<HighlightPokemon> getPokemonsHighlight(String query) {
        return getPokemons(query)
                .stream()
                .map(pokemon -> new HighlightPokemon(pokemon, StringUtil.formatWithHighlight(pokemon.getName(), query)))
                .toList();
    }

}
