<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 30.10.2017
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GroupForm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Group form"
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
<form action="#" method="post">
    <input type="hidden" name="oldGroupNumber" value="${group.groupNumber}"><br>
    <table>
        <tr><td>Group number:</td><td><input type="text" name="groupNumber" value="${group.groupNumber}"></td></tr>
        <tr><td>AVG mark:</td><td><input type="text" name="avgMark" value="${group.avgMark}"></td></tr>
    </table>
    <input type="submit" value="SAVE"><br>
</form>
<form action="#">
    <input type="hidden" name="oldGroupNumber" value="${group.groupNumber}"><br>
    <input type="submit" value="DELETE"><br>
</form>
</div>
</body>
</html>
