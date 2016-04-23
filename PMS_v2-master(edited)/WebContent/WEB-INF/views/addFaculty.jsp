<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Faculty</title>
</head>
<body>
	<form:form method="POST"  modelAttribute="facultyBean" action="registerFaculty">
	<h2><u>Add Faculty</u></h2>
		<table>
			<tr>
				<td>ID :</td>
				<td><form:input path="userId" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Branch :</td>
				<td><form:select path="branch">
						<form:option value="0" label="Select" />
						<form:option value="Computer Engineering"  label="Computer" />
						<form:option value="IT Engineering" label="IT" />
						<form:option value="Electronics Engineering" label="Electronics" />
						<form:option value="Production Engineering" label="Production" />
					</form:select></td>
			</tr>
			
			
			<tr>
				<td>Gender :</td>
				<td><form:radiobutton path="gender" value="MALE" label="Male" />
					<form:radiobutton path="gender" value="FEMALE" label="Female" /></td>
			</tr>
			
			<tr>
				<td>Email ID :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr><td></td></tr>
			
			<tr>
			
				<td colspan="2"><input type="submit" value="Add Faculty"></td>
			</tr>
		</table>
	</form:form>


</body>
</html>
