package com.github.eokasta.springtest;

import com.github.eokasta.springtest.service.impl.UpdateRepositoryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestApplication.class, args);
    }

    private final ScheduledExecutorService updateRepositorScheduler;

    private final UpdateRepositoryServiceImpl updateRepositoryService;
    
    
    public SpringTestApplication(UpdateRepositoryServiceImpl updateRepositoryService) {
        this.updateRepositoryService = updateRepositoryService;
        this.updateRepositorScheduler = Executors.newSingleThreadScheduledExecutor();
        updateRepositorScheduler.scheduleAtFixedRate(updateRepositoryService, 0, 10, TimeUnit.MINUTES);
    }


}
