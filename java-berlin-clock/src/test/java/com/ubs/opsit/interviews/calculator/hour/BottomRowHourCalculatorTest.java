package com.ubs.opsit.interviews.calculator.hour;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.calculator.hour.BottomRowHourCalculator;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BottomRowHourCalculatorTest {

    @Test
    public void testBottomRowHourCalculatorConstructor(){
        BottomRowHourCalculator bottomRowHourCalculator = new BottomRowHourCalculator(LightColor.RED, CellCountInRow.BOTTOM_HOUR_CELL_COUNT,"23");
        Assertions.assertThat(bottomRowHourCalculator.getInputValue()).isEqualTo(23);
        Assertions.assertThat(bottomRowHourCalculator.getLightColor()).isEqualTo(LightColor.RED);
        Assertions.assertThat(bottomRowHourCalculator.getCellCountInRow()).isEqualTo(CellCountInRow.BOTTOM_HOUR_CELL_COUNT);
    }

    @Test
    public void testBottomRowHourCalculatorWhenHourIsNonZero(){
        BottomRowHourCalculator bottomRowHourCalculator = new BottomRowHourCalculator(LightColor.RED, CellCountInRow.BOTTOM_HOUR_CELL_COUNT,"23");
        Assertions.assertThat(bottomRowHourCalculator.convertValue().toString()).isEqualTo("RRRO"+ IBaseCalculator.newLine);
    }

    @Test
    public void testBottomRowHourCalculatorWhenHourIsZero(){
        BottomRowHourCalculator bottomRowHourCalculator = new BottomRowHourCalculator(LightColor.RED, CellCountInRow.BOTTOM_HOUR_CELL_COUNT,"00");
        Assertions.assertThat(bottomRowHourCalculator.convertValue().toString()).isEqualTo("OOOO"+ IBaseCalculator.newLine);
    }

    @Test
    public void testShouldAttachNewLine(){
        BottomRowHourCalculator bottomRowHourCalculator = new BottomRowHourCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(bottomRowHourCalculator.shouldAttachNewLine()).isEqualTo(true);
    }

    @Test
    public void testSpecialCellsShouldBeEmpty(){
        BottomRowHourCalculator bottomRowHourCalculator = new BottomRowHourCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT,"00");
        Assertions.assertThat(bottomRowHourCalculator.getSpecialCells()).isEmpty();
    }
}
