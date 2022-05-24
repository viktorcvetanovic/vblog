<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 5/9/2022
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add post</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css">
</head>
<body>
<jsp:include page="include/nav.jsp"/>
<form action="post-servlet" method="post">
    <section class="section">
        <div class="columns">
            <div class="column is-4 is-offset-4">
                <div class="field">
                    <label class="label">Title</label>
                    <div class="control has-icons-left">
                        <input type="text" class="input" required name="title">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Excerpt</label>
                    <div class="control has-icons-left">
                        <input type="text" class="input" required name="excerpt">
                    </div>
                </div>
                <div class="field">
                    <label class="label">Body</label>
                    <div class="control has-icons-left">
                        <textarea class="textarea" name="body"></textarea>
                    </div>
                </div>


                <div class="field">
                    <button class="button is-success" type="submit">
                        Add post
                    </button>
                </div>
            </div>
        </div>
    </section>
</form>

<jsp:include page="include/footer.jsp"/>
</body>
</html>
