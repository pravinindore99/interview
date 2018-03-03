package com.ubs.opsit.interviews.enums;

public enum LightColor {

    YELLOW("Y"),
    RED("R");

    private String colorCode;

    private LightColor(String colorCode){
        this.colorCode=colorCode;
    }

    public String getColorCode() {
        return colorCode;
    }
}
