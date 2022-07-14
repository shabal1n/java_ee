package com.bookout.service;

import com.bookout.database.dao.AdminDAOImpl;
import com.bookout.database.dao.RestaurantDAOImpl;
import com.bookout.database.daointerfaces.RestaurantDAO;
import com.bookout.entity.Restaurant;
import com.bookout.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.nio.charset.StandardCharsets;

import static com.bookout.util.Constants.local;
import static com.bookout.util.PageNames.ADMIN_JSP;
import static com.bookout.util.PageNames.ERROR_JSP;

public class AdminRestaurantService implements Service {
    RestaurantDAO<Restaurant> restaurantDAO = new RestaurantDAOImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(ADMIN_JSP);

        User user = (User) request.getSession().getAttribute("user");
        int restaurantId = new AdminDAOImpl().getRestaurantIdByAdminId(user.getId());
        int localId = local.getLocalId((String) request.getSession().getAttribute("language"));
        Restaurant restaurant = restaurantDAO.findRestaurantByLocalizationId(restaurantId, localId);

        if(request.getMethod().equals("POST")) {
            String imageUrl = request.getParameter("image");
            String address = request.getParameter("address");
            int capacity = Integer.parseInt(request.getParameter("capacity"));

            if (!imageUrl.isEmpty()) restaurant.setImageUrl(imageUrl);
            if (!address.isEmpty()) {
                String encMessage = new String(address.getBytes(), StandardCharsets.UTF_8);
                restaurant.setAddress(encMessage);
            }
            if (capacity != 0) restaurant.setCapacity(capacity);

            restaurantDAO.update(restaurant);
        } else {
            if(user.isAdmin()) {
                request.setAttribute("restaurant", restaurant);
            } else {
                dispatcher = request.getRequestDispatcher(ERROR_JSP);
            }
        }

        dispatcher.forward(request, response);
    }
}
