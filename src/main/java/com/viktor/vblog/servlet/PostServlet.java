package com.viktor.vblog.servlet;

import com.viktor.vblog.database.dao.PostDAO;
import com.viktor.vblog.database.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "postServlet", value = "/post-servlet")
public class PostServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String excerpt = req.getParameter("excerpt");
        String body = req.getParameter("body");
        PostDAO postDAO = new PostDAO();
        Post post = new Post();
        post.setTitle(title);
        post.setExcerpt(excerpt);
        post.setBody(body);
        post.setSlug("/create-post");
        post.setPublished(false);
        post.setDatePosted(LocalDate.now());
        postDAO.create(post);
        resp.setStatus(302);
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDAO postDAO = new PostDAO();
        List<Post> postList = postDAO.findAll();
        if(req.getParameter("id") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            Post post = postDAO.find(id);
            postList= Collections.singletonList(post);
        }

        req.setAttribute("postList", postList);
    }
}
