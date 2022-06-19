package com.bookout.service;

import com.bookout.database.dao.BookingDAO;
import com.bookout.database.dao.RestaurantDAO;
import com.bookout.database.daointerfaces.BookingDAOInterface;
import com.bookout.database.daointerfaces.RestaurantDAOInterface;
import com.bookout.enitiy.Booking;
import com.bookout.enitiy.Restaurant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.bookout.util.PageNames.BOOKING_JSP;

public class BookingService implements Service {
    private final Logger LOGGER = LogManager.getLogger(BookingService.class);
    private final BookingDAOInterface<Booking> bookingDAO = new BookingDAO();
    private final RestaurantDAOInterface<Restaurant> restaurantDAO = new RestaurantDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        int restaurantId = Integer.parseInt(request.getParameter("restaurant"));
        Restaurant restaurant = restaurantDAO.find(restaurantId);
        request.setAttribute("restaurant", restaurant);

        dispatcher = request.getRequestDispatcher(BOOKING_JSP);
        dispatcher.forward(request, response);
    }
}
