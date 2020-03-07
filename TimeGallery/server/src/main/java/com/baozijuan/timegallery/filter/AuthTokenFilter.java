package com.baozijuan.timegallery.filter;

import com.baozijuan.timegallery.service.UserService;
import com.baozijuan.timegallery.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String jwt = parseJwt(request);
        if (jwt != null && jwtUtil.validateToken(jwt)) {
            String username = jwtUtil.getUsernameFromToken(jwt);
            UserDetails user = userService.loadUserByUsername(username);
            AbstractAuthenticationToken auth = new PreAuthenticatedAuthenticationToken(user, null, user.getAuthorities());
            auth.setDetails(new WebAuthenticationDetails(request));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        chain.doFilter(request, response);
    }

    private String parseJwt(HttpServletRequest request) {
        String bearer = "Bearer ";
        String header = request.getHeader("Authorization");
        if (StringUtils.hasText(header) && header.startsWith(bearer)) {
            return header.substring(bearer.length());
        }
        return null;
    }

}
