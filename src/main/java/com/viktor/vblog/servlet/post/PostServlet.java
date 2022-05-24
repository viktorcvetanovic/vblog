package com.viktor.vblog.servlet.post;

import com.viktor.vblog.database.dao.PostDAO;
import com.viktor.vblog.database.dao.UserDAO;
import com.viktor.vblog.database.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "postServlet", value = "/post-servlet")
public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String excerpt = req.getParameter("excerpt");
        String body = req.getParameter("body");
        PostDAO postDAO = new PostDAO();
        UserDAO userDAO = new UserDAO();
        Post post = new Post();
        post.setTitle(title);
        post.setExcerpt(excerpt);
        post.setBody(body);
        post.setSlug("/create-post");
        post.setPublished(false);
        post.setDatePosted(LocalDate.now());

        post.setIdUser(userDAO.findByUsername((String) req.getSession().getAttribute("user")));
        postDAO.create(post);
        resp.setStatus(302);
        resp.sendRedirect("/index.jsp");
    }


}
