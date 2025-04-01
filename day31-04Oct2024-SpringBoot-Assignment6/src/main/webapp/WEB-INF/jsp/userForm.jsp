<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>User Form</title>
</head>
<body>
<h1>
    User Form:
</h1>

<div align = center>
    <f:form action="saveUser" modelAttribute="user" method="POST">
        <table>
            <tr>
                <td>User Id: </td>
                <td><f:input path="userId" value="${user.getUserId()}"/></td>
            </tr>

            <tr>
                <td>Username: </td>
                <td><f:input path="username" value="${user.getUsername()}"/></td>
            </tr>

            <tr>
                <td>Password: </td>
                <td><f:input path="password" value="${user.getPassword()}"/></td>
            </tr>

            <tr>
                <td>Email: </td>
                <td><f:input path="email" value="${user.getEmail()}"/></td>
            </tr>

            <tr>
                <td>Roles: </td>
                <td>
                    <c:forEach items="${roles}" var="role">
                        <c:choose>
                            <c:when test="${retrievedRoles.contains(role)}">
                                <f:checkbox path="roles" label="${role.roleName}" value="${role.roleId}" checked="true"/>
                            </c:when>
                            <c:otherwise>
                                <f:checkbox path="roles" label="${role.roleName}" value="${role.roleId}"/>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Submit Button"/></td>
            </tr>
        </table>
    </f:form>




    <h1> Users: </h1>
    <table border="1">
        <tr><th>User ID</th><th>Username</th><th>Password</th><th>Email</th><th>Roles</th><th>Actions</th></tr>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.getUserId()}</td>
                <td>${u.getUsername()}</td>
                <td>${u.getPassword()}</td>
                <td>${u.getEmail()}</td>

                <td>
                    <c:forEach items="${u.getRoles()}" var="role">
                        ${role.getRoleName()}
                    </c:forEach>
                </td>

                <td>
                    <a href="${pageRequest.getContextPath()}/updateUser/userId=${u.getUserId()}">update</a>
                    <a href="${pageRequest.getContextPath()}/deleteUser/userId=${u.getUserId()}">delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>