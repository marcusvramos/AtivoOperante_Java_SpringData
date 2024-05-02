package org.example.ativooperante.security;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        String bearerHeader = req.getHeader("Authorization");
        String token = null;

        if (bearerHeader != null && bearerHeader.startsWith("Bearer ")) {
            token = bearerHeader.substring(7);
        }

        if (token != null && JWTTokenProvider.verifyToken(token)) {
            chain.doFilter(request, response);
        } else {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getOutputStream().write("Não autorizado".getBytes());
        }
    }
}


    
