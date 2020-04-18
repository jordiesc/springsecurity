package org.jordi.springsecurity.spring;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class CustomSampleFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationManager authenticationManager;

    //@Override
    public void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);
        // UsernamePasswordAuthenticationToken authReq = new
        // UsernamePasswordAuthenticationToken("jordi", "jordi");
        if (SecurityContextHolder.getContext().getAuthentication() == null
                || !SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {

            UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken("jordi", "jordi");
            Authentication auth = authenticationManager.authenticate(authReq);
            SecurityContextHolder.getContext().setAuthentication(auth);

        }
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿??????????????????????????????????");
        chain.doFilter(request, response);

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        // SecurityContextHolder.getContext().getAuthentication().setAuthenticated(true);
        // UsernamePasswordAuthenticationToken authReq = new
        // UsernamePasswordAuthenticationToken("jordi", "jordi");
        if (SecurityContextHolder.getContext().getAuthentication() == null
                || !SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {

            UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken("jordi", "jordi");
            Authentication auth = authenticationManager.authenticate(authReq);
            SecurityContextHolder.getContext().setAuthentication(auth);

        }
        System.out.println("¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿¿??????????????????????????????????");
        filterChain.doFilter(request, response);
    }


}