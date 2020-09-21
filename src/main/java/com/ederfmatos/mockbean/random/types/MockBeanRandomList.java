package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;
import com.ederfmatos.mockbean.random.singleton.MockBeanRandomSingleton;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockBeanRandomList extends MockBeanRandomValueAbstract<Iterable> {

    @Override
    public Iterable getRandomValue(Field field) {
        int size = MockBeanRandomSingleton.get().nextInt(15) + 2;

        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Class<?> fieldType = (Class<?>) type.getActualTypeArguments()[0];

        Collector<Object, Object, Iterable> collector = this.getCollectorFromType(type);

        return IntStream.range(1, size)
                .mapToObj(n -> getValueFromClass(fieldType))
                .filter(Objects::nonNull)
                .collect(collector);
    }

    private Collector getCollectorFromType(ParameterizedType type) {
        Type rawType = type.getRawType();

        if (rawType.getTypeName().equals(Set.class.getTypeName())) {
            return Collectors.toSet();
        }

        return Collectors.toList();
    }

    @Override
    public boolean isInstanceOf(Class<?> oneClass) {
        return getRefClass().isAssignableFrom(oneClass);
    }

    @Override
    protected Class<Iterable> getRefClass() {
        return Iterable.class;
    }

}
