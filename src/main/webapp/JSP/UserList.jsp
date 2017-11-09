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
<div class="mainForm">
<h1>UserList</h1>
	<table border="1" align="center" width="70%" bordercolor="#006598" cellspacing="0" cellpadding="2">
		<tr>
			<th>User</th><th>Password</th><th>Role</th>
		</tr>
		<c:forEach items="${users}" var="user">
		<tr>
            <td><a href="UserForm?id=${user.user}">${user.user}</a></td><td>${user.password}</td><td>${user.role}</td>
		</tr>
		</c:forEach>
	</table>
    <div style="align-content: center; padding-top: 20px;">
        <a href="Welcome">Back</a>
    </div>
</div>
</body>
</html>