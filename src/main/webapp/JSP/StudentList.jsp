<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 30.10.2017
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>                                   <%--It`s important on my computer.--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentsList</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Student list"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<table>
    <tr>
        <th>First name</th><th>Second name</th><th>AVG mark</th><th>Group number</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.firstName}</td><td>${student.secondName}</td><td>${student.avgMark}</td><td>${student.groupNumber}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
