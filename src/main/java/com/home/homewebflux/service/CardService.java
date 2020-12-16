package com.home.homewebflux.service;

import com.home.homewebflux.model.dao.CardRepository;
import com.home.homewebflux.model.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Flux<Card> findAll() {
        return cardRepository.findAll();
    }

    public Flux<List<Card>> getAllPartitions(int partSize) {
        return cardRepository.findAll().buffer(partSize);
    }

    public Flux<Card> findByUser(Long userId) {
        return cardRepository.findByUserId(userId);
    }

    public Mono<Card> create(Mono<Card> cardMono) {
        return cardMono.flatMap(card -> cardRepository.save(card));
    }
}
