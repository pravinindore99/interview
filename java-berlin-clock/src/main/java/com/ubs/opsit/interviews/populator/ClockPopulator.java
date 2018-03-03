package com.ubs.opsit.interviews.populator;

import com.ubs.opsit.interviews.model.Clock;

import java.util.List;

public class ClockPopulator {

    public static Clock populateClockObjectFromTokens(List<String> tokens){
        Clock clock = new Clock();
        if(tokens!=null && tokens.size()==3){
            clock = new Clock(tokens.get(0),tokens.get(1),tokens.get(2));
        }
        return clock;
    }
}
