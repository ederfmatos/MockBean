package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.random.MockBeanRandomValueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MockBean<B> {

    private static final Logger LOG = LoggerFactory.getLogger(MockBean.class);

    private final Class<B> refClass;
    private B bean;
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
            field = bean.getClass().getDeclaredField(name);
            fieldValueMap.put(name, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            if (field != null) {
                field.setAccessible(false);
            }
        }

        return this;
    }

    public B build() {
        createBean();
        return bean;
    }

    private void createBean() {
        try {
            Constructor<B> constructor = refClass.getDeclaredConstructor();
            constructor.setAccessible(true);

            bean = constructor.newInstance();

            constructor.setAccessible(false);

            Field[] fields = refClass.getDeclaredFields();

            for (Field field : fields) {
                try {
                    Object value;

                    if (fieldValueMap.containsKey(field.getName())) {
                        value = fieldValueMap.get(field.getName());

                        if (value == null) continue;
                    } else {
                        value = MockBeanRandomValueEnum.getRandomValueFromField(field);
                    }

                    LOG.debug("Generated value {} for field {} of type {}", value, field.getName(), field.getType().getSimpleName());

                    field.setAccessible(true);
                    field.set(bean, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } finally {
                    field.setAccessible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
