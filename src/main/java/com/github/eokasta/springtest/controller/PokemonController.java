package com.github.eokasta.springtest.controller;

import com.github.eokasta.springtest.model.HighlightPokemon;
import com.github.eokasta.springtest.model.Pokemon;
import com.github.eokasta.springtest.model.PokemonDTO;
import com.github.eokasta.springtest.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/pokemons")
@RestController
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping
    public ResponseEntity<PokemonDTO<String>> getPokemons(@RequestParam(required = false, name = "name") String name) {
        final List<String> pokemons = service.getPokemons(name)
              .stream()
              .map(Pokemon::getName)
              .collect(Collectors.toList());
        return ResponseEntity.ok().body(new PokemonDTO<>(pokemons));
    }

    @GetMapping("/highlight")
    public ResponseEntity<PokemonDTO<HighlightPokemon>> getPokemonsHighlight(@RequestParam(required = false, name = "name") String name) {
        final List<HighlightPokemon> pokemons = service.getPokemonsHighlight(name);
        return ResponseEntity.ok().body(new PokemonDTO<>(pokemons));
    }

}
