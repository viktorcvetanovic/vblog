<%@ page import="com.viktor.vblog.database.entity.Post" %>
<%@ page import="com.viktor.vblog.database.dao.PostDAO" %>
<%@ page import="com.viktor.vblog.database.entity.User" %>
<%@ page import="com.viktor.vblog.database.dao.CommentDAO" %>
<%@ page import="com.viktor.vblog.database.entity.Comment" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    System.out.println("IDE GAS");
    System.out.println(request.getParameter("post_id"));
    if (request.getParameter("post_id") == null || request.getParameter("post_id").equals("")) {
        return;
    }
    Long post_id = Long.valueOf(request.getParameter("post_id"));
    CommentDAO commentDAO=new CommentDAO();
    List<Comment> comments=commentDAO.findAll()
            .stream()
            .filter(e-> e.getIdPost().equals(post_id))
            .collect(Collectors.toList());
    request.setAttribute("comments", comments);
    Post post = new PostDAO().find(post_id);
    User user = post.getIdUser();
    request.setAttribute("post", post);
    request.setAttribute("user", user);
    request.setAttribute("logged_user", request.getSession().getAttribute("user"));


%>
<article class="media">
    <figure class="media-left">
        <p class="image is-64x64">
            <img src="https://bulma.io/images/placeholders/128x128.png">
        </p>
    </figure>
    <div class="media-content">
        <div class="content">
            <p>
                <strong>${user.displayName}</strong> <small>${user.email}</small> <small>${post.datePosted}</small>
                <br>
                ${post.title}
                <br>
                ${post.body}
            </p>
        </div>
        <nav class="level is-mobile">
            <div class="level-left">
                <a class="level-item">
                    <span class="icon is-small"><i class="fas fa-reply"></i></span>
                </a>
                <a class="level-item">
                    <span class="icon is-small"><i class="fas fa-retweet"></i></span>
                </a>
                <a class="level-item">
                    <span class="icon is-small"><i class="fas fa-heart"></i></span>
                </a>
            </div>
        </nav>
    </div>
    <%
        if (request.getSession().getAttribute("user") != null) {
            if (request.getSession().getAttribute("user").equals(user.getUsername())) {
    %>
    <div class="media-right" >
        <form action="post/delete" method="post">
            <input type="hidden" name="post_id" value="${post.idPost}">
            <button class="delete" type="submit"></button>
        </form>
    </div>
    <%
            }
        }
    %>
</article>

<hr color="red">
<c:forEach items="${comments}" var="comment">
    <jsp:include page="comment.jsp">
        <jsp:param name="comment_id" value="${comment.idComment}"/>
    </jsp:include>
</c:forEach>



<form action="comment" method="post">
    <article class="media" style="margin-bottom: 3rem;margin-left: 5rem">
    <div class="media-content">
        <div class="field">
            <p class="control">
                <textarea class="textarea" placeholder="Add a comment..." cols="4"  name="comment" style="max-width: 500px !important; min-width: 500px !important;"></textarea>
            </p>
        </div>
        <input hidden name="post_id" value="${post.idPost}">
        <div class="field">
            <p class="control">
                <button class="button" type="submit">Post comment</button>
            </p>
        </div>
    </div>

</article>
</form>
