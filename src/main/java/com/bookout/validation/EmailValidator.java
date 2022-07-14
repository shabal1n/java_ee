package com.bookout.validation;

import com.bookout.database.dao.UserDAOImpl;
import com.bookout.database.daointerfaces.UserDAO;
import com.bookout.entity.User;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private final static Pattern EMAIL_PATTERN = Pattern.compile("^[A-Z\\d._%+-]+@[A-Z\\d.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private final static UserDAO<User> userDAO = new UserDAOImpl();


    public static boolean validate(String email) {
        Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
        return emailMatcher.matches();
    }

    public static boolean exists(String email) throws SQLException {
        User user = userDAO.getUserByEmail(email);
        return user != null;
    }
}
