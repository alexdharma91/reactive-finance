package com.home.homewebflux.controller;

import com.home.homewebflux.model.entity.Card;
import com.home.homewebflux.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    @PostMapping("create")
    public Mono<Card> create(@Validated @RequestBody Mono<Card> cardMono) {
        return cardService.create(cardMono);
    }

    @GetMapping("/all")
    public Flux<Card> findAll() {
        return cardService.findAll();
    }

    @GetMapping("/user/{userId}")
    public Flux<Card> findByUser(@PathVariable Long userId) {
        return cardService.findByUser(userId);
    }

    @GetMapping("/all/partitions/{partSize}")
    public Flux<List<Card>> getAllPartitions(@PathVariable int partSize) {
        return cardService.getAllPartitions(partSize);
    }

}
