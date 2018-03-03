package com.ubs.opsit.interviews.calculator.hour;

import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;

public class BottomRowHourCalculator extends AbstractHourCalculator {

    public BottomRowHourCalculator(LightColor lightColor, CellCountInRow cellCountInRow, String inputValue) {
        super(lightColor, cellCountInRow, inputValue);
    }

    @Override
    protected Integer getDivisionOrModuloResult() {
        return this.getInputValue()% HOUR_REPRESENTED_BY_EACH_CELL;
    }
}
