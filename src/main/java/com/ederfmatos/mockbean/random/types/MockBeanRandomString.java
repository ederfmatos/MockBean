package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomString implements MockBeanRandomValueInterface<String> {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";

    @Override
    public String getRandomValue(Field field) {
        int count = MockBeanRandomFactory.get().nextInt(25) + 10;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(MockBeanRandomFactory.get().nextInt(ALPHABET.length())));
        }

        return sb.toString();
    }

}
