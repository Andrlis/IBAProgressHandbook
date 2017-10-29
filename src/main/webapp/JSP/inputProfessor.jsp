<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 24.10.2017
  Time: 7:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Input Professor</title>
</head>
<body>
<h2>Input Professor</h2>
<form action="/addProfessor" method="POST">
    <div>
        <input name="firstName" type="text" placeholder="First name" autofocus required>
        <input name="secondName" type="text" placeholder="Second name" autofocus required>
        <input name="secondName" type="text" placeholder="Father name" autofocus required>
        <input name="avgMark" type="text" placeholder="Average mark" autofocus required>
        <input name="birthDate" type="text" placeholder="Birth date (dd.mm.yyyy)" autofocus required>
    </div>
</form>
<button>Add</button>
</body>
</html>
