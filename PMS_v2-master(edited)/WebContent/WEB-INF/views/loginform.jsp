<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT>
<title>Placement Management System</title>
</head>
<bodyonload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload=""onload="noBack();"
    onpageshow="if (event.persisted) noBack();" onunload="">
<h3>Login Form</h3>
<FONT color="blue">
User Name="UserName" and password="password"
</FONT>
<form:form action="logged"  commandName="loginForm">
	<table>
		<tr>
			<td>User Name:<FONT color="red"><form:errors path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td>Password:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>