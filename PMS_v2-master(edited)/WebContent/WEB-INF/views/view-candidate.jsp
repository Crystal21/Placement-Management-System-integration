<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>view candidate list</title>
</head>
<body>
<form action="viewclist.html" method="post" >
	Company:<select name="company" >
	<option value="JPMC" >JPMC</option>
	<option value="Accenture" >Accenture</option>
	<option value="TCS" >TCS</option>
	</select><br>
	<input type="submit" value="submit"/> 
</form>
</body>
</html>