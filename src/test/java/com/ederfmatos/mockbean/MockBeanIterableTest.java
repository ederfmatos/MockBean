package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.iterable.TestClassList;
import com.ederfmatos.mockbean.bean.iterable.TestClassSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanIterableTest {

    @Test
    @DisplayName("Deve realizar um mock de listas")
    public void shoudBeMockLists() {
        TestClassList classeDeTest = MockBean.mock(TestClassList.class).build();

        assertThat(classeDeTest).isNotNull();
        assertThat(classeDeTest.getStrings()).isNotEmpty();
        assertThat(classeDeTest.getDoubles()).isNotEmpty();
        assertThat(classeDeTest.getIntegers()).isNotEmpty();
        assertThat(classeDeTest.getFloats()).isNotEmpty();
        assertThat(classeDeTest.getBooleans()).isNotEmpty();
        assertThat(classeDeTest.getCharacters()).isNotEmpty();
        assertThat(classeDeTest.getLocalDates()).isNotEmpty();
        assertThat(classeDeTest.getLongs()).isNotEmpty();
        assertThat(classeDeTest.getDates()).isNotEmpty();
        assertThat(classeDeTest.getStatusEnums()).isNotEmpty();
    }

    @Test
    @DisplayName("Deve realizar um mock de sets")
    public void shoudBeMockSets() {
        TestClassSet classeDeTest = MockBean.mock(TestClassSet.class).build();

        assertThat(classeDeTest).isNotNull();
        assertThat(classeDeTest.getStrings()).isNotEmpty();
        assertThat(classeDeTest.getDoubles()).isNotEmpty();
        assertThat(classeDeTest.getIntegers()).isNotEmpty();
        assertThat(classeDeTest.getFloats()).isNotEmpty();
        assertThat(classeDeTest.getBooleans()).isNotEmpty();
        assertThat(classeDeTest.getCharacters()).isNotEmpty();
        assertThat(classeDeTest.getLocalDates()).isNotEmpty();
        assertThat(classeDeTest.getLongs()).isNotEmpty();
        assertThat(classeDeTest.getDates()).isNotEmpty();
        assertThat(classeDeTest.getStatusEnums()).isNotEmpty();
    }

}
