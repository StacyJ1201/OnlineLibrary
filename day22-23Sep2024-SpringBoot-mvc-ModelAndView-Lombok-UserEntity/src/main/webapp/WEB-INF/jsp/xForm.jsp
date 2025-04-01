<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@  taglib uri="http://www.springframework.org/tags/form" prefix="f" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
<style type="text/css">
.myCss{
color:red;
font-family:courier;
font-size:150%
}
</style>
<!-- <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" > -->
</head>
<body>
<div align="center">
<h1>Employee Form</h1>
<f:form action="saveEmployee" method="POST"  modelAttribute="employee">
<table>
<%-- <tr>
<td>Errors:</td>
<td><f:errors path="*" cssClass="myCss" /></td>
</tr> --%>
<tr>
<td>EmpId: </td> <td><f:input name="empId" path="empId" value="${e.getEmpId()}" /></td>
<td><f:errors path="empId" cssClass="myCss"/></td>
</tr>

<tr>
<td>Name: </td> <td><f:input path="name" value="${e.getName()}" /></td>
<td><f:errors path="name" cssClass="myCss"/></td>
</tr>

<tr>
<td>Designation: </td> <td><f:input path="designation" value="${e.getDesignation()}" /></td>
<td><f:errors path="designation" cssClass="myCss"/></td>
</tr>

<tr>
<td>Salary: </td> <td><f:input path="salary" value="${e.getSalary()}" /></td>
<td><f:errors path="salary" cssClass="myCss"/></td>
</tr>

<tr>
<td>DOB: </td> <td><f:input type="date" path="dob" value="${e.getDob()}" /></td>
<td><f:errors path="dob" cssClass="myCss"/></td>
</tr>

<tr>
<td>Gender: </td> 
<td>
<c:forEach items="${genders}"  var="g">
<c:choose>
<c:when test="${rGender.equals(g)}">
	<f:radiobutton  path="gender" label="${g}"  value="${g}" checked="true"/>
</c:when>
<c:otherwise>
	<f:radiobutton  path="gender" label="${g}"  value="${g}" />
</c:otherwise>
</c:choose>
</c:forEach>
</td>
<td><f:errors path="gender" cssClass="myCss"/></td>
</tr>


<tr>
<td>Skills: </td> 
<td>
<c:forEach items="${skills}" var="sk">
<c:if test="${rSkills.contains(sk) }">
	<f:checkbox  path="skills"  value="${sk}" label="${sk}" checked="true"/>
</c:if>

<c:if test="${!rSkills.contains(sk) }">
	<f:checkbox  path="skills"  value="${sk}" label="${sk}"/>
</c:if>
</c:forEach>
</td>
<td><f:errors path="skills" cssClass="myCss"/></td>
</tr>

<tr>
<td>Spoken Languages: </td> 
<td>
<f:select  path="spokenLanguages"  >
	<c:forEach items="${spokenLanguages}" var="sl">
		<c:if test="${rSpokenLanguages.contains(sl)}">
			<f:option    value="${sl}" selected="true" />
		</c:if>
		<c:if test="${!rSpokenLanguages.contains(sl)}">
			<f:option    value="${sl}" />
		</c:if>
	</c:forEach>
</f:select>
</td>
<td><f:errors path="spokenLanguages" cssClass="myCss"/></td>
</tr>


<tr>
<td>Hobbies: </td> 
<td>
<c:forEach items="${hobbies}" var="h">
	<c:if test="${rHobbies.contains(h) }">
		<f:checkbox  path="hobbies"  value="${h}" label="${h}" checked="true"/>
	</c:if>

	<c:if test="${!rHobbies.contains(h) }">
		<f:checkbox  path="hobbies"  value="${h}" label="${h}"/>
	</c:if>
</c:forEach>
</td>
<td><f:errors path="hobbies" cssClass="myCss"/></td>
</tr>


<tr>
<td>Employee Type: </td> 
<td>

