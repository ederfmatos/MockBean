package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.singleton.MockBeanRandomSingleton;

import java.lang.reflect.Field;

public class MockBeanRandomFloat extends MockBeanRandomValueAbstract<Float> {

    @Override
    public Float getRandomValue(Field field) {
        return MockBeanRandomSingleton.get().nextFloat();
    }

    @Override
    protected Class<Float> getRefClass() {
        return Float.class;
    }

}
