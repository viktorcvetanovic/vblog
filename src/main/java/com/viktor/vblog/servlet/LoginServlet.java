package com.viktor.vblog.servlet;

import com.viktor.vblog.database.dao.UserDAO;
import com.viktor.vblog.database.entity.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();
        User user = userDAO.findByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                request.getSession().setAttribute("user", user);
                response.setStatus(302);
                response.sendRedirect("/index.jsp");
                return;
            }
        }
        response.setStatus(401);
        response.sendRedirect("/login.jsp");
    }
}
