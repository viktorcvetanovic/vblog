package com.viktor.vblog.servlet.register;

import com.viktor.vblog.database.dao.RoleDAO;
import com.viktor.vblog.database.dao.UserDAO;
import com.viktor.vblog.database.entity.Role;
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
        RoleDAO roleDAO = new RoleDAO();
        Role role= roleDAO.findByName("author");
        UserDAO userDAO= new UserDAO();
        user.setRoles(new HashSet<>(Collections.singletonList(role)));
        userDAO.create(user);
        response.sendRedirect("/login.jsp");
    }

}