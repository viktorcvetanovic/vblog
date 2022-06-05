<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 5/7/2022
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item" href="https://bulma.io">
            <img src="https://www.nicepng.com/png/full/232-2326770_icon-blogger-logo-now-creative-group-logo.png">
        </a>

        <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
            <span aria-hidden="true"></span>
        </a>
    </div>

    <div id="navbarBasicExample" class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item" href="../index.jsp">
                Home
            </a>
            <a class="navbar-item" href="../create_post.jsp">
                Add post
            </a>

        </div>
    </div>

    <div class="navbar-end">
        <%
            //HERE WE GETTING THE ATTRIBUTE DECLARED IN VALIDATE.JSP AND CHECKING IF IT IS NULL, THE USER WILL BE REDIRECTED TO LOGIN PAGE
            String uid = (String) session.getAttribute("user");
            if (uid == null) {


        %>
        <div class="navbar-item">
            <div class="buttons">
                <a class="button is-primary" href="${pageContext.request.contextPath}/register.jsp">
                    <strong>Sign up</strong>
                </a>
                <a class="button is-light" href="${pageContext.request.contextPath}/login.jsp">
                    Log in
                </a>
            </div>
        </div>
    </div>
    <%
        }
            else {
    %>
    <div class="navbar-item">
        <div>
            <form method="post" action="logout">
                <button class="button is-primary" type="submit">
                    Logout
                </button>
            </form>
        </div>
    </div>
    <%
        }
    %>

</nav>