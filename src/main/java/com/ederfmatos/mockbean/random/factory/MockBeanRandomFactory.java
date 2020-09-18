package com.ederfmatos.mockbean.random.factory;

import java.util.Random;

public class MockBeanRandomFactory {

    private static Random random;

    public static Random get() {
        if (random == null) {
            random = new Random();
        }

        return random;
    }

}
