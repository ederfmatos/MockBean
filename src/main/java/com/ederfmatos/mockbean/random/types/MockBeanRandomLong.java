package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.singleton.MockBeanRandomSingleton;

import java.lang.reflect.Field;

public class MockBeanRandomLong extends MockBeanRandomValueAbstract<Long> {

    @Override
    public Long getRandomValue(Field field) {
        return MockBeanRandomSingleton.get().nextLong();
    }

    @Override
    protected Class<Long> getRefClass() {
        return Long.class;
    }

}
