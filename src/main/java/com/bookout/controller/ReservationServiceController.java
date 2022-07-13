package com.bookout.controller;


import com.bookout.service.Service;
import com.bookout.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.http.*;


public class ReservationServiceController extends HttpServlet {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private final ServiceFactory serviceFactory = ServiceFactory.getInstance();

    public ReservationServiceController() {super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        String requestString = request.getServletPath();
        Service service = serviceFactory.getService(requestString);
        try {
            service.execute(request, response);
        } catch (Exception e) {
            LOGGER.error(e);
        }
    }
}
