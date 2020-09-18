package com.ederfmatos.mockbean.random;

import java.lang.reflect.Field;
import java.util.stream.Stream;

public abstract class MockBeanRandomValueAbstract<T> {

    public abstract T getRandomValue(Field field);

    protected abstract Class<T> getRefClass();

    public boolean isInstanceOf(Class<?> oneClass) {
        return this.isSameName(getRefClass(), oneClass);
    }

    protected boolean isSameName(Class<?> oneClass, Class<?> otherClass) {
        return oneClass.getSimpleName().equalsIgnoreCase(otherClass.getSimpleName());
    }

    protected <O> Object getValueFromClass(Class<O> refClass) {
        return Stream.of(MockBeanRandomValueEnum.values())
                .map(MockBeanRandomValueEnum::getGenerator)
                .filter(generator -> generator.isInstanceOf(refClass))
                .findFirst()
                .map(generator -> generator.getRandomValue(null))
                .orElse(null);
    }

}