<c:forEach items="${employeeType}"  var="et">
<c:choose>
<c:when test="${rEmployeeType.equals(et)}">
	<f:radiobutton  path="employeeType" label="${et}"  value="${et}" checked="true"/>
</c:when>
<c:otherwise>
	<f:radiobutton  path="employeeType" label="${et}"  value="${et}" />
</c:otherwise>
</c:choose>
</c:forEach>
</td>
<td><f:errors path="employeeType" cssClass="myCss"/></td>
</tr>

<tr>
<td>Email Id: </td> <td><f:input  path="emailId"  value="${e.getEmailId()}"/></td>
<td><f:errors path="emailId" cssClass="myCss"/></td>
</tr>

<tr>
<td>Mobile No: </td> <td><f:input  path="mobileNo"  value="${e.getMobileNo()}"/></td>
<td><f:errors path="mobileNo" cssClass="myCss"/></td>
</tr>

<tr>
<td>insured:</td> 
<td>
<c:if test="${rInsured }" >
	<f:checkbox  path="insured"  checked="checked"/>
</c:if>
<c:if test="${!rInsured }" >
	<f:checkbox  path="insured"  />
</c:if>
</td>
<td><f:errors path="insured" cssClass="myCss"/></td>
</tr>

<tr>
<td>AddressLine1: </td> <td><f:input path="address.addressLine1" value="${e.getAddress().getAddressLine1()}" /></td>
<td><f:errors path="address.addressLine1" cssClass="myCss"/></td>
</tr>
<tr>
<td>AddressLine2: </td> <td><f:input path="address.addressLine2" value="${e.getAddress().getAddressLine2()}" /></td>
<td><f:errors path="address.addressLine2" cssClass="myCss"/></td>
</tr>

<tr>
<td>Cty: </td> <td><f:input path="address.city" value="${e.getAddress().getCity()}" /></td>
<td><f:errors path="address.city" cssClass="myCss"/></td>
</tr>

<tr>
<td>State: </td> <td><f:input path="address.state" value="${e.getAddress().getState()}" /></td>
<td><f:errors path="address.state" cssClass="myCss"/></td>
</tr>

<tr>
<td>Country: </td> <td><f:input path="address.country" value="${e.getAddress().getCountry()}" /></td>
<td><f:errors path="address.country" cssClass="myCss"/></td>
</tr>

<tr>
<td>Zip: </td> <td><f:input path="address.zip" value="${e.getAddress().getZip()}" /></td>
<td><f:errors path="address.zip" cssClass="myCss"/></td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit"  value="Submit" class="btn btn-primary"/></td>
</tr>
</table>
</f:form>

<p><strong>List of Employees</strong></p>

<table border="1">
<tr>
<td>EmpId</td><td>Name</td><td>Designation</td><td>salary</td>
<td>dob</td><td>Gender</td><td>Skills</td><td>Spoken Languages</td><td>Hobbies</td>
<td>Employee Type</td><td>emailId</td><td>Mobile No</td><td>Insured</td>
<td colspan="2">Address</td>
<td>Action</td>
</tr>
<c:forEach items="${employees}"  var="e"> 

<tr>
<td>${e.getEmpId()}</td><td>${e.getName()}</td><td>${e.getDesignation()}</td>
<td>${e.getSalary()}</td><td>${e.getDob()}</td> <td>${e.getGender()}</td>
<td>${e.getSkills()}</td> <td>${e.getSpokenLanguages()}</td> 

<td>
<c:forEach items="${e.getHobbies()}" var="h">
${h}
</c:forEach>


</td>
<td>${e.getEmployeeType()}</td>  <td>${e.getEmailId()}</td> <td>${e.getMobileNo()}</td>
<td>${e.isInsured()}</td>

<td>${e.getAddress().getCity()}</td>
<td>${e.getAddress().getState()}</td>

<td>
<a href="update?empId=${e.getEmpId()}">Update</a>
|
<a href="delete?empId=${e.getEmpId()}">Delete</a>
</td>
</tr>
</c:forEach>

</table>
</div>
</body>
</html>