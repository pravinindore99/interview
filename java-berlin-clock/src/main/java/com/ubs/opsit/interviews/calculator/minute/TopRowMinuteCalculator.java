package com.ubs.opsit.interviews.calculator.minute;

import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;

import java.util.Arrays;
import java.util.List;

public class TopRowMinuteCalculator extends AbstractMinuteCalculator {

    public TopRowMinuteCalculator(LightColor lightColor, CellCountInRow cellCountInRow, String inputValue) {
        super(lightColor, cellCountInRow, inputValue);
    }

    @Override
    protected Integer getDivisionOrModuloResult() {
        return this.getInputValue()/MINUTES_REPRESENTED_BY_EACH_CELL;
    }


    public List<Integer> getSpecialCells() {
        return Arrays.asList(3,6,9);
    }
}
