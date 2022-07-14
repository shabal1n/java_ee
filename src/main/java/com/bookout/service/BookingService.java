package com.bookout.service;

import com.bookout.database.dao.AvailableDateTimeDAOImpl;
import com.bookout.database.dao.BookingDAOImpl;
import com.bookout.database.dao.RestaurantDAOImpl;
import com.bookout.database.daointerfaces.AvailableDateTimeDAO;
import com.bookout.database.daointerfaces.ObjectInterface;
import com.bookout.database.daointerfaces.RestaurantDAO;
import com.bookout.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.bookout.util.PageNames.BOOKING_JSP;
public class BookingService implements Service {
    private final ObjectInterface<Booking> bookingDAO = new BookingDAOImpl();
    private final RestaurantDAO<Restaurant> restaurantDAO = new RestaurantDAOImpl();
    private final AvailableDateTimeDAO<AvailableDateTime> availableDateTimeDAO = new AvailableDateTimeDAOImpl();
    private final String PROFILE_PAGE = "/profile";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;

        int restaurantId = Integer.parseInt(request.getParameter("restaurant"));
        int dateTimeId = Integer.parseInt(request.getParameter("dateTime"));
        AvailableDateTime bookingTime = availableDateTimeDAO.find(dateTimeId);
        Restaurant restaurant = restaurantDAO.find(restaurantId);
        String personsCount = request.getParameter("persons");

        if (request.getMethod().equals("POST") && personsCount != null) {
            User user = (User) request.getSession().getAttribute("user");
            int persons = Integer.parseInt(personsCount);
            bookRestaurant(user.getId(), restaurantId, bookingTime.getId(), persons);
            updateAvailableDateTime(bookingTime);
            response.sendRedirect(PROFILE_PAGE);
            return;
        }

        request.setAttribute("restaurant", restaurant);
        request.setAttribute("dateTime", bookingTime);

        dispatcher = request.getRequestDispatcher(BOOKING_JSP);
        dispatcher.forward(request, response);
    }

    public void updateAvailableDateTime(AvailableDateTime bookingTime) throws SQLException {
        bookingTime.setBooked(true);
        availableDateTimeDAO.update(bookingTime);
    }

    public void bookRestaurant(long userId, int restaurantId, long bookingTimeId, int persons) throws SQLException {
        Booking booking = new Booking();
        booking.setUserId(userId);
        booking.setRestaurantId(restaurantId);
        booking.setDateId(bookingTimeId);
        booking.setPersonsCount(persons);
        bookingDAO.create(booking);
    }

}
