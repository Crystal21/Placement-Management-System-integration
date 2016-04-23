<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Resume</title>
</head>
<body>



	<form method="POST" enctype="multipart/form-data" action="uploadResume">
		<!-- Enter Username: <input id="username" name="username" type="text"
			value="" />--> <br />  <br /> Choose file to upload: <input type="file"
			name="fileUpload"><br />
		<c:if test="${error==1}">
			<p>Failed to upload...File format can be docx/pdf/odt only!</p>
		</c:if>
		<c:if test="${error1==1}">
			<p>Failed to upload...File size can be only upto 512KB</p>
		</c:if>
		<input type="submit" value="Upload">
	</form>
</body>
</html>