package com.bookout.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Map<String, Service> SERVICE_MAP = new HashMap<>();
    private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();

    static {
        SERVICE_MAP.put("/error", new ErrorService());
        SERVICE_MAP.put("/main", new MainService());
        SERVICE_MAP.put("/restaurants", new RestaurantsService());
        SERVICE_MAP.put("/category", new CategoriesService());
        SERVICE_MAP.put("/login", new LoginService());
        SERVICE_MAP.put("/registration", new RegistrationService());
        SERVICE_MAP.put("/book", new SingleRestaurant());
        SERVICE_MAP.put("/reserve", new BookingService());
        SERVICE_MAP.put("/profile", new ProfileService());
        SERVICE_MAP.put("/search", new SearchService());
        SERVICE_MAP.put("/admin", new AdminRestaurantService());
        SERVICE_MAP.put("/reservations", new AdminBookingService());
    }

    public static ServiceFactory getInstance() {
        return SERVICE_FACTORY;
    }

    public Service getService(String request) {
        Service service = null;

        for (Map.Entry<String, Service> pair : SERVICE_MAP.entrySet()) {
            if (request.equalsIgnoreCase(pair.getKey())) {
                service = SERVICE_MAP.get(pair.getKey());
            }
        }
        if(service == null) service = SERVICE_MAP.get("/error");

        return service;
    }
}
