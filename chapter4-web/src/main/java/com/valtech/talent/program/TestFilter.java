package com.valtech.talent.program;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter implements Filter {
       
	public void init(FilterConfig filterConfig) {
		
	}  
    
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain) throws IOException, ServletException {


		System.out.println("filter was here !");
		chain.doFilter(request, response);
	}  
	
    public void destroy() {
    	
    }  
}

