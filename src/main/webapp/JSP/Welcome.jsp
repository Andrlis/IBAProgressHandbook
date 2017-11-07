<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
        language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Welcome</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta name="GENERATOR"
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
        }
        .topnav {
            width: 100%;
            background-color: #4682B4;
            overflow: hidden;
            border: 1px solid;
            border-radius: 3px;
        }
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }
        .topnav a {
            float: left;
            display: flex;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }
        .linkTable{
            padding: 15px;
        }
        .linkTable a {
            display: flex;
            color: #4682B4;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
    </style>
</head>
<body>
<div class="mainForm">
    <div class="topnav" id="myTopnav">
        <a href="#">LogIn</a>
        <a href="#">Send to admin</a>
        <a href="#">Read for admin</a>
    </div>
    <table class="linkTable">
        <tr><td><a href="UserList">Users</a></td><td><a href="StudentList">Students</a></td></tr>
        <tr><td><a href="#">Studies</a></td><td><a href="#">Marks</a></td></tr>
        <tr><td><a href="#">Groups</a></td><td><a href="#">Professors</a></td></tr>
    </table>
</div>
</body>
</html>