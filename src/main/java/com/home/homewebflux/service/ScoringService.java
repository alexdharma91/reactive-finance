package com.home.homewebflux.service;

import com.home.homewebflux.model.entity.Application;
import com.home.homewebflux.model.entity.ProductType;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ScoringService {
    private final Random random = new Random();

    public boolean validate(Application application) {
        if (application.getAge() < 18) {
            return false;
        }

        if (application.getProductType() == ProductType.DC) {
            return true;
        }

        if (application.getIncome() > 30000) {
            return true;
        } else {
            return random.nextBoolean();
        }
    }

}
