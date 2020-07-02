package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomBoolean implements MockBeanRandomValueInterface<Boolean> {

    @Override
    public Boolean getRandomValue(Field field) {
        return MockBeanRandomFactory.get().nextBoolean();
    }

}
