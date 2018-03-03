package com.ubs.opsit.interviews.calculator.hour;

import com.ubs.opsit.interviews.calculator.AbstractCalculator;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;

public abstract class AbstractHourCalculator extends AbstractCalculator {

    public AbstractHourCalculator(LightColor lightColor, CellCountInRow cellCountInRow, String inputValue) {
        super(lightColor, cellCountInRow, inputValue);
    }

    protected final int HOUR_REPRESENTED_BY_EACH_CELL = 5;
}
