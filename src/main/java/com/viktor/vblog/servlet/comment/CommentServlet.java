package com.viktor.vblog.servlet.comment;

import com.viktor.vblog.database.dao.CommentDAO;
import com.viktor.vblog.database.dao.UserDAO;
import com.viktor.vblog.database.entity.Comment;
import com.viktor.vblog.database.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "CommentServlet", urlPatterns = "/comment")
public class CommentServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        User user=userDAO.findByUsername((String) req.getSession().getAttribute("user"));
        String commentText=req.getParameter("comment");
        CommentDAO commentDAO=new CommentDAO();
        Comment comment=new Comment();
        comment.setCommenterName(user.getDisplayName());
        comment.setCommenterEmail(user.getEmail());
        comment.setIdPost(Long.parseLong(req.getParameter("post_id")));
        comment.setDateCommented(LocalDate.now());
        comment.setBody(commentText);
        commentDAO.create(comment);
        resp.setStatus(302);
        resp.sendRedirect("/index.jsp");
    }
}
