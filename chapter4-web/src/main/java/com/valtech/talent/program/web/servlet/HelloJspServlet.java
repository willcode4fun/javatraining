package com.valtech.talent.program.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

public class HelloJspServlet extends HttpServlet {

    private static final String HEADER_NAME = "HEADER_NAME";
    private static final String HEADER_VALUE = "HEADER_VALUE";
    private static final int ERROR_CODE = 508;
    private static final String CONTENT_TYPE = "text/html";
    private static final String REDIRECT_URL = "url";

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws IOException, ServletException {

        handleRequest(request);

        handleResponse(response);

        this.getServletContext().getRequestDispatcher("/jsp/hello.jsp").forward(request, response);
    }

    private void handleResponse(HttpServletResponse response) throws IOException {
        response.sendError(ERROR_CODE);
        response.setContentType(CONTENT_TYPE);
        response.sendRedirect(REDIRECT_URL);

        Cookie cookie = new Cookie("name" , "value");
        response.addCookie(cookie);
        response.addHeader(HEADER_NAME, HEADER_VALUE);
        ServletOutputStream outputStream = response.getOutputStream();
    }

    private void handleRequest(HttpServletRequest request) throws IOException {
        String parameter = request.getParameter("PARAM_NAME");

        Object attribute = request.getAttribute("ATTR_NAME");

        String header = request.getHeader("HEADER_NAME");

        Cookie[] cookies = request.getCookies();

        ServletInputStream inputStream = request.getInputStream();

        HttpSession session = request.getSession();

        Object attr = session.getAttribute("ATTR_NAME");
        session.setAttribute("ATTR_NAME", "ATTR_VALUE");
        Enumeration<String> attributeNames = session.getAttributeNames();
    }
}
