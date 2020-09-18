package com.ederfmatos.mockbean;

import com.ederfmatos.mockbean.bean.integer.TestClassInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.ederfmatos.mockbean.assertions.MockBeanAssertions.assertJson;
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

    @Test
    @DisplayName("Deve realizar o mock de inteiros transformando em json")
    public void shouldBeMockIntegerConvertIntoJson() {
        String testClassIntegerJson = MockBean.mock(TestClassInteger.class).json();

        assertThat(testClassIntegerJson).isNotBlank();
        assertJson(testClassIntegerJson);
    }

    @Test
    @DisplayName("Deve realizar o mock de inteiros sem um numero em um atributo")
    public void shouldBeMockIntegerWithoutOne() {
        TestClassInteger testClassInteger = MockBean.mock(TestClassInteger.class)
                .without("age")
                .build();

        assertThat(testClassInteger).isNotNull();
        assertThat(testClassInteger.getAge()).isEqualTo(0);
        assertThat(testClassInteger.getYear()).isNotNull();
    }

    @Test
    @DisplayName("Deve realizar o mock de uma lista de inteiros")
    public void shouldBeMockListInteger() {
        List<TestClassInteger> testClassInteger = MockBean.mock(TestClassInteger.class)
                .with("age", 15)
                .build(2);

        assertThat(testClassInteger).isNotNull();
        assertThat(testClassInteger).hasSize(2);
        assertThat(testClassInteger.get(0).getYear()).isNotNull();
        assertThat(testClassInteger.get(1).getYear()).isNotNull();
        assertThat(testClassInteger.get(0).getAge()).isEqualTo(15);
        assertThat(testClassInteger.get(1).getAge()).isEqualTo(15);
    }

    @Test
    @DisplayName("Deve realizar o mock de uma lista de inteiros em json")
    public void shouldBeMockListIntegerInJson() {
        String testClassIntegerJson = MockBean.mock(TestClassInteger.class)
                .with("age", 15)
                .json(2);

        assertJson(testClassIntegerJson);
    }

}
