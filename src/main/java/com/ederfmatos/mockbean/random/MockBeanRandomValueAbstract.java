package com.ederfmatos.mockbean.random;

import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public abstract class MockBeanRandomValueAbstract<T> {

    public abstract Object getRandomValue(Field field);

    protected abstract Class<T> getRefClass();

    public boolean isInstanceOf(Class<?> oneClass) {
        return oneClass.isAssignableFrom(getRefClass()) || oneClass.getSimpleName().equalsIgnoreCase(getRefClass().getSimpleName());
    }

    protected <O> Object getValueFromClass(Class<O> refClass) {
        return Stream.of(MockBeanRandomValueEnum.values())
                .map(MockBeanRandomValueEnum::getGenerator)
                .filter(generator -> generator.isInstanceOf(refClass))
                .findFirst()
                .map(generator -> generator.getRandomValue(null))
                .orElseGet(() -> {
                    if (refClass.isEnum()) {
                        Object[] enumConstants = refClass.getEnumConstants();
                        return Arrays.asList(enumConstants).get(MockBeanRandomFactory.get().nextInt(enumConstants.length));
                    }

                    return null;
                });
    }

}
