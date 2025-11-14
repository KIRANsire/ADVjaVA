package com.example.demo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.EnumSet;
import jakarta.servlet.DispatcherType;

/**
 * Simple logging and auth-demo filter.
 */
@WebFilter(filterName = "LoggingFilter", urlPatterns = {"/*"})
public class LoggingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // read init params if any
        System.out.println("LoggingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI();
        long start = System.currentTimeMillis();

        // Example logic: block requests to /blocked (uncomment to test)
        // if (path.startsWith(req.getContextPath() + "/blocked")) {
        //     response.setContentType("text/plain");
        //     response.getWriter().println("Access denied by filter");
        //     return;
        // }

        System.out.println("Request incoming: " + req.getMethod() + " " + path);

        // continue the chain
        chain.doFilter(request, response);

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Request processed in " + elapsed + " ms");
    }

    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}