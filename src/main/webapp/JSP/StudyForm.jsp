<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09.11.2017
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>                                   <%--It`s important on my computer.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>StudyForm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Study form"
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
    <form action="StudySave" method="post">
        <input type="hidden" name="oldId" value="${study.id}"><br>
        <table>
            <tr><td>Study name:</td><td><input type="text" name="name" value="${study.name}"></td></tr>
            <tr><td>Hours:</td><td><input type="text" name="hours" value="${study.hours}"></td></tr>
            <tr><td>ProfessorID:</td><td><input type="text" name="professorId" value="${study.professorId}"></td></tr>
            <tr><td>AVG mark:</td><td><input type="text" name="avgMark" value="${study.avgMark}"></td></tr>
        </table>
        <input type="submit" value="SAVE"><br>
    </form>
    <form action="StudyDelete" method="get">
        <input type="hidden" name="oldId" value="${study.id}"><br>
        <input type="submit" value="DELETE"><br>
    </form>
    <div style="align-content: center; padding-top: 20px;">
        <a href="MarkList">Back</a>
    </div>
</div>
</body>
</html>

