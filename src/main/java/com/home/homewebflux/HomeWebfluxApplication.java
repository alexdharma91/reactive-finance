package com.home.homewebflux;

import com.home.homewebflux.model.entity.Application;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.DirectProcessor;


@SpringBootApplication
public class HomeWebfluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(HomeWebfluxApplication.class, args);
    }
}
