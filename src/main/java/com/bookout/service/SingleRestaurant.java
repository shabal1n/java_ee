package com.bookout.service;

import com.bookout.database.dao.AvailableDateTimeDAOImpl;
import com.bookout.database.dao.RestaurantDAOImpl;
import com.bookout.database.daointerfaces.AvailableDateTimeDAO;
import com.bookout.database.daointerfaces.RestaurantDAO;
import com.bookout.entity.AvailableDateTime;
import com.bookout.entity.Restaurant;
import com.bookout.entity.User;
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
    RestaurantDAO<Restaurant> restaurantDAO = new RestaurantDAOImpl();
    private final AvailableDateTimeDAO<AvailableDateTime> dateTimeDAO = new AvailableDateTimeDAOImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        User user = (User) request.getSession().getAttribute("user");
        if(user != null) {
            RequestDispatcher dispatcher;
            long restaurantId = Long.parseLong(request.getParameter("id"));
            int local_id = local.getLocalId((String) request.getSession().getAttribute("language"));

            Restaurant currentRestaurant = restaurantDAO.findRestaurantByLocalizationId(restaurantId, local_id);
            List<AvailableDateTime> dateTimeList = dateTimeDAO.getAvailableTimeByRestaurantId(currentRestaurant.getLocalItemId());
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
