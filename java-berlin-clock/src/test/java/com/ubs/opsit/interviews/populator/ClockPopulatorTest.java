package com.ubs.opsit.interviews.populator;

import com.ubs.opsit.interviews.model.Clock;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

public class ClockPopulatorTest {

    @Test
    public void testPopulateClockObjectFromTokensWhenTokensAreEmpty(){
        Clock clock = ClockPopulator.populateClockObjectFromTokens(Arrays.asList());
        Assertions.assertThat(clock.getHours()).isNull();
        Assertions.assertThat(clock.getMinutes()).isNull();
        Assertions.assertThat(clock.getSeconds()).isNull();
    }

    @Test
    public void testPopulateClockObjectFromTokensWhenTokensAreNonEmpty(){
        Clock clock = ClockPopulator.populateClockObjectFromTokens(Arrays.asList("16","15","10"));

        Assertions.assertThat(clock.getHours()).isNotNull();
        Assertions.assertThat(clock.getHours()).isEqualTo("16");

        Assertions.assertThat(clock.getMinutes()).isNotNull();
        Assertions.assertThat(clock.getMinutes()).isEqualTo("15");

        Assertions.assertThat(clock.getSeconds()).isNotNull();
        Assertions.assertThat(clock.getSeconds()).isEqualTo("10");
    }
}
