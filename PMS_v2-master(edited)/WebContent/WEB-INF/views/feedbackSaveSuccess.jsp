<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
NAME OF THE COMPANY:${feedback.get(0).company}
<br>
<br>


<c:if test="${!empty feedback}">
	<table align="left" border="1">
<tr>
			<th>Name</th>
			
		<th>Feedback:</th>
		</tr>
		<c:forEach items="${feedback}" var="a">
			<tr>
			
			<td>${a.username}</td>
				
									<td>${a.feeback}</td>	
								
			
		</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>