package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomInteger implements MockBeanRandomValueInterface<Integer> {

    @Override
    public Integer getRandomValue(Field field) {
        return MockBeanRandomFactory.get().nextInt(100);
    }

}
