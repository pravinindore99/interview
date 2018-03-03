package com.ubs.opsit.interviews.calculator.minute;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TopRowMinuteCalculatorTest {

    @Test
    public void testTopRowMinuteCalculatorConstructor(){
        TopRowMinuteCalculator topRowMinuteCalculator = new TopRowMinuteCalculator(LightColor.YELLOW,CellCountInRow.TOP_MINUTE_CELL_COUNT,"59");
        Assertions.assertThat(topRowMinuteCalculator.getInputValue()).isEqualTo(59);
        Assertions.assertThat(topRowMinuteCalculator.getLightColor()).isEqualTo(LightColor.YELLOW);
        Assertions.assertThat(topRowMinuteCalculator.getCellCountInRow()).isEqualTo(CellCountInRow.TOP_MINUTE_CELL_COUNT);
    }

    @Test
    public void testTopRowMinuteCalculatorWhenHourIsNonZero(){
        TopRowMinuteCalculator topRowMinuteCalculator = new TopRowMinuteCalculator(LightColor.YELLOW,CellCountInRow.TOP_MINUTE_CELL_COUNT,"59");
        Assertions.assertThat(topRowMinuteCalculator.convertValue().toString()).isEqualTo("YYRYYRYYRYY" + IBaseCalculator.newLine);
    }

    @Test
    public void testTopRowMinuteCalculatorWhenHourIsZero(){
        TopRowMinuteCalculator topRowMinuteCalculator = new TopRowMinuteCalculator(LightColor.YELLOW,CellCountInRow.TOP_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(topRowMinuteCalculator.convertValue().toString()).isEqualTo("OOOOOOOOOOO"+ IBaseCalculator.newLine);
    }

    @Test
    public void testShouldAttachNewLine(){
        TopRowMinuteCalculator topRowMinuteCalculator = new TopRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(topRowMinuteCalculator.shouldAttachNewLine()).isEqualTo(true);
    }

    @Test
    public void testSpecialCellsShouldBeNonEmpty(){
        List<Integer> allowedValues = Arrays.asList(3,6,9);
        TopRowMinuteCalculator topRowMinuteCalculator = new TopRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(topRowMinuteCalculator.getSpecialCells()).isNotEmpty();
        Assertions.assertThat(topRowMinuteCalculator.getSpecialCells()).isEqualTo(allowedValues);
    }
}
