package com.codejstudio.common.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {
    public static boolean isMobile(String mobile) {

        return Pattern.matches("^1[0-9]{10}$", mobile);
    }

    public static boolean isNullString(String o) {
        return o == null;
    }

    public static boolean isEmptyString(String s) {
        return isNullString(s) || "".equals(s);
    }

    public static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
