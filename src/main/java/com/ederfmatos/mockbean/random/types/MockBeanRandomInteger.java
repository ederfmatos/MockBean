package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.singleton.MockBeanRandomSingleton;

import java.lang.reflect.Field;

public class MockBeanRandomInteger extends MockBeanRandomValueAbstract<Integer> {

    @Override
    public Integer getRandomValue(Field field) {
        return MockBeanRandomSingleton.get().nextInt(100);
    }

    @Override
    protected Class<Integer> getRefClass() {
        return Integer.class;
    }

}
