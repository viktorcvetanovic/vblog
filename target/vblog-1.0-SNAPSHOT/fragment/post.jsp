<%@ page import="com.viktor.vblog.database.entity.Post" %>
<%@ page import="com.viktor.vblog.database.dao.PostDAO" %>
<%@ page import="com.viktor.vblog.database.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("IDE GAS");
    System.out.println(request.getParameter("post_id"));
    if(request.getParameter("post_id") == null || request.getParameter("post_id").equals("")){
        return;
    }
    Integer post_id = Integer.valueOf(request.getParameter("post_id"));
    Post post = new PostDAO().find(post_id);
    User user = post.getIdUser();
    request.setAttribute("post", post);
    request.setAttribute("user", user);
    request.setAttribute("post", post);
    request.setAttribute("user", user);


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
                <strong>${user.displayName}</strong> <small>${user.email}</small> <small>31m</small>
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
    <div class="media-right">
        <button class="delete"></button>
    </div>
</article>