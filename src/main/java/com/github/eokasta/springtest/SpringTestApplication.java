package com.github.eokasta.springtest;

import com.github.eokasta.springtest.cache.PokemonCache;
import com.github.eokasta.springtest.service.PokeAPIService;
import com.github.eokasta.springtest.task.UpdateCacheTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringTestApplication {

    @Autowired
    private PokemonCache pokemonCache;

    @Autowired
    private PokeAPIService pokeAPIService;

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void onApplicationStartedEvent() {
        new UpdateCacheTask(pokemonCache, pokeAPIService).run();
    }

}
