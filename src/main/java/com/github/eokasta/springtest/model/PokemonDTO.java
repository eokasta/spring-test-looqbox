package com.github.eokasta.springtest.model;

import java.io.Serializable;
import java.util.List;

public class PokemonDTO<T> implements Serializable {

    private List<T> result;

    public PokemonDTO() {

    }

    public PokemonDTO(List<T> result) {
        this.result = result;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
