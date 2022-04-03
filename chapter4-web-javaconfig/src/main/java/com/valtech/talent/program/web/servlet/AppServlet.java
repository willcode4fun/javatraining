package com.valtech.talent.program.web.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@WebServlet("/javaconfig")
public class AppServlet extends HttpServlet {

    private static final String ATTRIBUTE_STORED_IN_SESSION = "ATTRIBUTE_STORED_IN_SESSION";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String msg = handleSession(request);

        log.info("send servlet response"+ msg);
        response.getWriter().println("Hello World !" + msg);
    }

    private String handleSession(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String attribute = Optional.ofNullable((String) session.getAttribute(ATTRIBUTE_STORED_IN_SESSION))
                .map(attr -> attr+"A").orElse("B");

        session.setAttribute(ATTRIBUTE_STORED_IN_SESSION, attribute);
        return attribute;
    }
}