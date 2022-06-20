package com.bookout.service;

import com.bookout.database.dao.RestaurantDAO;
import com.bookout.database.daointerfaces.RestaurantDAOInterface;
import com.bookout.enitiy.Local;
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
import java.util.List;

import static com.bookout.util.PageNames.RESTAURANTS_JSP;

public class RestaurantsService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantsService.class);
    private final RestaurantDAOInterface<Restaurant> restaurantDAO = new RestaurantDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        Local local = new Local();
        int local_id = local.getLocalId((String) request.getSession().getAttribute("language"));
        List<Restaurant> restaurants = restaurantDAO.findAllByLocal(local_id);
        request.setAttribute("restaurants", restaurants);
        dispatcher = request.getRequestDispatcher(RESTAURANTS_JSP);
        dispatcher.forward(request, response);
    }
}
