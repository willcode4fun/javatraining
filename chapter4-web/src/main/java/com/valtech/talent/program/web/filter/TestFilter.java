package com.valtech.talent.program.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {


    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("filter do something before");
        chain.doFilter(request, response);
        System.out.println("filter do something after");
    }

}

