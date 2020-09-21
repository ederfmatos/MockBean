package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.singleton.MockBeanRandomSingleton;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public class MockBeanRandomMap extends MockBeanRandomValueAbstract<Map> {

    @Override
    public Map<Object, Object> getRandomValue(Field field) {
        int size = MockBeanRandomSingleton.randomInt(15) + 1;

        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Class<?> keyClass = (Class<?>) type.getActualTypeArguments()[0];
        Class<?> valueClass = (Class<?>) type.getActualTypeArguments()[1];

        Map<Object, Object> resultMap = new HashMap<>();

        for (int i = 0; i < size; i++) {
            resultMap.put(
                    getValueFromClass(keyClass),
                    getValueFromClass(valueClass)
            );
        }

        return resultMap;
    }

    @Override
    public boolean isInstanceOf(Class<?> oneClass) {
        return getRefClass().isAssignableFrom(oneClass);
    }

    @Override
    protected Class<Map> getRefClass() {
        return Map.class;
    }

}
