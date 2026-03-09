package com.handson.labs.graphql.configuration;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
@Slf4j
public class LogFrequentlyBeanExample {

    @Scheduled(fixedDelay = 5L, timeUnit = TimeUnit.SECONDS)
    public String testScheduling() {
        String scheduledMessage = "Hello, I will run continuously every 5 seconds";
        log.info(scheduledMessage);
        return scheduledMessage;
    }
}
