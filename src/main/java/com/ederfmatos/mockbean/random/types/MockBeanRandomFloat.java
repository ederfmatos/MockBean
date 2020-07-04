package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomFloat implements MockBeanRandomValueInterface<Float> {

    @Override
    public Float getRandomValue(Field field) {
        return MockBeanRandomFactory.get().nextFloat();
    }

}
