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

import static com.bookout.util.Constants.local;
import static com.bookout.util.PageNames.MAIN_JSP;

public class MainService implements Service {
    private static final Logger LOGGER = LogManager.getLogger(RestaurantsService.class);

    private final RestaurantDAOInterface<Restaurant> restaurantsDAO = new RestaurantDAO();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        int local_id = local.getLocalId((String) request.getSession().getAttribute("language"));

        List<Restaurant> restaurants = sort(restaurantsDAO.findAllByLocal(local_id));

        List<Restaurant> top6 = getTop(restaurants);

        request.setAttribute("top1", restaurants.get(0));
        request.setAttribute("top6", top6);
        dispatcher = request.getRequestDispatcher(MAIN_JSP);
        dispatcher.forward(request, response);
    }

    private List<Restaurant> sort(List<Restaurant> restaurants) {
        restaurants.sort((o1, o2) -> {
            if (o1.getRating() < o2.getRating())
                return 1;
            else if (o2.getRating() < o1.getRating())
                return -1;
            return 0;
        });
        return restaurants;
    }

    private List<Restaurant> getTop(List<Restaurant> restaurants) {
        List<Restaurant> top6 = new ArrayList<>();
        if(restaurants.size() >= 6) {
            for (int i = 0; i < 6; i++) {
                top6.add(restaurants.get(i));
            }
        } else {
            top6.addAll(restaurants);
        }
        return top6;
    }
}
