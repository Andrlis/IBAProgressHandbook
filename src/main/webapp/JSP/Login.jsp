<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 08.11.2017
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>LogIN</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Login"
          content="Rational® Application Developer for WebSphere® Software">
    <style type="text/css">
        .mainForm{
            display: flex;
            position: center;
            flex-direction: column;
            align-items: center;
            text-align: center;
            border: 2px solid #006598;
            border-radius: 6px;
            background: #F5F5F5;
            width: 50%;
            margin: auto;
            padding: 20px;
        }
    </style>
</head>
<body>
<script type="text/javascript" src="JS/loginPageScr"></script>
<div class="mainForm">
    <h2>LogIn</h2>
    ${message}
    <form action="Authenticate" method="post">
        <table>
            <tr><td>Login:</td><td><input type="text" name="userId"></td></tr>
            <tr><td>Password:</td><td><input type="password" name="password" id="password"></td></tr>
        </table>
        <input type="submit" value="LogIn" onclick="return protectEmptyPassword()">
    </form>
</div>

</body>
</html>
