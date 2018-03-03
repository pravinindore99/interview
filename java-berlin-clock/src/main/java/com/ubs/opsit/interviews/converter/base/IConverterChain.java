package com.ubs.opsit.interviews.converter.base;

import com.ubs.opsit.interviews.calculator.base.IBaseCalculator;
import com.ubs.opsit.interviews.model.Clock;

public interface IConverterChain {

    void setNextConverterChain(IConverterChain converterChain);

    IConverterChain getNextConverterChain();

    IBaseCalculator getBaseCalculator();

    StringBuilder doConvert(Clock clock , StringBuilder initialValueForThisConverter);
}
