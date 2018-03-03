package com.ubs.opsit.interviews.enums;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LightColorEnumTest {

    @Test
    public void testColorCodeWhenLightColorIsYellow(){
        Assertions.assertThat(LightColor.YELLOW.getColorCode()).isEqualTo("Y");
    }

    @Test
    public void testColorCodeWhenLightColorIsRed(){
        Assertions.assertThat(LightColor.RED.getColorCode()).isEqualTo("R");
    }
}
