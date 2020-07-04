package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomChar implements MockBeanRandomValueInterface<Character> {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public Character getRandomValue(Field field) {
        return ALPHABET.charAt(MockBeanRandomFactory.get().nextInt(ALPHABET.length()));
    }

}
