package com.ederfmatos.mockbean.random.singleton;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MockBeanFakerSingleton {

    private static Map<Class<?>, Map<String, Supplier<Object>>> mapMethods;

    private static void configure() {
        if (mapMethods != null) return;

        mapMethods = new HashMap<>();

        List<Class<?>> classes = Arrays.asList(String.class, Integer.class, Double.class);

        Faker faker = new Faker(new Locale("pt-br"));

        final BiFunction<Method, Object, Object> runMethod = (method, parameter) -> {
            try {
                return method.invoke(parameter);
            } catch (IllegalAccessException | InvocationTargetException e) {
                return null;
            }
        };

        for (Class<?> clazz : classes) {
            Map<String, Supplier<Object>> mapMethod = new HashMap<>();

            Stream.of(faker.getClass().getDeclaredMethods())
                    .filter(method -> method.getParameterCount() == 0 && method.getReturnType().getTypeName().startsWith("com.github.javafaker"))
                    .map(method -> runMethod.apply(method, faker))
                    .filter(Objects::nonNull)
                    .forEach(result -> Stream.of(result.getClass().getDeclaredMethods())
                            .filter(method -> method.getReturnType().getTypeName().equals(clazz.getTypeName()))
                            .forEach(method -> mapMethod.put(method.getName(), () -> runMethod.apply(method, result)))
                    );

            mapMethods.put(clazz, mapMethod);
        }
    }

    public static String getString(String fieldName) {
        if (StringUtils.isBlank(fieldName)) return null;

        configure();

        return (String) mapMethods.get(String.class).getOrDefault(fieldName, () -> null).get();
    }

}
