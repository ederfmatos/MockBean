package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;

public class MockBeanRandomDouble extends MockBeanRandomValueAbstract<Double> {

    @Override
    public Double getRandomValue(Field field) {
        return MockBeanRandomFactory.get().nextDouble();
    }

    @Override
    protected Class<Double> getRefClass() {
        return Double.class;
    }

}
