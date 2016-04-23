<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="uploadMultiFiles" ng-app>
		<p>{{5+5}}</p>
		File to upload: <input type="file" name="fileUpload"><br />
		File to upload: <input type="file" name="fileUpload"><br />
		File to upload: <input type="file" name="fileUpload"><br />
		  <input type="submit" value="Upload"> Press here to upload the files!
	</form>
</body>
</html>