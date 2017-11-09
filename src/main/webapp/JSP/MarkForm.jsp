<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09.11.2017
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MarkForm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Mark form"
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
    <form action="MarkSave" method="post">
        <input type="hidden" name="oldId" value="${mark.id}"><br>
        <table>
            <tr><td>Study ID:</td><td><input type="text" name="studyId" value="${mark.studyId}"></td></tr>
            <tr><td>Student ID:</td><td><input type="text" name="studentId" value="${mark.studentId}"></td></tr>
            <tr><td>Date:</td><td><input type="text" name="date" value="${mark.date}"></td></tr>
            <tr><td>Professor ID:</td><td><input type="text" name="professorId" value="${mark.professorId}"></td></tr>
            <tr><td>Mark:</td><td><input type="text" name="markValue" value="${mark.mark}"></td></tr>
            <tr><td>Comments:</td><td><input type="text" name="comments" value="${mark.comments}"></td></tr>
        </table>
        <input type="submit" value="SAVE"><br>
    </form>
    <form action="MarkDelete" method="get">
        <input type="hidden" name="oldId" value="${mark.id}"><br>
        <input type="submit" value="DELETE"><br>
    </form>
    <div style="align-content: center; padding-top: 20px;">
        <a href="MarkList">Back</a>
    </div>
</div>
</body>
</html>
