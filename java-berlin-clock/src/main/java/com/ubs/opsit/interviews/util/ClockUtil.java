package com.ubs.opsit.interviews.util;

import com.ubs.opsit.interviews.constants.BerlinConstants;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClockUtil {

    public static List<String> createTokensFromInput(final String timeIn24HrFormat){
        List<String> tokens = new ArrayList<>();
        if(StringUtils.isNotEmpty(timeIn24HrFormat)){
            tokens= Arrays.asList(timeIn24HrFormat.split(BerlinConstants.TOKEN_VALUE));
        }
        return tokens;
    }
}
