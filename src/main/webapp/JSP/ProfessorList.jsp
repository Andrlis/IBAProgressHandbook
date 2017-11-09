<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 08.11.2017
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>ProfessorList</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Professor list"
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
    <h1>ProfessorList</h1>
    <table border="1" align="center" width="70%" bordercolor="#006598" cellspacing="0" cellpadding="2">
        <tr>
            <th>ID</th><th>First name</th><th>Father name</th><th>Second name</th><th>Date of birth</th><th>AVG mark</th>
        </tr>
        <c:forEach items="${professors}" var="professor">
            <tr>
                <td><a href="ProfessorForm?id=${professor.id}">${professor.id}</a></td><td>${professor.firstName}</td><td>${professor.fatherName}</td><td>${professor.secondName}</td>
                <td>${professor.birthDate}</td><td>${professor.avgMark}</td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6"><form action="/ProfessorForm"><input type="submit" value="Add"></form></td>
        </tr>
    </table>
    <div style="align-content: center; padding-top: 20px;">
        <a href="Welcome">Back</a>
    </div>
</div>
</body>
</html>
