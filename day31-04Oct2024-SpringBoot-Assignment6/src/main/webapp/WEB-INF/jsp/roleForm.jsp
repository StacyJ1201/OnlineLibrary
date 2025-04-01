<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Role Form</title>
</head>
<body>
<h1>
    Role Form
</h1>
<div align = center>
    <f:form action="saveRole" modelAttribute="role" method="POST">
        <table>
            <tr>
                <td>Role Id: </td>
                <td><f:input path="roleId" value="${role.getRoleId()}"/></td>
            </tr>

            <tr>
                <td>Role Name: </td>
                <td><f:input path="roleName" value="${role.getRoleName()}"/></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="Submit Button"/></td>
            </tr>
        </table>
    </f:form>




    <table>
        <tr><th>Role Id</th> <th>Role Name</th></tr>

            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.getRoleId()}</td>
                    <td>${role.getRoleName()}</td>

                    <td>
                        <a href="${pageContext.request.contextPath}/updateRole/roleId=${role.getRoleId()}">update</a>
                        <a href="${pageContext.request.contextPath}/deleteRole/roleId=${role.getRoleId()}">delete</a>
                    </td>
                </tr>
            </c:forEach>
    </table>
</div>

</body>
</html>
