package me.phatlee.demotuan3.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // if not logged in, redirect to login page
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        // if logged in, show home page with username from cookie
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                request.setAttribute("username", cookie.getValue());
                break;
            }
        }

        request.getRequestDispatcher("/view/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("Hello World!");

    }
}