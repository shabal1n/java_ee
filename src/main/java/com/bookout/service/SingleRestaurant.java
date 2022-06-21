package com.bookout.service;

import com.bookout.database.dao.AvailableDateTimeDAO;
import com.bookout.database.dao.RestaurantDAO;
import com.bookout.database.daointerfaces.AvailableDateTimeDAOInterface;
import com.bookout.database.daointerfaces.RestaurantDAOInterface;
import com.bookout.enitiy.AvailableDateTime;
import com.bookout.enitiy.Restaurant;
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
import java.util.List;

import static com.bookout.util.Constants.local;
import static com.bookout.util.PageNames.SINGLE_RESTAURANT;
import static com.bookout.util.Pages.LOGIN_PAGE;

public class SingleRestaurant implements Service {
    private static final Logger LOGGER = LogManager.getLogger(SingleRestaurant.class);
    RestaurantDAOInterface<Restaurant> restaurantDAO = new RestaurantDAO();
    private final AvailableDateTimeDAOInterface<AvailableDateTime> dateTimeDAO = new AvailableDateTimeDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        if(user != null) {
            RequestDispatcher dispatcher;
            long restaurantId = Long.parseLong(request.getParameter("id"));
            int local_id = local.getLocalId((String) request.getSession().getAttribute("language"));

            Restaurant currentRestaurant = restaurantDAO.findByLocal(restaurantId, local_id);
            List<AvailableDateTime> dateTimeList = dateTimeDAO.getByRestaurantId(currentRestaurant.getLocalItemId());
            request.setAttribute("restaurant", currentRestaurant);
            request.setAttribute("date_time", dateTimeList);


            dispatcher = request.getRequestDispatcher(SINGLE_RESTAURANT);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(LOGIN_PAGE);
            return;
        }
    }
}
