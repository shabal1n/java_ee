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
import java.util.ArrayList;
import java.util.List;

import static com.bookout.util.PageNames.MAIN_JSP;

public class MainService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantsService.class);

    RestaurantDAOInterface<Restaurant> restaurantsDAO = new RestaurantDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        List<Restaurant> restaurants = restaurantsDAO.findAll();
        restaurants.sort((o1, o2) -> {
            if (o1.getRating() < o2.getRating())
                return 1;
            else if (o2.getRating() < o1.getRating())
                return -1;
            return 0;
        });
        List<Restaurant> top6 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            top6.add(restaurants.get(i));
        }
        request.setAttribute("top1", restaurants.get(0));
        request.setAttribute("top6", top6);
        dispatcher = request.getRequestDispatcher(MAIN_JSP);
        dispatcher.forward(request, response);
    }
}
