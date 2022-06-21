package com.bookout.service;

import com.bookout.enitiy.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.bookout.util.PageNames.PROFILE_JSP;

public class ProfileService implements Service {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user", user);

        dispatcher = request.getRequestDispatcher(PROFILE_JSP);
        dispatcher.forward(request, response);
    }
}
