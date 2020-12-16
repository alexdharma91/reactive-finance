package com.home.homewebflux.controller;

import com.home.homewebflux.dto.ApplicationDto;
import com.home.homewebflux.model.entity.Application;
import com.home.homewebflux.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping("create")
    public Mono<Application> createApplication(Mono<ApplicationDto> applicationDtoMono) {
        return applicationService.createNewApplication(applicationDtoMono.flatMap(dto -> Mono.just(Application.fromDto(dto))));
    }
}
