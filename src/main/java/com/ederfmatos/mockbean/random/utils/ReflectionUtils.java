package com.ederfmatos.mockbean.random.utils;

import java.util.Map;

public final class ReflectionUtils {

    private static final Map<Class<?>, Class<?>> wrapperPrimitiveClass = Map.of(
            char.class, Character.class,
            int.class, Integer.class,
            boolean.class, Boolean.class,
            byte.class, Byte.class,
            double.class, Double.class,
            float.class, Float.class,
            long.class, Long.class,
            short.class, Short.class
    );

    private ReflectionUtils() {
    }

    public static Class<?> getWrapperClassFromPrimitive(Class<?> primitiveClass) {
        return wrapperPrimitiveClass.get(primitiveClass);
    }

}
