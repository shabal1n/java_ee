package com.bookout.service;

import com.bookout.database.dao.AvailableDateTimeDAO;
import com.bookout.database.dao.BookingDAO;
import com.bookout.database.dao.RestaurantDAO;
import com.bookout.database.daointerfaces.AvailableDateTimeDAOInterface;
import com.bookout.database.daointerfaces.BookingDAOInterface;
import com.bookout.database.daointerfaces.RestaurantDAOInterface;
import com.bookout.enitiy.*;
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
import static com.bookout.util.Pages.LOGIN_PAGE;
import static com.bookout.util.Pages.PROFILE_PAGE;

public class BookingService implements Service {
    private final Logger LOGGER = LogManager.getLogger(BookingService.class);
    private final BookingDAOInterface<Booking> bookingDAO = new BookingDAO();
    private final RestaurantDAOInterface<Restaurant> restaurantDAO = new RestaurantDAO();
    private final AvailableDateTimeDAOInterface<AvailableDateTime> timeDAO = new AvailableDateTimeDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;

        int restaurantId = Integer.parseInt(request.getParameter("restaurant"));
        int dateTimeId = Integer.parseInt(request.getParameter("dateTime"));
        AvailableDateTime bookingTime = timeDAO.find(dateTimeId);
        Restaurant restaurant = restaurantDAO.find(restaurantId);
        String numOfPersons = request.getParameter("persons");

        if (request.getMethod().equals("POST") && numOfPersons != null) {
            Booking booking = new Booking();
            User user = (User) request.getSession().getAttribute("user");
            int persons = Integer.parseInt(numOfPersons);
            booking.setUserId(user.getId());
            booking.setRestaurantId(restaurantId);
            booking.setDateId(bookingTime.getId());
            booking.setNumOfPersons(persons);
            bookingDAO.create(booking);
            bookingTime.setBooked(true);
            timeDAO.update(bookingTime);
            response.sendRedirect(PROFILE_PAGE);
            return;
        }

        request.setAttribute("restaurant", restaurant);
        request.setAttribute("dateTime", bookingTime);

        dispatcher = request.getRequestDispatcher(BOOKING_JSP);
        dispatcher.forward(request, response);
    }

}
