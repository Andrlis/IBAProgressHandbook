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
    <h1>GroupList</h1>
<table border="1" align="center" width="70%" bordercolor="#006598" cellspacing="0" cellpadding="2">
    <tr>
        <th>Group name</th><th>AVG mark</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.groupNumber}</td><td>${group.avgMark}</td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>
