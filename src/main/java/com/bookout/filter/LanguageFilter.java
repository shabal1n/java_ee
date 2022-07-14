package com.bookout.filter;

import com.bookout.database.dao.UserDAOImpl;
import com.bookout.database.daointerfaces.UserDAO;
import com.bookout.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class LanguageFilter implements Filter {

    private final int RUS_LOCALE = 1;
    private final int ENG_LOCALE = 2;
    private final UserDAO<User> userDAO = new UserDAOImpl();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String locale = req.getParameter("sessionLocale");
        User user = (User) req.getSession().getAttribute("user");
        if (locale != null) {
            req.getSession().setAttribute("language", locale);

            if (user.getLocalId() == RUS_LOCALE) {
                user.setLocalId(ENG_LOCALE);
            } else {
                user.setLocalId(RUS_LOCALE);
            }
            req.getSession().setAttribute("user", user);

            try {
                userDAO.update(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            String sessionLocale = (String) req.getSession().getAttribute("language");
            if (sessionLocale == null) {
                req.getSession().setAttribute("language", "ru");
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
