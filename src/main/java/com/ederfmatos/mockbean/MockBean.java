package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.random.MockBeanRandomValueEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class MockBean<B> {

    private static final Logger LOG = LoggerFactory.getLogger(MockBean.class);

    private final Class<B> refClass;
    private B bean;

    MockBean(Class<B> refClass) {
        this.refClass = refClass;
        createBean();
    }

    public static <B> MockBean<B> mock(Class<B> refClass) {
        return mockBean(refClass);
    }

    public static <B> MockBean<B> mockBean(Class<B> refClass) {
        return new MockBean<>(refClass);
    }

    @SuppressWarnings("unchecked")
    private static <T> T getDefaultValue(Class<T> clazz) {
        return (T) Array.get(Array.newInstance(clazz, 1), 0);
    }

    private void createBean() {
        try {
            Constructor<B> constructor = refClass.getDeclaredConstructor();
            bean = constructor.newInstance();

            Field[] fields = refClass.getDeclaredFields();

            for (Field field : fields) {
                try {
                    field.setAccessible(true);

                    Object value = MockBeanRandomValueEnum.getRandomValueFromField(field);
                    LOG.debug("Generated value {} for field {} of type {}", value, field.getName(), field.getType().getSimpleName());

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
            field.setAccessible(true);

            if (value == null) {
                value = getDefaultValue(field.getType());
            }

            field.set(bean, value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            if (field != null) {
                field.setAccessible(false);
            }
        }

        return this;
    }

    public B build() {
        return bean;
    }

}
