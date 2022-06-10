package com.bookout.controller;


import com.bookout.service.Service;
import com.bookout.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class ReservationServiceController extends HttpServlet {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    public ReservationServiceController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestString = request.getServletPath();
        Service service = serviceFactory.getService(requestString);
        try {
            service.execute(request, response);
        } catch (ParseException | SQLException e) {
            LOGGER.error(e);
        }
    }

    public void destroy() {

    }
}
