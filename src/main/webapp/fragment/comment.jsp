<%@ page import="com.viktor.vblog.database.dao.CommentDAO" %>
<%@ page import="com.viktor.vblog.database.entity.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %><%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 6/6/2022
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
if (request.getParameter("comment_id") == null || request.getParameter("comment_id").equals("")) {
        return;
    }
    Long comment_id = Long.valueOf(request.getParameter("comment_id"));
    CommentDAO commentDAO = new CommentDAO();
    Comment comment = commentDAO.find(comment_id);
    request.setAttribute("comment", comment);

%>



<article class="media"  style="margin-left: 5rem">

    <div class="media-content">
        <div class="content">
            <p>
                <strong>${comment.commenterName}</strong>
                <strong>${comment.commenterEmail}</strong>
                <strong>${comment.dateCommented}</strong></strong>
                <br>
                ${comment.body}
                <br>
                <small><a>Like</a> · <a>Reply</a> · 3 hrs</small>
            </p>
        </div>
    </div>
</article>