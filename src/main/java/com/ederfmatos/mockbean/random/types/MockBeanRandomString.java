package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;

import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.Random;

public class MockBeanRandomString implements MockBeanRandomValueInterface<String> {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();

    @Override
    public String getRandomValue(Field field) {
        int count = new Random().nextInt(25) + 10;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return sb.toString();
    }

}
