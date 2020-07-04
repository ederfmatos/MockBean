package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomLong implements MockBeanRandomValueInterface<Long> {

    @Override
    public Long getRandomValue(Field field) {
        return MockBeanRandomFactory.get().nextLong();
    }

}
