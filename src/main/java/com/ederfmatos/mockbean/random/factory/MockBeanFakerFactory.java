package com.ederfmatos.mockbean.random.factory;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class MockBeanFakerFactory {

    private static Map<String, Supplier<String>> mapMethods;

    public static String getString(String fieldName) {
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }

        if (mapMethods == null) {
            Faker faker = new Faker(new Locale("pt-br"));
            mapMethods = new HashMap<>();

            Stream.of(faker.getClass().getDeclaredMethods())
                    .filter(method -> method.getReturnType().getTypeName().contains("com.github.javafaker"))
                    .filter(method -> method.getParameterCount() == 0)
                    .filter(method -> method.getReturnType().getTypeName().startsWith("com.github.javafaker"))
                    .map(method -> {
                        try {
                            return method.invoke(faker);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .forEach(result ->
                            Stream.of(result.getClass().getDeclaredMethods())
                                    .filter(method -> method.getReturnType().getTypeName().equals(String.class.getTypeName()))
                                    .forEach(method -> mapMethods.put(method.getName(), () -> {
                                        try {
                                            return (String) method.invoke(result);
                                        } catch (IllegalAccessException | InvocationTargetException e) {
                                            return null;
                                        }
                                    }))
                    );
        }

        return mapMethods.getOrDefault(fieldName, () -> null).get();
    }

}
