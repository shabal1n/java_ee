package com.bookout.util;

import com.bookout.enitiy.Category;
import com.bookout.enitiy.Local;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Constants {
    public static Pattern PHONE_PATTERN = Pattern.compile("\\+7\\d{10}|8\\d{10}");
    public static Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z\\d._%+-]+@[A-Z\\d.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Local local = new Local();

    public static final HashMap<Integer, Category> categories = new HashMap<>();
    static {
        categories.put(1, new Category(1, "italian"));
        categories.put(2, new Category(2, "japanese"));
        categories.put(3, new Category(3, "european"));
        categories.put(4, new Category(4, "asian"));
        categories.put(5, new Category(5, "coffee"));
    }
}
