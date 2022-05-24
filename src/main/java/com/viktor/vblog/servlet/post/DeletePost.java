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

@WebServlet(name = "deletePost", value = "/post/delete")
public class DeletePost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostDAO postDAO = new PostDAO();
        UserDAO userDAO = new UserDAO();
        Post post= postDAO.find(Long.parseLong(req.getParameter("post_id")));
        if(post.getIdUser().getId().equals(userDAO.findByUsername((String) req.getSession().getAttribute("user")).getId())){
            postDAO.remove(post);
        }
        resp.setStatus(302);
        resp.sendRedirect("/index.jsp");
    }

}
