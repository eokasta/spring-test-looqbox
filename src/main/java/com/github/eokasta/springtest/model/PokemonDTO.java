package com.github.eokasta.springtest.model;

import java.io.Serializable;
import java.util.List;

public record PokemonDTO<T>(List<T> result) implements Serializable {

}