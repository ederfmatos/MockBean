package com.ederfmatos.mockbean.random;

import java.lang.reflect.Field;

@FunctionalInterface
public interface MockBeanRandomValueInterface<T> {

    T getRandomValue(Field field);

}
