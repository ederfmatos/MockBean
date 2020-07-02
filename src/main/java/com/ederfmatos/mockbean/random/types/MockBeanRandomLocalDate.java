package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class MockBeanRandomLocalDate implements MockBeanRandomValueInterface<LocalDate> {

    private static final long MIN_DAY = LocalDate.of(1970, 1, 1).toEpochDay();

    @Override
    public LocalDate getRandomValue(Field field) {
        long randomDay = ThreadLocalRandom.current().nextLong(MIN_DAY, LocalDate.now().toEpochDay());
        return LocalDate.ofEpochDay(randomDay);
    }

}
