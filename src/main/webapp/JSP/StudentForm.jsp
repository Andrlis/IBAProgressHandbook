<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 30.10.2017
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudentForm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Student form"
          content="Rational® Application Developer for WebSphere® Software">
</head>
<body>
<form action="#" method="post">
    <input type="hidden" name="oldId" value="${student.id}"><br>
    First name: <input type="text" name="firstName" value="${student.firstName}"><br>
    Second name: <input type="text" name="secondName" value="${student.secondName}"><br>
    AVG mark: <input name="avgMark" value="${student.avgMark}"><br>
    Group number: <input name="groupNumber" value="${student.groupNumber}"><br>
    <input type="submit" value="SAVE"><br>
</form>
<form action="#">
    <input type="hidden" name="oldId" value="${student.id}"><br>
    <input type="submit" value="DELETE"><br>
</form>
</body>
</html>
