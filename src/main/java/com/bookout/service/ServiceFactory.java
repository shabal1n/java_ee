package com.bookout.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Logger LOGGER = LogManager.getLogger(ServiceFactory.class);
    private static final Map<String, Service> SERVICE_MAP = new HashMap<>();
    private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();

    static {
        SERVICE_MAP.put("/error", new ErrorService());
        SERVICE_MAP.put("/main", new MainService());
        SERVICE_MAP.put("/map", new MapService());
        SERVICE_MAP.put("/restaurants", new RestaurantsService());
        SERVICE_MAP.put("/category", new CategoriesService());
        SERVICE_MAP.put("/login", new LoginService());
        SERVICE_MAP.put("/registration", new RegistrationService());
    }

    public static ServiceFactory getInstance() {
        return SERVICE_FACTORY;
    }

    public Service getService(String request) {
        Service service = SERVICE_MAP.get("/error");

        for (Map.Entry<String, Service> pair : SERVICE_MAP.entrySet()) {
            if (request.equalsIgnoreCase(pair.getKey())) {
                service = SERVICE_MAP.get(pair.getKey());
            }
        }
        return service;
    }
}
