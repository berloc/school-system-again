package com.codecool.service.jwt;


import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain filterChain)
//            throws IOException, ServletException {
//        Authentication authentication = com.codecool.service.jwt.TokenAuthenticationService
//                .getAuthentication((HttpServletRequest)request);
//
//        SecurityContextHolder.getContext()
//                .setAuthentication(authentication);
//        filterChain.doFilter(request,response);
//    }
}