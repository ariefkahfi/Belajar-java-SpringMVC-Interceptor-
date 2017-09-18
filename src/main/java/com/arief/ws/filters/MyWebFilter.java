package com.arief.ws.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Deprecated
public class MyWebFilter implements Filter {


    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;


        HttpSession sesi = req.getSession();


        //servletContext.log((String) sesi.getAttribute("admin"));

        String admin = (String) sesi.getAttribute("admin");

        if(admin==null){
            HttpServletResponse response  = (HttpServletResponse)servletResponse;
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }else{
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
