package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.enumeration.TestClassEnum;
import com.ederfmatos.mockbean.bean.integer.TestClassMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanEnumTest {

    @Test
    @DisplayName("Deve realizar um mock de enum")
    public void shoudBeMockEnum() {
        TestClassEnum classeDeTest = MockBean.mock(TestClassEnum.class).build();

        assertThat(classeDeTest).isNotNull();
        assertThat(classeDeTest.getStatusEnum()).isNotNull();
    }

}
