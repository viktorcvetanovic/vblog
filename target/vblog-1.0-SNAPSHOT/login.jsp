<%--
  Created by IntelliJ IDEA.
  User: vikto
  Date: 5/7/2022
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bulma Tutorial</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.6.0/css/bulma.min.css">
</head>
<body>
<jsp:include page="include/nav.jsp"/>
<form action="login-servlet" method="post">
    <section class="section">
        <div class="columns">
            <div class="column is-4 is-offset-4">
                <form action="" class="box">
                    <div class="field">
                        <label class="label">Username</label>
                        <div class="control has-icons-left">
                            <input type="text" class="input" required name="username">
                            <span class="icon is-small is-left">
                  <i class="fa fa-envelope"></i>
                </span>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Password</label>
                        <div class="control has-icons-left">
                            <input type="password" placeholder="*******" class="input" required name="password">
                            <span class="icon is-small is-left">
                  <i class="fa fa-lock"></i>
                </span>
                        </div>
                    </div>
                    <div class="field">
                        <button class="button is-success" type="submit">
                            Login
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </section>
</form>
<jsp:include page="include/footer.jsp"/>
</body>
</html>
