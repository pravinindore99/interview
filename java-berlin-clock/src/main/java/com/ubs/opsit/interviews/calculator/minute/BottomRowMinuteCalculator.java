package com.ubs.opsit.interviews.calculator.minute;

import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;

public class BottomRowMinuteCalculator extends AbstractMinuteCalculator {

    public BottomRowMinuteCalculator(LightColor lightColor, CellCountInRow cellCountInRow, String inputValue) {
        super(lightColor, cellCountInRow, inputValue);
    }

    @Override
    protected Integer getDivisionOrModuloResult() {
        return this.getInputValue()%MINUTES_REPRESENTED_BY_EACH_CELL;
    }

    @Override
    public Boolean shouldAttachNewLine() {
        return false;
    }
}
