package com.home.homewebflux.model.dao;

import com.home.homewebflux.model.entity.Card;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CardRepository extends ReactiveCrudRepository<Card, Long> {
    @Query("SELECT * FROM cards WHERE user_id = $1")
    Flux<Card> findByUserId(Long userId);
}
