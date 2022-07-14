package com.bookout.service;

import com.bookout.validation.EmailValidator;
import com.bookout.validation.PhoneNumberValidator;
import com.bookout.validation.UserPasswordHashing;
import com.bookout.database.dao.UserDAOImpl;
import com.bookout.database.daointerfaces.UserDAO;
import com.bookout.entity.User;
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
import java.util.ArrayList;
import java.util.List;

import static com.bookout.util.PageNames.LOGIN_JSP;
public class LoginService implements Service{
    private static final Logger LOGGER = LogManager.getLogger(LoginService.class);
    private final UserDAO<User> userDAO = new UserDAOImpl();

    private final String MAIN_PAGE = "/main";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(LOGIN_JSP);

        if(request.getMethod().equals("POST")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            password = UserPasswordHashing.hash(password);
            User loginUser = userDAO.getUserByEmail(email);
            HttpSession session = request.getSession();
            List<String> errors = errorMessage(loginUser, password);
            if(errors.isEmpty()) {
                LOGGER.info("Logged in as " + loginUser.getFirstName());
                session.setAttribute("user", loginUser);
                session.setAttribute("admin", loginUser.isAdmin());
                session.setAttribute("language", loginUser.getLocalName());
                response.sendRedirect(MAIN_PAGE);
                return;
            } else {
                request.setAttribute("errorMsg", errors);
            }
        }
        dispatcher.forward(request, response);
    }

    private List<String> errorMessage(User loginUser, String password) throws SQLException {
        List<String> error = new ArrayList<>();
        if(loginUser != null) {
            if (!EmailValidator.validate(loginUser.getEmail())) {
                error.add("Invalid e-mail");
            }
            if (!EmailValidator.exists(loginUser.getEmail())) {
                error.add("E-mail doesn't exist");
            }
            if (!loginUser.getPasswordHash().equals(password)) {
                error.add("Incorrect password");
            }
        } else {
            error.add("Can't find user with this credentials");
        }

        return error;
    }
}
