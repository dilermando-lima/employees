package com.project.employees.utils;

import java.util.regex.Pattern;

public class UtilsValidate {



    public static boolean isEmailValid(String email, boolean ignoreNull) {

        if (ignoreNull && email == null)
            return true;

        if (email == null || "".equals(email.trim()))
            return false;

        final Pattern EMAIL_REGEX = Pattern.compile(
                "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
                Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }


    
    public static boolean isFloatValid(String number, boolean ignoreNull) {

        if (ignoreNull && number == null)
            return true;

        if (number == null)
            return false;

        try {
            Float.parseFloat(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
