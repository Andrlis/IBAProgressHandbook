<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 30.10.2017
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GroupList</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Group list"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<table>
    <tr>
        <th>Group name</th><th>AVG mark</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.groupNumber}</td><td>${group.avgMark}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
