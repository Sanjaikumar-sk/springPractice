package com.practice.ecommerce.FilterPackage;

import com.practice.ecommerce.Service.JWTService;
import com.practice.ecommerce.Service.SecurityService;
import com.practice.ecommerce.Service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.antlr.v4.runtime.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        System.out.println(authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer"))
        {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        System.out.println(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null)
        {

            UserDetails userDetails = context.getBean(SecurityService.class).loadUserByUsername(username);

            System.out.println("userDetails: " + userDetails);

             if(jwtService.validateToken(token, userDetails)){
                 UsernamePasswordAuthenticationToken authToken =
                         new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                 SecurityContextHolder.getContext().setAuthentication(authToken);
             }
        }

        filterChain.doFilter(request, response);
    }
}
