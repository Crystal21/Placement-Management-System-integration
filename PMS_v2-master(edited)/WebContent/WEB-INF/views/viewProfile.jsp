<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Jobs</title>
</head>
<body>
<h1>List Of Jobs</h1>
<h3><a href="addProfile.html">Add New Profile</a></h3>
<h2><a href="form">Logout</a></h2>

<c:if test="${!empty profiles}">
	<table align="left" border="1">
		<tr>
			<th>Job ID</th>
			<th>Event Id</th>
			<th>Job Description</th>
			<th>Category</th>
			<th>Ctc</th>
			<th>Skills</th>
			<th>Document</th>
	<!--	<th>Edit Or Delete</th> 	-->
		</tr>


		<c:forEach items="${profiles}" var="profile">
			<tr>
				<td><c:out value="${profile.job_id}"/></td>
				<td><c:out value="${profile.event_id}"/></td>
				<td><c:out value="${profile.job_description}"/></td>
				<td><c:out value="${profile.job_category}"/></td>
				<td><c:out value="${profile.ctc}"/></td>
				<td><c:out value="${profile.skills_required}"/></td>
				<td><c:out value="${profile.docs_required}"/></td>
<%-- 				<td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td> --%>
			</tr>
		</c:forEach>
	</table>
	
	
</c:if>
</body>
</html>