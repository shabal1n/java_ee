package com.bookout.service;

import com.bookout.database.dao.UserDAO;
import com.bookout.database.daointerfaces.UserDAOInterface;
import com.bookout.enitiy.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.regex.Matcher;

import static com.bookout.util.Constants.*;
import static com.bookout.util.PageNames.REGISTRATION_JSP;
import static com.bookout.util.Pages.LOGIN_PAGE;

public class RegistrationService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationService.class);
    private final UserDAOInterface<User> userDAO = new UserDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);

        if (request.getMethod().equals("POST")) {
            String userName = request.getParameter("name");
            userName = stringToUTF(userName);
            String mail = request.getParameter("email");
            String phone = request.getParameter("mobile");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            int localeId = getLocaleId(request);

            if(userExists(phone, email) && validateFields(phone, email)) {
                User user = new User();

                user.setFirstName(userName);
                user.setEmail(mail);
                user.setMobile(phone);
                user.setPasswordHash(password);
                user.setIsAdmin(false);
                user.setLocalId(localeId);
                userDAO.create(user);
                LOGGER.info("User was created");
                response.sendRedirect(LOGIN_PAGE);
                return;
            }
        }
        dispatcher.forward(request, response);
    }

    private String stringToUTF(String name) {
        byte[] bytes = name.getBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private boolean userExists(String phone, String email) throws SQLException {
        User phoneExists = userDAO.getByPhone(phone);
        User emailExists = userDAO.getByEmail(email);
        return phoneExists == null && emailExists == null;
    }

    private boolean validateFields(String phone, String email) {
        Matcher phoneMatcher = PHONE_PATTERN.matcher(phone);
        Matcher emailMatcher = EMAIL_PATTERN.matcher(email);
        return phoneMatcher.matches() && emailMatcher.matches();
    }

    private int getLocaleId(HttpServletRequest request) {
        if(request.getSession().getAttribute("language") == "en")
            return 2;
        return 1;
    }
}
