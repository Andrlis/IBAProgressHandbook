<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 09.11.2017
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProfessorForm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="Professor form"
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
    <form action="ProfessorSave" method="post">
        <input type="hidden" name="oldId" value="${professor.id}"><br>
        <table>
            <tr><td>First name:</td><td><input type="text" name="firstName" value="${professor.firstName}"></td></tr>
            <tr><td>Father name:</td><td><input type="text" name="fatherName" value="${professor.fatherName}"></td></tr>
            <tr><td>Second name:</td><td><input type="text" name="secondName" value="${professor.secondName}"></td></tr>
            <tr><td>Date of birth:</td><td><input type="text" name="birthDate" value="${professor.birthDate}"></td></tr>
            <tr><td>AVG mark:</td><td><input type="text" name="avgMark" value="${professor.avgMark}"></td></tr>
        </table>
        <input type="submit" value="SAVE"><br>
    </form>
    <form action="ProfessorDelete" method="get">
        <input type="hidden" name="oldId" value="${professor.id}"><br>
        <input type="submit" value="DELETE"><br>
    </form>
    <div style="align-content: center; padding-top: 20px;">
        <a href="ProfessorList">Back</a>
    </div>
</div>
</body>
</html>

