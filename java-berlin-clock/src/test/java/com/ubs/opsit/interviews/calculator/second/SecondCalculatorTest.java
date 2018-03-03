package com.ubs.opsit.interviews.calculator.second;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.calculator.second.SecondCalculator;
import com.ubs.opsit.interviews.constants.BerlinConstants;
import com.ubs.opsit.interviews.enums.LightColor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SecondCalculatorTest {

    @Test
    public void testSecondCalculatorConstructor(){
        SecondCalculator secondCalculator = new SecondCalculator("2");
        Assertions.assertThat(secondCalculator.getInputValue()).isEqualTo(2);
    }

    @Test
    public void testSecondCalculatorWhenInputIsEven(){
        SecondCalculator secondCalculator = new SecondCalculator("2");
        Assertions.assertThat(secondCalculator.convertValue().toString()).isEqualTo(LightColor.YELLOW.getColorCode()+ IBaseCalculator.newLine);
    }

    @Test
    public void testSecondCalculatorWhenInputIsOdd(){
        SecondCalculator secondCalculator = new SecondCalculator("3");
        Assertions.assertThat(secondCalculator.convertValue().toString()).isEqualTo(BerlinConstants.CELL_STATE_OFF+ IBaseCalculator.newLine);
    }

    @Test
    public void testSecondCalculatorWhenInputIsZero(){
        SecondCalculator secondCalculator = new SecondCalculator("00");
        Assertions.assertThat(secondCalculator.convertValue().toString()).isEqualTo(LightColor.YELLOW.getColorCode()+ IBaseCalculator.newLine);
    }
}
