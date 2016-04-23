<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload CSV</title>
</head>
<body>



<form method="POST" enctype="multipart/form-data" action="uploadFile">
Enter year of passing:   <input id="year" name="year" type="text" value=""/><br/><br/>
		File to upload: <input type="file" name="fileUpload"><br />
		  <input type="submit" value="Upload"> Press here to upload the file!
	</form>
	<br/><br/>
	
</body>
</html>