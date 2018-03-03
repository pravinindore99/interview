package com.ubs.opsit.interviews.calculator.second;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.constants.BerlinConstants;
import com.ubs.opsit.interviews.enums.LightColor;

public class SecondCalculator implements IBaseCalculator {

    private Integer inputValue;

    public Integer getInputValue() {
        return inputValue;
    }

    public SecondCalculator(String inputValue) {
        this.inputValue = Integer.parseInt(inputValue);
    }

    @Override
    public StringBuilder convertValue() {
        return calculateSecondForTopLamp();
    }

    protected StringBuilder calculateSecondForTopLamp(){
        StringBuilder stringBuilder = new StringBuilder();
        if(this.inputValue%2==0){
            stringBuilder.append(LightColor.YELLOW.getColorCode());
        }else {
            stringBuilder.append(BerlinConstants.CELL_STATE_OFF);
        }
        return stringBuilder.append(newLine);
    }
}
