package com.github.eokasta.springtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class PokemonResponse implements Serializable {

    @JsonProperty("results")
    private List<Pokemon> pokemons;

    public PokemonResponse() {
    }

    public PokemonResponse(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
