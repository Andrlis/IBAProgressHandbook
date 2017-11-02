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
</head>
<body>
	<form action="UserSave" method="post">
		<input type="hidden" name="oldUser" value="${user.user}"><br>
		User: <input type="text" name="user" value="${user.user}"><br>
		Password: <input type="password" name="password" value="${user.password}"><br>
		Role: <input name="role" value="${user.role}"><br>
		<input type="submit" value="SAVE"><br>
	</form>
	<form action="#">
		<input type="hidden" name="oldUser" value="$user.user}"><br>
		<input type="submit" value="DELETE"><br>
	</form>

</body>
</html>