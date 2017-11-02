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
</head>
<body>
<form action="#" method="post">
    <input type="hidden" name="oldGroupNumber" value="${group.groupNumber}"><br>
    Group number: <input type="text" name="groupNumber" value="${group.groupNumber}"><br>
    AVG mark: <input type="text" name="avgMark" value="${group.avgMark}"><br>
    <input type="submit" value="SAVE"><br>
</form>
<form action="#">
    <input type="hidden" name="oldGroupNumber" value="${group.groupNumber}"><br>
    <input type="submit" value="DELETE"><br>
</form>
</body>
</html>
