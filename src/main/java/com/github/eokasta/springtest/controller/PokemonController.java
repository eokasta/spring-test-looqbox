package com.github.eokasta.springtest.controller;

import com.github.eokasta.springtest.model.HighlightPokemon;
import com.github.eokasta.springtest.model.Pokemon;
import com.github.eokasta.springtest.model.PokemonDTO;
import com.github.eokasta.springtest.service.impl.PokemonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonServiceImpl service;

    public PokemonController(PokemonServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<PokemonDTO<String>> getPokemons(@RequestParam(required = false) String query) {
        final List<String> pokemons = service.getPokemons(query)
                .stream()
                .map(Pokemon::getName)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(new PokemonDTO<>(pokemons));
    }

    @GetMapping("/highlight")
    public ResponseEntity<PokemonDTO<HighlightPokemon>> getPokemonsHighlight(
            @RequestParam String query) {
        final List<HighlightPokemon> pokemons = service.getPokemonsHighlight(query);
        return ResponseEntity.ok().body(new PokemonDTO<>(pokemons));
    }

}

