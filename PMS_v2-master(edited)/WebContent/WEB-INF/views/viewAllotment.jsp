<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Allotments</title>
</head>
<body>
<h1>List Allotments</h1>
<h3><a href="addAllotment.html">Add New Allotment</a></h3>

<c:if test="${!empty allotments}">
	<table align="left" border="1">
		<tr>
			<th>Allotment ID</th>
			<th>Company Name</th>
			<th>Round No.</th>
			<th>Room No.</th>
			<th>Job Description</th>
			<th>Drive Date</th>
	<!--	<th>Edit Or Delete</th> 	-->
		</tr>


		<c:forEach items="${allotments}" var="allotment">
			<tr>
				<td><c:out value="${allotment.allotment_id}"/></td>
				<td><c:out value="${allotment.company_name}"/></td>
				<td><c:out value="${allotment.round_no}"/></td>
				<td><c:out value="${allotment.room_no}"/></td>
				<td><c:out value="${allotment.job_description}"/></td>
				<td><c:out value="${allotment.drive_date}"/></td>
<%-- 				<td align="center"><a href="edit.html?id=${employee.id}">Edit</a> | <a href="delete.html?id=${employee.id}">Delete</a></td> --%>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>