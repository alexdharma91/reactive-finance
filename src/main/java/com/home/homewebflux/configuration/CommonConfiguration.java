package com.home.homewebflux.configuration;

import com.home.homewebflux.model.entity.Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.DirectProcessor;

@Configuration
public class CommonConfiguration {

    @Bean
    public DirectProcessor<Application> applicationDirectProcessor() {
        final DirectProcessor<Application> directProcessor = DirectProcessor.create();

        directProcessor.doOnNext(i -> System.out.println("step1"))
                .doOnNext(i -> System.out.println("step2"))
                .doOnNext(i -> System.out.println("step3")).subscribe();

        return directProcessor;
    }

}
