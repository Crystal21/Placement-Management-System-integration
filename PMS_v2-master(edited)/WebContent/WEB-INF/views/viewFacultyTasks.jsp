<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Faculty Tasks</title>
</head>
<body>
	<c:if test="${!empty fusers}">

		<table border="1">
			<tr>
				<th>User Name</th>
				<th>User Work</th>
			</tr>
			<c:forEach items="${fusers}" var="fuser">
				<tr>
					<td><c:out value="${fuser.userName}" /></td>
					<td><c:out value="${fuser.userWork}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<tr>
		<td><a href="TPOHome">Home</a></td>
	</tr>
	
</body>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Faculty Tasks</title>
</head>
<body>
	<c:if test="${!empty fusers}">

		<table border="1">
			<tr>
				<th>User Name</th>
				<th>User Work</th>
			</tr>
			<c:forEach items="${fusers}" var="fuser">
				<tr>
					<td><c:out value="${fuser.userName}" /></td>
					<td><c:out value="${fuser.userWork}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<tr>
		<td><a href="TPOHome">Home</a></td>
	</tr>
	
</body>
>>>>>>> darshgup139-master
</html>