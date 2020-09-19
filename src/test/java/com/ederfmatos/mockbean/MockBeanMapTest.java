package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.integer.TestClassMap;
import com.ederfmatos.mockbean.bean.iterable.TestClassList;
import com.ederfmatos.mockbean.bean.iterable.TestClassSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanMapTest {

    @Test
    @DisplayName("Deve realizar um mock de mapas")
    public void shoudBeMockMaps() {
        TestClassMap classeDeTest = MockBean.mock(TestClassMap.class).build();

        assertThat(classeDeTest).isNotNull();
        assertThat(classeDeTest.getIntegerMap()).isNotEmpty();
        assertThat(classeDeTest.getNames()).isNotEmpty();
    }

}
