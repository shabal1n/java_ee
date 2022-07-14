package com.bookout.service;

import com.bookout.database.dao.AdminDAOImpl;
import com.bookout.database.dao.BookingDAOImpl;
import com.bookout.database.daointerfaces.BookingDAO;
import com.bookout.entity.Booking;
import com.bookout.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static com.bookout.util.PageNames.ADMIN_BOOKING_JSP;

public class AdminBookingService implements Service {
    private final BookingDAO<Booking> bookingDAO = new BookingDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher;

        User user = (User) request.getSession().getAttribute("user");
        int restaurantId = new AdminDAOImpl().getRestaurantIdByAdminId(user.getId());
        List<Booking> bookings = bookingDAO.getBookingsByRestaurantId(restaurantId);
        request.setAttribute("reservations", bookings);

        dispatcher = request.getRequestDispatcher(ADMIN_BOOKING_JSP);
        dispatcher.forward(request, response);
    }
}
