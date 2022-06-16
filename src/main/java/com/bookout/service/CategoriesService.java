package com.bookout.service;

import com.bookout.database.dao.RestaurantDAO;
import com.bookout.database.daointerfaces.RestaurantDAOInterface;
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

import static com.bookout.util.PageNames.CATEGORIES_JSP;

public class CategoriesService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantsService.class);
    private final RestaurantDAOInterface<Restaurant> restaurantDAO = new RestaurantDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        String category = request.getParameter("category_name");
        int category_id = 0;
        switch (category) {
            case "italian":
                category_id = 1;
                break;
            case "japanese":
                category_id = 2;
                break;
            case "european":
                category_id = 3;
                break;
            case "asian":
                category_id = 4;
                break;
            case "coffee":
                category_id = 5;
                break;
        }
        List<Restaurant> restaurants = restaurantDAO.getRestaurantsByCategoryId(category_id);

        request.setAttribute("restaurants", restaurants);
        dispatcher = request.getRequestDispatcher(CATEGORIES_JSP);
        dispatcher.forward(request, response);
    }
}
