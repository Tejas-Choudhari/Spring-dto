package com.example.demo.documentation;

import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ApiKeyFilter extends OncePerRequestFilter{
	
	private  final String API_KEY="q1w2e3r4t5y6u7i8o9p0"; 
	 	
	 @Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	            throws ServletException, IOException {
	       
	        String apiKey = request.getHeader("API");
	        
	        if (apiKey != null && apiKey.equals(API_KEY)) {
	            filterChain.doFilter(request, response);
	        } else {
	            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        }
	    }

}
