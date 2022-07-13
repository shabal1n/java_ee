package com.bookout.service;

import com.bookout.database.dao.RestaurantDAOImpl;
import com.bookout.database.daointerfaces.RestaurantDAO;
import com.bookout.enitiy.Restaurant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.bookout.util.Constants.local;
import static com.bookout.util.PageNames.SEARCH_JSP;

public class SearchService implements Service {
    private final RestaurantDAO<Restaurant> restaurantDAO = new RestaurantDAOImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        int localId = local.getLocalId((String) request.getSession().getAttribute("language"));
        String searchText = request.getParameter("search_text");
        List<Restaurant> restaurants = restaurantDAO.findAllByLocal(localId);
        restaurants = searchRestaurant(restaurants, searchText);

        request.setAttribute("restaurants", restaurants);
        dispatcher = request.getRequestDispatcher(SEARCH_JSP);
        dispatcher.forward(request, response);
    }

    private List<Restaurant> searchRestaurant(List<Restaurant> restaurants, String searchText) {
        List<Restaurant> result = new ArrayList<>();
        for (Restaurant rest: restaurants) {
            if(rest.getName().toLowerCase().contains(searchText.toLowerCase())) {
                result.add(rest);
            }
        }
        return result;
    }
}
