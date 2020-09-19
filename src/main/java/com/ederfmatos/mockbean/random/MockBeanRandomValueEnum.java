package com.ederfmatos.mockbean.random;

import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;
import com.ederfmatos.mockbean.random.types.*;
import com.ederfmatos.mockbean.random.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public enum MockBeanRandomValueEnum {

    STRING(new MockBeanRandomString()),
    INTEGER(new MockBeanRandomInteger()),
    LOCAL_DATE(new MockBeanRandomLocalDate()),
    BOOLEAN(new MockBeanRandomBoolean()),
    DOUBLE(new MockBeanRandomDouble()),
    FLOAT(new MockBeanRandomFloat()),
    LONG(new MockBeanRandomLong()),
    DATE(new MockBeanRandomDate()),
    CHAR(new MockBeanRandomChar()),
    LIST(new MockBeanRandomList()),
    MAP(new MockBeanRandomMap()),
    ;

    private final MockBeanRandomValueAbstract<?> generator;

    MockBeanRandomValueEnum(MockBeanRandomValueAbstract<?> generator) {
        this.generator = generator;
    }

    public static Object getRandomValueFromField(final Field field) {
        Class<?> fieldClass = field.getType();

        if (fieldClass.isEnum()) {
            Object[] enumConstants = fieldClass.getEnumConstants();
            return Arrays.asList(enumConstants).get(MockBeanRandomFactory.get().nextInt(enumConstants.length));
        }

        if (fieldClass.isPrimitive()) {
            fieldClass = ReflectionUtils.getWrapperClassFromPrimitive(fieldClass);
        }

        final Class<?> finalFieldClass = fieldClass;
        return Stream.of(MockBeanRandomValueEnum.values())
                .map(MockBeanRandomValueEnum::getGenerator)
                .filter(generator -> generator.isInstanceOf(finalFieldClass))
                .findFirst()
                .map(generator -> generator.getRandomValue(field)).orElse(null);
    }

    public MockBeanRandomValueAbstract<?> getGenerator() {
        return generator;
    }

}
