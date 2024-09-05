package me.phatlee.demoo.controllers;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/home")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "HelloServlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String ten = request.getParameter("ten");
        String ho = request.getParameter("ho");
        PrintWriter printW = response.getWriter();
        printW.println(ho + " " + ten);
        printW.close();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Set response content type
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        //Nhận dữ liệu từ request URL
        String ten = request.getParameter("ten");
        String ho = request.getParameter("ho");

        request.setAttribute("fname", ten);
        request.setAttribute("lname", ho);

        //Hiển thị dữ liệu ra web bằng đối tượng PrintWriter
        PrintWriter out = response.getWriter();
        out.println("<b>First Name</b>: " + ten + "<br/><b>Last Name</b>: " + ho);

        RequestDispatcher rd = request.getRequestDispatcher("/views/test.jsp");
        rd.forward(request, response);
    }

    public void destroy() {
    }
}