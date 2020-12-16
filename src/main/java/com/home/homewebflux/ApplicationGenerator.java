package com.home.homewebflux;

import com.home.homewebflux.model.entity.Application;
import com.home.homewebflux.model.entity.ProductType;

import java.util.Random;

public class ApplicationGenerator {
    private final static Random random = new Random();

    private static double randomInt(int minimum, int maximum) {
        int range = maximum - minimum + 1;
        return random.nextInt(range) + minimum;
    }

    private static ProductType randomProductType() {
        return random.nextBoolean() ? ProductType.CC : ProductType.DC;
    }

    private static int randomAge() {
        return (int) randomInt(18, 50);
    }

    private static String randomFio() {
        return "Client-" + random.nextLong();
    }

    public static Application generateApplication() {
        return new Application()
                .setIncome(randomInt(10000, 30000))
                .setProductType(randomProductType())
                .setAge(randomAge())
                .setSex(random.nextBoolean())
                .setClientFio(randomFio());
    }

}
