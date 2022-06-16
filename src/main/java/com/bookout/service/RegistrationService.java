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
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Objects;

import static com.bookout.util.PageNames.LOGIN_JSP;
import static com.bookout.util.PageNames.REGISTRATION_JSP;

public class RegistrationService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationService.class);
    UserDAOInterface<User> userDAO = new UserDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);

        if (request.getMethod().equals("POST")) {
            User phone = userDAO.getByPhone(request.getParameter("phone"));
            User email = userDAO.getByPhone(request.getParameter("email"));
            if(phone == null && email == null) {
                User user = new User();
                user.setFirstName(request.getParameter("name"));
                user.setEmail(request.getParameter("email"));
                user.setMobile(request.getParameter("mobile"));
                user.setPasswordHash(request.getParameter("password"));
                user.setIsAdmin(false);
                user.setLocalId(1);
                userDAO.create(user);
                LOGGER.info("User was created");
                response.sendRedirect(LOGIN_JSP);
            }
        }
        dispatcher.forward(request, response);
    }
}
