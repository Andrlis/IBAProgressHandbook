<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>                                   <%--It`s important on my computer.--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>List</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="GENERATOR"
	content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<h1>UserList</h1>
	<table>
		<tr>
			<th>User</th><th>Password</th><th>Role</th>
		</tr>
		<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.user}</td><td>${user.password}</td><td>${user.role}</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>