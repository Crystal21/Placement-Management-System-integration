<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <SCRIPT type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</SCRIPT> -->
<title>Admin</title>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<h3>Welcome To the Admin page !!!!!</h3>
	<h2>
		Logged in as
		<core:out value="${loginForm.userName}" />
	</h2>
	<table>

		<tr>
			<td><a href="addUser">Click here to Add students via csv
					file</a></td>
		</tr>
		<tr>
			<td><br />To add users manually</td>
		</tr>
		<tr>
			<td>1. <a href="addstudent.html">Add Student</a></td>
		</tr>
		<tr>
			<td>2. <a href="addfaculty.html">Add Faculty</a></td>
		</tr>
		<tr>
			<td>3. <a href="removeuser.html">Remove User</a><br /></td>
		</tr>
		<tr>
			<td>4. <a href="AssignTPO.html">Assign TPO</a><br /></td>
		</tr>
		<tr>
			<td>4. <a href="RemoveTPO.html">Remove TPO</a><br /></td>
		</tr>
		<tr>
			<td>5. <a href="ViewUsersA.html">View Users</a><br /></td>
		</tr>
		<tr>
			<td>6. <a href="InsertMonth.html">Insert Month to view
					Events Users</a><br /></td>
		</tr>


	</table>

	<br /></br>
	<table>
		<tr>
			<td><a href="searchHome">Click here to search for something</a></td>
		</tr>
		<tr>
			<td><a href="sendMail">Click here to send an email</a></td>
		</tr>
		<tr>

			<td><br /> <br /> <a href="form">Logout</a></td>
		</tr>
	</table>
</body>
</html>