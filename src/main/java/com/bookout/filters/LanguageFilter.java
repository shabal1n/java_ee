package com.bookout.filters;

import com.bookout.enitiy.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LanguageFilter implements Filter {
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
                //here i update user in db
            }
        }
        if(user != null) {
            req.getSession().setAttribute("language", user.getLocalName());
        } else {
            if (locale != null) {
                req.getSession().setAttribute("language", locale);
            } else {
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
