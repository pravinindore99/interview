package com.ubs.opsit.interviews.calculator.minute;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.calculator.hour.BottomRowHourCalculator;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BottomRowMinuteCalculatorTest {

    @Test
    public void testBottomRowMinuteCalculatorConstructor(){
        BottomRowMinuteCalculator bottomRowMinuteCalculator = new BottomRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"59");
        Assertions.assertThat(bottomRowMinuteCalculator.getInputValue()).isEqualTo(59);
        Assertions.assertThat(bottomRowMinuteCalculator.getLightColor()).isEqualTo(LightColor.YELLOW);
        Assertions.assertThat(bottomRowMinuteCalculator.getCellCountInRow()).isEqualTo(CellCountInRow.BOTTOM_MINUTE_CELL_COUNT);
    }

    @Test
    public void testBottomRowMinuteCalculatorWhenHourIsNonZero(){
        BottomRowMinuteCalculator bottomRowMinuteCalculator = new BottomRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"59");
        Assertions.assertThat(bottomRowMinuteCalculator.convertValue().toString()).isEqualTo("YYYY");
    }

    @Test
    public void testBottomRowMinuteCalculatorWhenHourIsZero(){
        BottomRowMinuteCalculator bottomRowMinuteCalculator = new BottomRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(bottomRowMinuteCalculator.convertValue().toString()).isEqualTo("OOOO");
    }

    @Test
    public void testShouldAttachNewLine(){
        BottomRowMinuteCalculator bottomRowMinuteCalculator = new BottomRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(bottomRowMinuteCalculator.shouldAttachNewLine()).isEqualTo(false);
    }

    @Test
    public void testSpecialCellsShouldBeEmpty(){
        BottomRowMinuteCalculator bottomRowMinuteCalculator = new BottomRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(bottomRowMinuteCalculator.getSpecialCells()).isEmpty();
    }
}
