package com.ederfmatos.mockbean.random.utils;

import java.util.HashMap;
import java.util.Map;

public final class ReflectionUtils {

    private static final Map<Class<?>, Class<?>> wrapperPrimitiveClass;

    static {
        wrapperPrimitiveClass = new HashMap<>();

        wrapperPrimitiveClass.put(char.class, Character.class);
        wrapperPrimitiveClass.put(int.class, Integer.class);
        wrapperPrimitiveClass.put(boolean.class, Boolean.class);
        wrapperPrimitiveClass.put(byte.class, Byte.class);
        wrapperPrimitiveClass.put(double.class, Double.class);
        wrapperPrimitiveClass.put(float.class, Float.class);
        wrapperPrimitiveClass.put(long.class, Long.class);
        wrapperPrimitiveClass.put(short.class, Short.class);
    }

    private ReflectionUtils() {
    }

    public static Class<?> getWrapperClassFromPrimitive(Class<?> primitiveClass) {
        return wrapperPrimitiveClass.get(primitiveClass);
    }

}
