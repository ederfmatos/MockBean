package com.ederfmatos.mockbean.random;

import com.ederfmatos.mockbean.MockBean;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;
import com.ederfmatos.mockbean.random.types.*;
import com.ederfmatos.mockbean.random.utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public enum MockBeanRandomValueEnum {

    STRING(String.class, new MockBeanRandomString()),
    INTEGER(Integer.class, new MockBeanRandomInteger()),
    LOCAL_DATE(LocalDate.class, new MockBeanRandomLocalDate()),
    BOOLEAN(Boolean.class, new MockBeanRandomBoolean()),
    DOUBLE(Double.class, new MockBeanRandomDouble()),
    FLOAT(Float.class, new MockBeanRandomFloat()),
    LONG(Long.class, new MockBeanRandomLong()),
    DATE(Date.class, new MockBeanRandomDate()),
    CHAR(Character.class, new MockBeanRandomChar()),
    ;

    private final Class<?> refClass;
    private final MockBeanRandomValueInterface<?> generator;

    MockBeanRandomValueEnum(Class<?> refClass, MockBeanRandomValueInterface<?> generator) {
        this.refClass = refClass;
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

        for (MockBeanRandomValueEnum value : MockBeanRandomValueEnum.values()) {
            if (fieldClass.getSimpleName().equalsIgnoreCase(value.getRefClass().getSimpleName())) {
                return value.getGenerator().getRandomValue(field);
            }
        }

        return MockBean.mock(fieldClass).build();
    }

    public Class<?> getRefClass() {
        return refClass;
    }

    public MockBeanRandomValueInterface<?> getGenerator() {
        return generator;
    }

}
