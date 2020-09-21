package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.singleton.MockBeanRandomSingleton;

import java.lang.reflect.Field;

public class MockBeanRandomBoolean extends MockBeanRandomValueAbstract<Boolean> {

    @Override
    public Boolean getRandomValue(Field field) {
        return MockBeanRandomSingleton.get().nextBoolean();
    }

    @Override
    protected Class<Boolean> getRefClass() {
        return Boolean.class;
    }

}
