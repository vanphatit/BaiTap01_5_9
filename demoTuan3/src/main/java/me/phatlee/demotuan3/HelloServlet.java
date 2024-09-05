package me.phatlee.demotuan3;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import me.phatlee.demotuan3.configs.DBconnectMySQL;

@WebServlet(name = "helloServlet", value = "/home")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = DBconnectMySQL.checkConnection();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}