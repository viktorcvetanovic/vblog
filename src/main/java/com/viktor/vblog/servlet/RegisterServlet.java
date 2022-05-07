package com.viktor.vblog.servlet;

import com.viktor.vblog.database.dao.UserDAO;
import com.viktor.vblog.database.entity.User;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "registerServlet", value = "/register-servlet")
public class RegisterServlet extends HttpServlet {


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String displayName = request.getParameter("displayName");
        User user= new User();
        user.setActive(false);
        user.setEmail(email);
        user.setUsername(name);
        user.setPassword(password);
        user.setDisplayName(displayName);
        user.setRoles(new HashSet(Collections.singletonList("author")));
        UserDAO userDAO= new UserDAO();
        userDAO.create(user);
        response.sendRedirect("/login");
    }
    public void destroy() {
    }
}