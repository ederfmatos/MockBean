package com.ederfmatos.mockbean.random.factory;

import com.google.gson.Gson;

public class MockBeanGsonFactory {

    private static Gson instance;

    public static Gson get() {
        if (instance == null) {
            instance = new Gson();
        }

        return instance;
    }

}
