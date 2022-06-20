package com.bookout.filters;

import com.bookout.database.dao.UserDAO;
import com.bookout.database.daointerfaces.UserDAOInterface;
import com.bookout.enitiy.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public class LanguageFilter implements Filter {

    private final UserDAOInterface<User> userDAO = new UserDAO();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String locale = req.getParameter("sessionLocale");
        User user = (User) req.getSession().getAttribute("user");
        if(locale != null) {
            req.getSession().setAttribute("language", locale);
            if(user != null) {
                if(user.getLocalId() == 1) {
                    user.setLocalId(2);
                } else {
                    user.setLocalId(1);
                }
                req.getSession().setAttribute("user", user);
                try {
                    userDAO.update(user);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            String sessionLocale = (String) req.getSession().getAttribute("language");
            if(sessionLocale == null) {
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
