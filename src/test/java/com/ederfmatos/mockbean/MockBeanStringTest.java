package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.string.TestClassString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanStringTest {

    @Test
    @DisplayName("Deve realizar o mock de strings")
    public void shouldBeMockInteger() {
        TestClassString testClassInteger = MockBean.mock(TestClassString.class)
                .build();

        assertThat(testClassInteger).isNotNull();
        assertThat(testClassInteger.getCountry()).isNotEmpty();
        assertThat(testClassInteger.getFirstName()).isNotEmpty();
        assertThat(testClassInteger.getLastName()).isNotEmpty();
        assertThat(testClassInteger.getName()).isNotEmpty();
        assertThat(testClassInteger.getPhoneNumber()).isNotEmpty();
    }

}
