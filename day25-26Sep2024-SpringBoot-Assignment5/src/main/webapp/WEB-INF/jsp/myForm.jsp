<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<div align="center">

<h1> User Form </h1>
<f:form action="saveUser" modelAttribute="user" method="POST">

    <tr>
        <td> User ID: </td>
        <td>
            <f:input path="userId" value="${user.getUserId()}"/>
        </td>
    </tr>

    <tr>
        <td> Username: </td>
        <td>
            <f:input path="username" value="${user.getUsername()}"/>
        </td>
    </tr>

    <tr>
        <td> Password: </td>
        <td>
            <f:input path="password" value="${user.getPassword()}"/>
        </td>
    </tr>

    <tr>
        <td> Email: </td>
        <td>
            <f:input path="email" value="${user.getEmail()}"/>
        </td>
    </tr>

    <tr>
        <td colspan="2" align="center"><input type="submit" value="Submit"> </td>
    </tr>

</div>

</f:form>

</body>
</html>