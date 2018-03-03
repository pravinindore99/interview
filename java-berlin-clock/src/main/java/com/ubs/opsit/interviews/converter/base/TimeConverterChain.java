package com.ubs.opsit.interviews.converter.base;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.model.Clock;

public class TimeConverterChain implements IConverterChain {

    protected IBaseCalculator baseCalculator;

    protected IConverterChain nextConverterChain;

    public TimeConverterChain(IBaseCalculator baseCalculator) {
        this.baseCalculator = baseCalculator;
    }

    @Override
    public void setNextConverterChain(IConverterChain converterChain) {
        this.nextConverterChain=converterChain;
    }

    @Override
    public IConverterChain getNextConverterChain() {
        return nextConverterChain;
    }

    @Override
    public IBaseCalculator getBaseCalculator() {
        return baseCalculator;
    }

    @Override
    public StringBuilder doConvert(Clock clock, StringBuilder initialValueForThisConverter) {
        StringBuilder result =  initialValueForThisConverter.append(this.baseCalculator.convertValue());
        if(this.nextConverterChain!=null){
            this.nextConverterChain.doConvert(clock,result);
        }
        return result;
    }
}
