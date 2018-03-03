package com.ubs.opsit.interviews.validators;

import com.ubs.opsit.interviews.constants.BerlinConstants;
import com.ubs.opsit.interviews.constants.ErrorConstants;
import com.ubs.opsit.interviews.validators.base.IBaseValidator;
import org.apache.commons.lang.StringUtils;

public class ClockValidator implements IBaseValidator {

    private String timeIn24HrFormat;

    public ClockValidator(String timeIn24HrFormat){
        this.timeIn24HrFormat=timeIn24HrFormat;
    }

    @Override
    public void validate() {
        this.checkInputIsNotNullOrEmpty();
        this.checkInputIsInCorrectFormat();
    }

    private void checkInputIsNotNullOrEmpty(){
        if(StringUtils.isEmpty(this.timeIn24HrFormat)){
            throw new IllegalArgumentException(ErrorConstants.INPUT_IS_NULL.getErrorMessage());
        }
    }

    private void checkInputIsInCorrectFormat(){
        if((StringUtils.isNotEmpty(this.timeIn24HrFormat))&&(!timeIn24HrFormat.matches(BerlinConstants.PATTERN_FOR_24HR_FORMAT))){
            throw new IllegalArgumentException(ErrorConstants.INPUT_FORMAT_INVALID.getErrorMessage());
        }
    }
}
