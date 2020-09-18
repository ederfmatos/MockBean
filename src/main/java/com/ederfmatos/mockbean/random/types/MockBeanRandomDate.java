package com.ederfmatos.mockbean.random.types;

import com.ederfmatos.mockbean.random.MockBeanRandomValueAbstract;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class MockBeanRandomDate extends MockBeanRandomValueAbstract<Date> {

    private static final long MIN_DAY = LocalDate.of(1970, 1, 1).toEpochDay();

    @Override
    public Date getRandomValue(Field field) {
        long randomDay = ThreadLocalRandom.current().nextLong(MIN_DAY, LocalDate.now().toEpochDay());
        return new Date(randomDay);
    }

    @Override
    protected Class<Date> getRefClass() {
        return Date.class;
    }

}
