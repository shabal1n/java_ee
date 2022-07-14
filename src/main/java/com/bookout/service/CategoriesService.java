package com.bookout.service;

import com.bookout.database.dao.RestaurantDAOImpl;
import com.bookout.database.daointerfaces.RestaurantDAO;
import com.bookout.entity.Restaurant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.bookout.util.Constants.local;
import static com.bookout.util.PageNames.CATEGORIES_JSP;

public class CategoriesService implements Service {
    private final RestaurantDAO<Restaurant> restaurantDAO = new RestaurantDAOImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        int category = Integer.parseInt(request.getParameter("category_id"));

        int local_id = local.getLocalId((String) request.getSession().getAttribute("language"));

        List<Restaurant> restaurants = restaurantDAO.getRestaurantsByCategoryId(category, local_id);

        request.setAttribute("restaurants", restaurants);
        dispatcher = request.getRequestDispatcher(CATEGORIES_JSP);
        dispatcher.forward(request, response);
    }
}
