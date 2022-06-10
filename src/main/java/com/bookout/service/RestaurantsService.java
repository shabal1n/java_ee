package com.bookout.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.bookout.util.PageNames.RESTAURANTS_JSP;

public class RestaurantsService implements Service {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;

        dispatcher = request.getRequestDispatcher(RESTAURANTS_JSP);
        dispatcher.forward(request, response);
    }
}
