package com.home.homewebflux.model.dao;

import com.home.homewebflux.model.entity.Application;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends ReactiveCrudRepository<Application, Long> {
}
