package com.home.homewebflux.configuration;

import com.home.homewebflux.ApplicationGenerator;
import com.home.homewebflux.model.entity.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Configuration
@ConditionalOnProperty(value = "application.artificial.enabled", havingValue = "true")
public class ArtificialApplicationsConfiguration {

    @Value("${application.artificial.duration.count}")
    private int durationCount;

    @Value("${application.artificial.duration.type}")
    private ChronoUnit durationType;

    @Autowired
    private DirectProcessor<Application> applicationDirectProcessor;

    @Bean
    public Duration delayElementsDuration() {
        switch (durationType) {
            case DAYS: return Duration.ofDays(durationCount);
            case HOURS: return Duration.ofHours(durationCount);
            case NANOS: return Duration.ofNanos(durationCount);
            case MILLIS: return Duration.ofMillis(durationCount);
            case MINUTES: return Duration.ofMinutes(durationCount);
            case SECONDS: return Duration.ofSeconds(durationCount);
            default: return Duration.ofSeconds(durationCount);
        }
    }

    @Bean
    public Flux<Application> applicationsStream() {
        return Flux.generate((SynchronousSink<Application> synchronousSink) -> {
            synchronousSink.next(ApplicationGenerator.generateApplication());
        }).delayElements(delayElementsDuration());
    }

    @Bean
    public void pipeline() {
        applicationsStream()
                .doOnNext(i -> applicationDirectProcessor.onNext(i))
                .subscribe();
    }

}
