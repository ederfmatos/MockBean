package com.ederfmatos.mockbean.random.factory;

import java.util.Random;

public final class MockBeanRandomFactory {

    private static Random random;

    private MockBeanRandomFactory() {
        throw new RuntimeException("It is not possible to create an instance of this class");
    }

    public static Random get() {
        if (random == null) {
            random = new Random();
        }

        return random;
    }

}
