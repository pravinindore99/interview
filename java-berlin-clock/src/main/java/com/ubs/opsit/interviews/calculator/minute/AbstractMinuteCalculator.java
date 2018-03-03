package com.ubs.opsit.interviews.calculator.minute;

import com.ubs.opsit.interviews.calculator.AbstractCalculator;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;

public abstract class AbstractMinuteCalculator extends AbstractCalculator {

    public AbstractMinuteCalculator(LightColor lightColor, CellCountInRow cellCountInRow, String inputValue) {
        super(lightColor, cellCountInRow, inputValue);
    }

    protected final int MINUTES_REPRESENTED_BY_EACH_CELL = 5;
}
