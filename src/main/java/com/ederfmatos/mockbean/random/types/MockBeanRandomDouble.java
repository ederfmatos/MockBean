package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomDouble implements MockBeanRandomValueInterface<Double> {

    @Override
    public Double getRandomValue(Field field) {
        return MockBeanRandomFactory.get().nextDouble();
    }

}
