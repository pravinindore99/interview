package com.ubs.opsit.interviews.constants;

public enum  ErrorConstants {

    INPUT_IS_NULL("Input value should not be null or empty."),
    INPUT_FORMAT_INVALID("Input value is in incorrect format.Should be hh:mm:ss");

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    private ErrorConstants(String errorMessage){
        this.errorMessage=errorMessage;
    }
}
