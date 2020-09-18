package com.ederfmatos.mockbean.bean.iterable;

import com.ederfmatos.mockbean.bean.enumeration.StatusEnum;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class TestClassList {

    private List<String> strings;
    private List<Integer> integers;
    private List<Double> doubles;
    private List<Float> floats;
    private List<Date> dates;
    private List<Boolean> booleans;
    private List<Long> longs;
    private List<LocalDate> localDates;
    private List<Character> characters;
    private List<StatusEnum> statusEnums;

    public List<String> getStrings() {
        return strings;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public List<Double> getDoubles() {
        return doubles;
    }

    public List<Float> getFloats() {
        return floats;
    }

    public List<Date> getDates() {
        return dates;
    }

    public List<Boolean> getBooleans() {
        return booleans;
    }

    public List<Long> getLongs() {
        return longs;
    }

    public List<LocalDate> getLocalDates() {
        return localDates;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public List<StatusEnum> getStatusEnums() {
        return statusEnums;
    }
}
