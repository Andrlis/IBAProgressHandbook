<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.10.2017
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Student</title>
</head>
<body>
<h2>Input Student:</h2>
<form action="/addStudent" method="POST">
    <div>
        <input name="firstName" type="text" placeholder="First name" autofocus required>
        <input name="secondName" type="text" placeholder="Second name" autofocus required>
        <input name="avgMark" type="text" placeholder="Average mark" autofocus required>
        <input name="groupNumber" type="text" placeholder="Group number" autofocus required>
    </div>
    <button>Add</button>
</form>
</body>
</html>
