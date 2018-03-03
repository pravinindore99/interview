package com.ubs.opsit.interviews.converter;

import com.ubs.opsit.interviews.BerlinTimeConverter;
import com.ubs.opsit.interviews.calculator.hour.BottomRowHourCalculator;
import com.ubs.opsit.interviews.calculator.hour.TopRowHourCalculator;
import com.ubs.opsit.interviews.calculator.minute.BottomRowMinuteCalculator;
import com.ubs.opsit.interviews.calculator.minute.TopRowMinuteCalculator;
import com.ubs.opsit.interviews.calculator.second.SecondCalculator;
import com.ubs.opsit.interviews.constants.ErrorConstants;
import com.ubs.opsit.interviews.converter.base.IConverterChain;
import com.ubs.opsit.interviews.model.Clock;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BerlinTimeConverterTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPreValidationIsWorkingWhenInputIsWrong(){
        BerlinTimeConverter berlinTimeConverter = new BerlinTimeConverter();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        berlinTimeConverter.convertTime("HH:MM:SS");
    }

    @Test
    public void testConverterChainIsInitializedCorrectly(){
        Clock clock = new Clock("23","59","59");

        BerlinTimeConverter timeConverter = new BerlinTimeConverter();
        IConverterChain chainForSecondCalculation = timeConverter.initializeConverterChain(clock);

        Assert.assertTrue(chainForSecondCalculation.getBaseCalculator() instanceof SecondCalculator);

        IConverterChain chainForTopRowHourCalculation =chainForSecondCalculation.getNextConverterChain();
        Assert.assertTrue(chainForTopRowHourCalculation.getBaseCalculator() instanceof TopRowHourCalculator);

        IConverterChain chainForBottomRowHourCalculation =chainForTopRowHourCalculation.getNextConverterChain();
        Assert.assertTrue(chainForBottomRowHourCalculation.getBaseCalculator() instanceof BottomRowHourCalculator);

        IConverterChain chainForTopMinuteHourCalculation =chainForBottomRowHourCalculation.getNextConverterChain();
        Assert.assertTrue(chainForTopMinuteHourCalculation.getBaseCalculator() instanceof TopRowMinuteCalculator);

        IConverterChain chainForBottomMinuteHourCalculation =chainForTopMinuteHourCalculation.getNextConverterChain();
        Assert.assertTrue(chainForBottomMinuteHourCalculation.getBaseCalculator() instanceof BottomRowMinuteCalculator);

        Assertions.assertThat(chainForBottomMinuteHourCalculation.getNextConverterChain()).isNull();

    }
}
