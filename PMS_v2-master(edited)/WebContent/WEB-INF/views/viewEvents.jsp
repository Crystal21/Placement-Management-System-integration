
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Events</title>
</head>
<body>
	<c:if test="${!empty events}">
		<table border="1">
			<tr>
				<th>Event Id</th>
				<th>Event type</th>
				<th>Company Id</th>
				<th>Approved</th>
				<th>Date</th>
				<th>Venue</th>
				<th>Time</th>
			</tr>
			<c:forEach items="${events}" var="ed">
				<tr>
					<td><c:out value="${ed.event_id}" /></td>
					<td><c:out value="${ed.event_type}" /></td>
					<td><c:out value="${ed.company_id}" /></td>
					<td><c:out value="${ed.approved}" /></td>
					<td><c:out value="${ed.date}" /></td>
					<td><c:out value="${ed.venue}" /></td>
					<td><c:out value="${ed.times}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>

</html>