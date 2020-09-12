package com.ederfmatos.mockbean.random.factory;

import com.google.gson.Gson;

public final class MockBeanGsonFactory {

    private static Gson instance;

    private MockBeanGsonFactory() {
        throw new RuntimeException("It is not possible to create an instance of this class");
    }

    public static Gson get() {
        if (instance == null) {
            instance = new Gson();
        }

        return instance;
    }

}
