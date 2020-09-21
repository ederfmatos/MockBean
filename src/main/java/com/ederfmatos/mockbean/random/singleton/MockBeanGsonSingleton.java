package com.ederfmatos.mockbean.random.singleton;

import com.google.gson.Gson;

public class MockBeanGsonSingleton {

    private static Gson instance;

    public static Gson get() {
        if (instance == null) {
            instance = new Gson();
        }

        return instance;
    }

}
