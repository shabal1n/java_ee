package com.bookout.validation;

import com.bookout.database.dao.UserDAOImpl;
import com.bookout.database.daointerfaces.UserDAO;
import com.bookout.entity.User;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private final static Pattern PHONE_PATTERN = Pattern.compile("\\+7\\d{10}|8\\d{10}");
    private final static UserDAO<User> userDAO = new UserDAOImpl();


    public static boolean validate(String phone) {
        Matcher phoneMatcher = PHONE_PATTERN.matcher(phone);
        return phoneMatcher.matches();
    }

    public static boolean exists(String phone) throws SQLException {
        User user = userDAO.getUserByPhone(phone);
        return user != null;
    }
}
