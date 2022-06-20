package com.bookout.service;

import com.bookout.database.dao.BookingDAO;
import com.bookout.database.daointerfaces.BookingDAOInterface;
import com.bookout.enitiy.Booking;
import com.bookout.enitiy.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.bookout.util.PageNames.PROFILE_JSP;

public class ProfileService implements Service {
    BookingDAOInterface<Booking> bookingsDAO = new BookingDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        User user = (User) request.getSession().getAttribute("user");
        request.setAttribute("user", user);

        dispatcher = request.getRequestDispatcher(PROFILE_JSP);
        dispatcher.forward(request, response);
    }
}
