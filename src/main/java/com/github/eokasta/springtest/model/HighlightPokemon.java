package com.github.eokasta.springtest.model;

import java.io.Serializable;

public class HighlightPokemon implements Serializable {

    private Pokemon pokemon;
    private String highlight;

    public HighlightPokemon() {
    }

    public HighlightPokemon(Pokemon pokemon, String highlight) {
        this.pokemon = pokemon;
        this.highlight = highlight;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public String getHighlight() {
        return highlight;
    }

    public void setHighlight(String highlight) {
        this.highlight = highlight;
    }
}
