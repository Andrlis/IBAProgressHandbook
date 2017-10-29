<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 23.10.2017
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="edu.iba.sh.bean.Student" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
<h2>Students:</h2>
<% Student student = (Student)request.getAttribute("student"); %>

<p> Name: <%=student.getFirstName()%></p>
<p> Second name:  <%=student.getSecondName()%></p>
<p> AVG mark: <%=student.getAvgMark()%></p>
<p> Group:  <%=student.getGroupNumber()%></p>
</body>
</html>
