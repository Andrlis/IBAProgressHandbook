<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>                                   <%--It`s important on my computer.--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Users Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="User form"
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
            width: 30%;
            margin: auto;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="mainForm">
	<form action="UserSave" method="post">
        <input type="hidden" name="oldUser" value="${user.user}"><br>
        <table>
            <tr><td>User:</td><td><input type="text" name="user" value="${user.user}"></td></tr>
            <tr><td>Password:</td><td><input type="password" name="password" value="${user.password}"></td></tr>
            <tr><td>Role:</td><td><input name="role" value="${user.role}"></td></tr>
        </table>
        <input type="submit" value="SAVE"><br>
	</form>
	<form action="#">
		<input type="hidden" name="oldUser" value="$user.user}"><br>
		<input type="submit" value="DELETE"><br>
	</form>
</div>
</body>
</html>