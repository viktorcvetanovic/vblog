package com.viktor.vblog.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter("/*")
public class Security implements Filter {

    private static final List<String> allowedPages = Arrays.asList(
            "/login.jsp",
            "/register.jsp",
            "/logout.jsp",
            "/error",
            "/css/*",
            "/js/*",
            "/img/*",
            "/fonts/*",
            "/favicon.ico",
            "/index.jsp",
            "/login-servlet",
            "/register-servlet"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String username = (String) req.getSession().getAttribute("user");
        String requestURI = req.getRequestURI();
        if (username == null && !allowedPages.contains(requestURI)) {
            response.getWriter().write("<script>alert('You are not logged in');window.location.href='/login.jsp'</script>");
        } else {
            chain.doFilter(request, response);
        }
    }
}
