package com.bookout.util;

import java.util.regex.Pattern;

public class Constants {
    public static Pattern PHONE_PATTERN = Pattern.compile("\\+7\\d{10}|8\\d{10}");
    public static Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z\\d._%+-]+@[A-Z\\d.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
}
