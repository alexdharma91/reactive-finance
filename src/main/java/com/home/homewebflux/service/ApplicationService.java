package com.home.homewebflux.service;

import com.home.homewebflux.model.dao.ApplicationRepository;
import com.home.homewebflux.model.entity.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ScoringService scoringService;
    private final DirectProcessor<Application> applicationDirectProcessor;

    public Mono<Application> createNewApplication(Mono<Application> monoApplication) {
         return monoApplication.doOnNext(applicationDirectProcessor::onNext);
    }

    public Mono<Application> save(Application application) {
        System.out.println("Create new application!");

        application.setScoringResult(scoringService.validate(application));
        application.setProcessedDateTime(LocalDateTime.now());
        return applicationRepository.save(application);
    }

}
