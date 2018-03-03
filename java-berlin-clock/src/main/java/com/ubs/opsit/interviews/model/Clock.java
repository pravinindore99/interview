package com.ubs.opsit.interviews.model;

public class Clock {

    private String hours;

    private String minutes;

    private String seconds;

    public Clock() {
    }

    public Clock(String hours, String minutes, String seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getHours() {
        return hours;
    }

    public String getMinutes() {
        return minutes;
    }

    public String getSeconds() {
        return seconds;
    }

}
