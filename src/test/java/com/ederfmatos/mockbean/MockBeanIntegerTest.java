package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.iterable.TestClassInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanIntegerTest {

    @Test
    @DisplayName("Deve realizar o mock de inteiros")
    public void shouldBeMockInteger() {
        TestClassInteger testClassInteger = MockBean.mock(TestClassInteger.class)
                .with("age", 15)
                .build();

        assertThat(testClassInteger).isNotNull();
        assertThat(testClassInteger.getAge()).isEqualTo(15);
        assertThat(testClassInteger.getYear()).isNotNull();
    }

}
