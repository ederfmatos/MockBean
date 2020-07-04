package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueInterface;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class MockBeanRandomDate implements MockBeanRandomValueInterface<Date> {

    private static final long MIN_DAY = LocalDate.of(1970, 1, 1).toEpochDay();

    @Override
    public Date getRandomValue(Field field) {
        long randomDay = ThreadLocalRandom.current().nextLong(MIN_DAY, LocalDate.now().toEpochDay());
        return new Date(randomDay);
    }

}
