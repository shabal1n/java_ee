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

import static com.bookout.util.Constants.local;
import static com.bookout.util.PageNames.CATEGORIES_JSP;

public class CategoriesService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantsService.class);
    private final RestaurantDAOInterface<Restaurant> restaurantDAO = new RestaurantDAO();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        String category = request.getParameter("category_name");

        int local_id = local.getLocalId((String) request.getSession().getAttribute("language"));

        List<Restaurant> restaurants = restaurantDAO.getRestaurantsByCategoryId(categoryId(category), local_id);

        request.setAttribute("restaurants", restaurants);
        dispatcher = request.getRequestDispatcher(CATEGORIES_JSP);
        response.setCharacterEncoding("UTF-8");
        dispatcher.forward(request, response);
    }

    private int categoryId(String category) {
        int categoryId = 0;
        switch (category) {
            case "italian":
                categoryId = 1;
                break;
            case "japanese":
                categoryId = 2;
                break;
            case "european":
                categoryId = 3;
                break;
            case "asian":
                categoryId = 4;
                break;
            case "coffee":
                categoryId = 5;
                break;
        }
        return categoryId;
    }
}
