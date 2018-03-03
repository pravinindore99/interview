package com.ubs.opsit.interviews.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ClockTest {

    @Test
    public void testModel(){
        Clock clock = new Clock("23","12","10");

        Assertions.assertThat(clock.getHours()).isNotEmpty();
        Assertions.assertThat(clock.getHours()).isEqualTo("23");

        Assertions.assertThat(clock.getMinutes()).isNotEmpty();
        Assertions.assertThat(clock.getMinutes()).isEqualTo("12");

        Assertions.assertThat(clock.getSeconds()).isNotEmpty();
        Assertions.assertThat(clock.getSeconds()).isEqualTo("10");
    }
}
