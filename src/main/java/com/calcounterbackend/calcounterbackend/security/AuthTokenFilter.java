package com.calcounterbackend.calcounterbackend.security;

import com.calcounterbackend.calcounterbackend.Util.JwtUtil;
import com.calcounterbackend.calcounterbackend.service.CustomUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil; 

    private final CustomUserDetailService customUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        try {
            // Metoden parseJwt används för att extrahera JWT-token från Authorization-headern i HTTP-förfrågan
            String jwt = parseJwt(request);

            // Om en token finns och är giltig (valideras med jwtUtil.validateToken), fortsätter processen.
            if (jwt != null && jwtUtil.validateToken(jwt)) {
                // Email extraheras från token med jwtUtil.getEmailFromToken.
                String email = jwtUtil.getEmailFromToken(jwt);

                // Användardetaljer hämtas från databasen
                UserDetails userDetails = customUserDetailService.loadUserByUsername(email);

                // En token skapas med användardetaljerna
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                        );
                // Token sätts i Spring Securitys SecurityContextHolder
                // Vilket gör att användaren anses vara autentiserad för resten av förfrågan.
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            System.out.println("Cannot set user authentication: " + e);
        }
        // Fortsätt med filterkedjan
        filterChain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request){
        String headerAuth = request.getHeader("Authorization");
        if (headerAuth != null && headerAuth.startsWith("Bearer")){
            return headerAuth.substring(7);
        }
        return null;
    }
    
}
