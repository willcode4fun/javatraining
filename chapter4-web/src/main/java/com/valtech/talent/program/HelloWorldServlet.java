package com.valtech.talent.program;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws IOException, ServletException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h1>Hello World using HttpServlet class.</h1>");
        out.close();

        this.getServletContext().getRequestDispatcher("jsp/hello.jsp").forward(request,response);
    }
}