package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.exception.MockBeanNoSuchFieldException;
import com.ederfmatos.mockbean.random.MockBeanRandomValueEnum;
import com.ederfmatos.mockbean.random.singleton.MockBeanGsonSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Logger;

public class MockBean<B> {

    private static final Logger LOGGER = Logger.getLogger(MockBean.class.getName());

    private final Class<B> refClass;
    private final Map<String, Object> fieldValueMap;

    MockBean(Class<B> refClass) {
        this.refClass = refClass;
        this.fieldValueMap = new HashMap<>();
    }

    public static <B> MockBean<B> mock(Class<B> refClass) {
        return mockBean(refClass);
    }

    public static <B> MockBean<B> mockBean(Class<B> refClass) {
        return new MockBean<>(refClass);
    }

    public MockBean<B> without(String... names) {
        for (String name : names) {
            with(name, null);
        }

        return this;
    }

    public MockBean<B> with(String name, Object value) {
        try {
            refClass.getDeclaredField(name);
            fieldValueMap.put(name, value);
        } catch (NoSuchFieldException e) {
            throw new MockBeanNoSuchFieldException(String.format("Field \"%s\" not found", name));
        }

        return this;
    }

    public B build() {
        return createBean();
    }

    public List<B> build(int size) {
        List<B> beans = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            beans.add(createBean());
        }

        return beans;
    }

    public String json() {
        return MockBeanGsonSingleton.get().toJson(build());
    }

    public String json(int size) {
        return MockBeanGsonSingleton.get().toJson(build(size));
    }

    public Optional<B> optional() {
        return Optional.ofNullable(createBean());
    }

    private B createBean() {
        try {
            Constructor<B> constructor = refClass.getDeclaredConstructor();
            constructor.setAccessible(true);

            B bean = constructor.newInstance();

            constructor.setAccessible(false);

            Field[] fields = refClass.getDeclaredFields();

            for (Field field : fields) {
                try {
                    String name = field.getName();
                    Object value;

                    if (fieldValueMap.containsKey(name)) {
                        value = fieldValueMap.get(name);

                        if (value == null) continue;
                    } else {
                        value = MockBeanRandomValueEnum.getRandomValueFromField(field);
                    }

                    LOGGER.info(String.format("Generated value \"%s\" for field \"%s\" of type \"%s\"", value, name, field.getType().getSimpleName()));

                    field.setAccessible(true);
                    field.set(bean, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } finally {
                    field.setAccessible(false);
                }
            }

            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
