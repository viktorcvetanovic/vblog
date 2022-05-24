<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
</head>
<body>
<jsp:include page="include/nav.jsp"/>
<section class="hero">
    <div class="hero-body">
        <p class="title">
            vBlog is a simple blog application written in Java EE.
        </p>
        <p class="subtitle">
            Everything you need to start your own blog.
        </p>
    </div>
</section>
<jsp:include page="fragment/post.jsp"/>
<jsp:include page="include/footer.jsp"/>
</body>
</html>