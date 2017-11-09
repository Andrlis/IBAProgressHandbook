<%--
  Created by IntelliJ IDEA.
  User: Andrey
  Date: 09.11.2017
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false"%><html>
<head>
    <title>StudyList</title>
    <meta name="Study list"
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
    <h1>StudyList</h1>
    <table border="1" align="center" width="70%" bordercolor="#006598" cellspacing="0" cellpadding="2">
        <tr>
            <th>ID</th><th>Study name</th><th>Hours</th><th>Professor ID</th><th>AVG mark</th>
        </tr>
        <c:forEach items="${studies}" var="study">
            <tr>
                <td>${study.id}</td><td>${study.name}</td><td>${study.hours}</td><td>${study.professorId}</td><td>${study.avgMark}</td>
            </tr>
        </c:forEach>
    </table>
    <div style="align-content: center; padding-top: 20px;">
        <a href="Welcome">Back</a>
    </div>
</div>
</body>
</html>
