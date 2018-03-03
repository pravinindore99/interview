package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.calculator.hour.BottomRowHourCalculator;
import com.ubs.opsit.interviews.calculator.hour.TopRowHourCalculator;
import com.ubs.opsit.interviews.calculator.minute.BottomRowMinuteCalculator;
import com.ubs.opsit.interviews.calculator.minute.TopRowMinuteCalculator;
import com.ubs.opsit.interviews.calculator.second.SecondCalculator;
import com.ubs.opsit.interviews.converter.base.IConverterChain;
import com.ubs.opsit.interviews.converter.base.TimeConverterChain;
import com.ubs.opsit.interviews.enums.CellCountInRow;
import com.ubs.opsit.interviews.enums.LightColor;
import com.ubs.opsit.interviews.model.Clock;
import com.ubs.opsit.interviews.populator.ClockPopulator;
import com.ubs.opsit.interviews.util.ClockUtil;
import com.ubs.opsit.interviews.validators.ClockValidator;

public class BerlinTimeConverter implements TimeConverter {

    @Override
    public String convertTime(String aTime) {
        this.preValidateInput(aTime);
        Clock clock = ClockPopulator.populateClockObjectFromTokens(ClockUtil.createTokensFromInput(aTime));
        IConverterChain converterChain = this.initializeConverterChain(clock);
        return converterChain.doConvert(clock,new StringBuilder()).toString();
    }

    public void preValidateInput(String aTime){
        (new ClockValidator(aTime)).validate();
    }

    public IConverterChain initializeConverterChain(Clock clock){
        TimeConverterChain bottomRowMinuteConverterChain = new TimeConverterChain(new BottomRowMinuteCalculator(LightColor.YELLOW, CellCountInRow.BOTTOM_MINUTE_CELL_COUNT, clock.getMinutes()));
        bottomRowMinuteConverterChain.setNextConverterChain(null);

        TimeConverterChain topRowMinuteConverterChain = new TimeConverterChain(new TopRowMinuteCalculator(LightColor.YELLOW,CellCountInRow.TOP_MINUTE_CELL_COUNT, clock.getMinutes()));
        topRowMinuteConverterChain.setNextConverterChain(bottomRowMinuteConverterChain);

        TimeConverterChain bottomRowHourConverterChain = new TimeConverterChain(new BottomRowHourCalculator(LightColor.RED,CellCountInRow.BOTTOM_HOUR_CELL_COUNT,clock.getHours()));
        bottomRowHourConverterChain.setNextConverterChain(topRowMinuteConverterChain);

        TimeConverterChain topRowHourConverterChain = new TimeConverterChain(new TopRowHourCalculator(LightColor.RED,CellCountInRow.TOP_HOUR_CELL_COUNT, clock.getHours()));
        topRowHourConverterChain.setNextConverterChain(bottomRowHourConverterChain);

        TimeConverterChain secondConverterChain = new TimeConverterChain(new SecondCalculator(clock.getSeconds()));
        secondConverterChain.setNextConverterChain(topRowHourConverterChain);

        return secondConverterChain;
    }

}
