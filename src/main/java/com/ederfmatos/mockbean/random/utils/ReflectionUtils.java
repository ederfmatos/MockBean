package com.ederfmatos.mockbean.random.utils;

public final class ReflectionUtils {

    private ReflectionUtils() {
    }

    public static Class<?> getWrapperClassFromPrimitive(Class<?> primitiveClass) {
        if (primitiveClass == char.class)
            return Character.class;

        if (primitiveClass == int.class)
            return Integer.class;

        if (primitiveClass == boolean.class)
            return Boolean.class;

        if (primitiveClass == byte.class)
            return Byte.class;

        if (primitiveClass == double.class)
            return Double.class;

        if (primitiveClass == float.class)
            return Float.class;

        if (primitiveClass == long.class)
            return Long.class;

        return Short.class;
    }

}
