/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.filters;

import com.spring.models.User;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JuraLocal
 */
public class AdminFilter implements Filter {
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        User user = (User)req.getSession().getAttribute("user");
        if (user != null) {
            if (!user.isIsAdmin()) {
                res.sendRedirect("/SpringCMS/Home");
            }
        } 
        else {
            res.sendRedirect("/SpringCMS/Home");
        }

        try {
            chain.doFilter(request, response);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
    }
}