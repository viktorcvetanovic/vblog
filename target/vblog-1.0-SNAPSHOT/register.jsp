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
<form action="register-servlet" method="post">
<section class="section">
    <div class="columns">
        <div class="column is-4 is-offset-4">

            <div class="field">
                <label class="label">Username</label>
                <div class="control has-icons-left has-icons-right">
                    <input class="input is-success" type="text" placeholder="Text input"  name="username">
                    <span class="icon is-small is-left">
                     <i class="fa fa-user"></i>
                     </span>
                    <span class="icon is-small is-right">
                     <i class="fa fa-check"></i>
                     </span>
                </div>
                <p class="help is-success">This username is available</p>
            </div>
            <div class="field">
                <label class="label">Password</label>
                <div class="control">
                    <input class="input" type="password" placeholder="Password input" name="password">
                </div>
            </div>
            <div class="field">
                <label class="label">Email</label>
                <div class="control has-icons-left has-icons-right">
                    <input class="input is-danger" type="email" placeholder="Email input" value="name@" name="email">
                    <span class="icon is-small is-left">
                     <i class="fa fa-envelope"></i>
                     </span>
                    <span class="icon is-small is-right">
                     <i class="fa fa-warning"></i>
                     </span>
                </div>
                <p class="help is-danger">This email is invalid</p>
            </div>
            <div class="field">
                <label class="label">Display name</label>
                <div class="control">
                    <input class="input" type="text" placeholder="Display name" name="displayName">
                </div>
            </div>
            <div class="field">
                <div class="control">
                    <label class="checkbox">
                        <input type="checkbox">
                        Slazem se sa <a href="#">uslovima koriscenja</a>
                    </label>
                </div>
            </div>
            <div class="field is-grouped">
                <div class="control">
                    <button class="button is-primary" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</section>
</form>
</body>
</html>