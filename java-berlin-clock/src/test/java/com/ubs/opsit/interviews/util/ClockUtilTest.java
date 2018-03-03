package com.ubs.opsit.interviews.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

public class ClockUtilTest {

    @Test
    public void createTokensFromNullInput(){
      List<String> tokens=  ClockUtil.createTokensFromInput(null);
        Assertions.assertThat(tokens).isEmpty();
    }

    @Test
    public void createTokensFromEmptyInput(){
        List<String> tokens=  ClockUtil.createTokensFromInput("");
        Assertions.assertThat(tokens).isEmpty();
    }

    @Test
    public void createTokensFromCorrectInput(){
        List<String> tokens=  ClockUtil.createTokensFromInput("15:10:12");
        Assertions.assertThat(tokens).isNotEmpty();
        Assertions.assertThat(tokens.get(0)).isEqualTo("15");
        Assertions.assertThat(tokens.get(1)).isEqualTo("10");
        Assertions.assertThat(tokens.get(2)).isEqualTo("12");
    }


}
