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
    <h1>StudentList</h1>
<table border="1" align="center" width="70%" bordercolor="#006598" cellspacing="0" cellpadding="2">
    <tr>
        <th>First name</th><th>Second name</th><th>AVG mark</th><th>Group number</th>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.firstName}</td><td>${student.secondName}</td><td>${student.avgMark}</td><td>${student.groupNumber}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
