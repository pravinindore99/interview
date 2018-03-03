package com.ubs.opsit.interviews.validator;

import com.ubs.opsit.interviews.constants.ErrorConstants;
import com.ubs.opsit.interviews.validators.ClockValidator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ClockValidatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInputIsNotNullOrEmptyShouldThrowException(){
        ClockValidator clockValidator = new ClockValidator("");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_IS_NULL.getErrorMessage());
        clockValidator.validate();
    }

    @Test
    public void testInputIsIncorrectFormat_Second_FieldAbsent(){
        ClockValidator clockValidator = new ClockValidator("13:12");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        clockValidator.validate();
    }

    @Test
    public void testInputIsIncorrectFormat_Hour_Field_Incorect(){
        ClockValidator clockValidator = new ClockValidator("25:12:10");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        clockValidator.validate();
    }

    @Test
    public void testInputIsIncorrectFormat_Minute_Field_Incorect(){
        ClockValidator clockValidator = new ClockValidator("24:62:10");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        clockValidator.validate();
    }


    @Test
    public void testInputIsIncorrectFormat_Second_Field_Incorect(){
        ClockValidator clockValidator = new ClockValidator("24:59:70");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        clockValidator.validate();
    }

    @Test
    public void testInputIsIncorrectFormat_NonNumeric(){
        ClockValidator clockValidator = new ClockValidator("AA:59:70");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        clockValidator.validate();
    }

    @Test
    public void testInputIsIncorrectFormat_WhenNegative(){
        ClockValidator clockValidator = new ClockValidator("-12:59:12");
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        clockValidator.validate();
    }

    @Test
    public void testValidateSuccessScenario(){
        ClockValidator clockValidator = new ClockValidator("13:12:11");
        clockValidator.validate();
    }

    @Test
    public void testValidateSuccessScenario_When_All_Zero(){
        ClockValidator clockValidator = new ClockValidator("00:00:00");
        clockValidator.validate();
    }

}
