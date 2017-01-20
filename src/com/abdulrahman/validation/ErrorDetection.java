package com.abdulrahman.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by abdulrahman on 1/17/17.
 */
public abstract class ErrorDetection {

    public static boolean isNumber(String number){
        Pattern p = Pattern.compile("[\\d]+");
        Matcher m = p.matcher(number);
        return m.matches();
    }
}
