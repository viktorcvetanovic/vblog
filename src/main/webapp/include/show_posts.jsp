
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.viktor.vblog.database.entity.Post" %>
<%@ page import="com.viktor.vblog.database.dao.PostDAO" %>
<%@ page import="com.viktor.vblog.database.entity.Comment" %>
<%@ page import="com.viktor.vblog.database.entity.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<%
    List<Post> posts = new PostDAO().findAll();
    request.setAttribute("posts", posts);
%>

<c:forEach items="${posts}" var="post">
    <p style="background:red ">${post.title}</p>
</c:forEach>
