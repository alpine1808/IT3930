package com.apartment.IT3930.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        String url = "/login?error";

        for (GrantedAuthority authority : authorities) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                url = "/admin/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_STAFF")) {
                url = "/staff/dashboard";
                break;
            } else if (authority.getAuthority().equals("ROLE_STANDARD")) {
                url = "/user/home";
                break;
            }
        }

        if (url.equals("/login?error")) {
            throw new IllegalStateException();
        }

        response.sendRedirect(url);
    }
}
