package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomChar extends MockBeanRandomValueAbstract<Character> {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public Character getRandomValue(Field field) {
        return ALPHABET.charAt(MockBeanRandomFactory.get().nextInt(ALPHABET.length()));
    }

    @Override
    protected Class<Character> getRefClass() {
        return Character.class;
    }

}
