package com.bookout.service;

import com.bookout.validation.EmailValidator;
import com.bookout.validation.UserPasswordHashing;
import com.bookout.database.dao.UserDAOImpl;
import com.bookout.database.daointerfaces.UserDAO;
import com.bookout.entity.User;
import com.bookout.validation.PhoneNumberValidator;
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
import java.util.ArrayList;
import java.util.List;

import static com.bookout.util.Constants.*;
import static com.bookout.util.PageNames.REGISTRATION_JSP;
import static com.bookout.util.Pages.LOGIN_PAGE;

public class RegistrationService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationService.class);
    private final UserDAO<User> userDAO = new UserDAOImpl();
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
            String locale = (String) request.getSession().getAttribute("language");
            int localeId = local.getLocalId(locale);

            if(!userExists(phone, email) && validateFields(phone, email)) {
                User user = new User();
                password = UserPasswordHashing.hash(password);
                user.setFirstName(userName);
                user.setEmail(mail);
                user.setMobile(phone);
                user.setPasswordHash(password);
                user.setAdmin(false);
                user.setLocalId(localeId);
                userDAO.create(user);
                LOGGER.info("User was created");
                response.sendRedirect(LOGIN_PAGE);
                return;
            } else {
                request.setAttribute("errorMsg", errorMessage(phone, email));
            }
        }
        dispatcher.forward(request, response);
    }

    private String stringToUTF(String name) {
        byte[] bytes = name.getBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private boolean userExists(String phone, String email) throws SQLException {
        return PhoneNumberValidator.exists(phone) && EmailValidator.exists(email);
    }

    private boolean validateFields(String phone, String email) {
        return PhoneNumberValidator.validate(phone) && EmailValidator.validate(email);
    }

    private List<String> errorMessage(String phone, String email) throws SQLException {
        List<String> error = new ArrayList<>();
        if (!EmailValidator.validate(email)) {
            error.add("Invalid e-mail");
        }
        if (!PhoneNumberValidator.validate(phone)) {
            error.add("Invalid phone number");
        }
        if(PhoneNumberValidator.exists(phone)) {
            error.add("Phone number is registered");
        }

        if(EmailValidator.exists(email)) {
            error.add("E-mail already registered");
        }
        return error;
    }
}
