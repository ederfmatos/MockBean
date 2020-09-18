package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.TestClassList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanListTest {

    @Test
    @DisplayName("Deve realizar um mock de uma lista")
    public void shoudBeMockStringlist() {
        TestClassList classeDeTest = MockBean.mock(TestClassList.class).build();

        assertThat(classeDeTest).isNotNull();
        assertThat(classeDeTest.getStrings()).isNotEmpty();
        assertThat(classeDeTest.getDoubles()).isNotEmpty();
        assertThat(classeDeTest.getIntegers()).isNotEmpty();
        assertThat(classeDeTest.getFloats()).isNotEmpty();
    }

}
