<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="uploadFile">
		File to upload: <input type="file" name="fileUpload"><br />
		  <input type="submit" accept=".jpeg" value="Upload"> Press here to upload the file!
	</form>
</body>
</html>