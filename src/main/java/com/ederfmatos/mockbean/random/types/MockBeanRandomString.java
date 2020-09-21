package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.singleton.MockBeanFakerSingleton;
import com.ederfmatos.mockbean.random.singleton.MockBeanRandomSingleton;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockBeanRandomString extends MockBeanRandomValueAbstract<String> {

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";

    @Override
    public String getRandomValue(Field field) {
        String name = Optional.ofNullable(field)
                .map(Field::getName)
                .orElse("");

        return Optional.ofNullable(MockBeanFakerSingleton.getString(name))
                .orElseGet(() -> IntStream.range(1, MockBeanRandomSingleton.get().nextInt(25) + 10)
                        .mapToObj(value -> String.valueOf(ALPHABET.charAt(MockBeanRandomSingleton.get().nextInt(ALPHABET.length()))))
                        .collect(Collectors.joining("")));
    }

    @Override
    protected Class<String> getRefClass() {
        return String.class;
    }

}
