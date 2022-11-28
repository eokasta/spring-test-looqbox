package com.github.eokasta.springtest;

import com.github.eokasta.springtest.model.Pokemon;
import com.github.eokasta.springtest.util.SortUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


final class SpringTestApplicationTests {

    private static Logger logger;
    private static List<Pokemon> pokemonList;

    @BeforeAll
    static void load() {
        logger = LogManager.getLogger(SpringTestApplicationTests.class);
        pokemonList = new ArrayList<>();

        pokemonList.add(new Pokemon("Pikachu"));
        pokemonList.add(new Pokemon("Charmander"));
        pokemonList.add(new Pokemon("Bulbassaur"));
        pokemonList.add(new Pokemon("Mewtwo"));
    }

    @Test
    void alphabeticalSortTest() {
        sort(SortUtil.Type.ALPHABETICAL);
    }

    @Test
    void lengthSortTest() {
        sort(SortUtil.Type.LENGTH);
    }

    private void sort(SortUtil.Type sortType) {
        logger.info("Sorting with " + sortType.name() + ": " +
                pokemonList.stream().map(Pokemon::getName).collect(Collectors.joining(", ")));

        final long beforeMillis = System.currentTimeMillis();
        final List<Pokemon> sortedList = SortUtil.sort(pokemonList, sortType);
        final long afterMillis = System.currentTimeMillis();

        logger.info("Sorted with " + sortType.name() + ": " +
                sortedList.stream().map(Pokemon::getName).collect(Collectors.joining(", ")));
        logger.info("Sort time: " + (afterMillis - beforeMillis) + "ms.");
    }

}
