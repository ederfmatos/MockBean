package com.ederfmatos.mockbean.random.types;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MockBeanRandomTest {

    @Test
    @DisplayName("Should be return random boolean")
    public void shouldBeReturnRandomBoolean() {
        Boolean value = new MockBeanRandomBoolean().getRandomValue(null);
        assertThat(value).isNotNull();
    }

}
