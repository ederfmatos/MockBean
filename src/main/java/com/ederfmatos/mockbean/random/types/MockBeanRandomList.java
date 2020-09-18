package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.factory.MockBeanRandomFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockBeanRandomList extends MockBeanRandomValueAbstract<List> {

    @Override
    public List<?> getRandomValue(Field field) {
        int size = MockBeanRandomFactory.get().nextInt(15);

        ParameterizedType integerListType = (ParameterizedType) field.getGenericType();
        Class<?> fieldType = (Class<?>) integerListType.getActualTypeArguments()[0];

        return IntStream.range(1, size)
                .mapToObj(n -> getValueFromClass(fieldType))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    protected Class<List> getRefClass() {
        return List.class;
    }

}
