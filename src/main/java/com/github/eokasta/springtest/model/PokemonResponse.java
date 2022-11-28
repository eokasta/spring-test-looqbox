package com.github.eokasta.springtest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public record PokemonResponse(@JsonProperty("results") List<Pokemon> pokemonList) {

}
