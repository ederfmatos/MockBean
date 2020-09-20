package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.string.TestClassString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanStringTest {

    @Test
    @DisplayName("Deve realizar o mock de strings")
    public void shouldBeMockStrings() {
        TestClassString testClass = MockBean.mock(TestClassString.class)
                .build();

        assertThat(testClass).isNotNull();
        assertThat(testClass.getCountry()).isNotEmpty();
        assertThat(testClass.getFirstName()).isNotEmpty();
        assertThat(testClass.getLastName()).isNotEmpty();
        assertThat(testClass.getName()).isNotEmpty();
        assertThat(testClass.getPhoneNumber()).isNotEmpty();
    }

}
