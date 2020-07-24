package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.random.MockBeanRandomValueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockBean<B> {

    private static final Logger LOG = LoggerFactory.getLogger(MockBean.class);

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
        Field field = null;

        try {
            field = refClass.getDeclaredField(name);
            fieldValueMap.put(name, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            throw new RuntimeException(String.format("Field \"%s\" not found", name));
        } finally {
            if (field != null) {
                field.setAccessible(false);
            }
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

                    LOG.debug("Generated value {} for field {} of type {}", value, name, field.getType().getSimpleName());

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
