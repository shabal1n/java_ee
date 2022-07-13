package com.bookout.service;

import com.bookout.database.dao.UserDAOImpl;
import com.bookout.database.daointerfaces.UserDAO;
import com.bookout.enitiy.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.bookout.util.PageNames.LOGIN_JSP;
import static com.bookout.util.Pages.MAIN_PAGE;
public class LoginService implements Service{
    private static final Logger LOGGER = LogManager.getLogger(LoginService.class);
    private final UserDAO<User> userDAO = new UserDAOImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LOGIN_JSP);

        if(request.getMethod().equals("POST")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User loginUser = userDAO.getByEmail(email);
            HttpSession session = request.getSession();
            if(loginUser != null && loginUser.getPasswordHash().equals(password)) {
                LOGGER.info("Logged in as " + loginUser.getFirstName());
                session.setAttribute("user", loginUser);
                session.setAttribute("admin", loginUser.isAdmin());
                session.setAttribute("language", loginUser.getLocalName());
                response.sendRedirect(MAIN_PAGE);
                return;
            }
        }
        dispatcher.forward(request, response);
    }
}
