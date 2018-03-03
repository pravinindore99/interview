package com.ubs.opsit.interviews.calculator.hour;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.calculator.hour.BottomRowHourCalculator;
import com.ubs.opsit.interviews.calculator.hour.TopRowHourCalculator;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TopRowHourCalculatorTest {

    @Test
    public void testTopRowHourCalculatorConstructor(){
        TopRowHourCalculator topRowHourCalculator = new TopRowHourCalculator(LightColor.RED, CellCountInRow.TOP_HOUR_CELL_COUNT,"13");
        Assertions.assertThat(topRowHourCalculator.getInputValue()).isEqualTo(13);
        Assertions.assertThat(topRowHourCalculator.getLightColor()).isEqualTo(LightColor.RED);
        Assertions.assertThat(topRowHourCalculator.getCellCountInRow()).isEqualTo(CellCountInRow.TOP_HOUR_CELL_COUNT);
    }

    @Test
    public void testTopRowHourCalculatorWhenHourIsNonZero(){
        TopRowHourCalculator topRowHourCalculator = new TopRowHourCalculator(LightColor.RED, CellCountInRow.TOP_HOUR_CELL_COUNT,"13");
        Assertions.assertThat(topRowHourCalculator.convertValue().toString()).isEqualTo("RROO"+ IBaseCalculator.newLine);
    }

    @Test
    public void testTopRowHourCalculatorWhenHourIsZero(){
        TopRowHourCalculator topRowHourCalculator = new TopRowHourCalculator(LightColor.RED, CellCountInRow.TOP_HOUR_CELL_COUNT,"00");
        Assertions.assertThat(topRowHourCalculator.convertValue().toString()).isEqualTo("OOOO"+ IBaseCalculator.newLine);
    }

    @Test
    public void testShouldAttachNewLine(){
        TopRowHourCalculator topRowHourCalculator = new TopRowHourCalculator(LightColor.RED, CellCountInRow.TOP_HOUR_CELL_COUNT,"00");
        Assertions.assertThat(topRowHourCalculator.shouldAttachNewLine()).isEqualTo(true);
    }

    @Test
    public void testSpecialCellsShouldBeEmpty(){
        TopRowHourCalculator topRowHourCalculator = new TopRowHourCalculator(LightColor.RED, CellCountInRow.TOP_HOUR_CELL_COUNT,"00");
        Assertions.assertThat(topRowHourCalculator.getSpecialCells()).isEmpty();
    }

}
