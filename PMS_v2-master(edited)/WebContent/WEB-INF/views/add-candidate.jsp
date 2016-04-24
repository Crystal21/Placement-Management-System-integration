 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-2.2.1.min.js"></script>
<title>Add Candidate</title>
</head>
<body>
<form:form action="addcandidate.html" modelAttribute="userBean" method="post">
Name:<form:input name="name" type="text" path="username" /><br>
Company:<form:input name="company" id="company_id" path="company" />
<br>
<input type="submit" value="Add"/><br />
</form:form>
<a href="view-candidate.html">Back</a>
<!-- 
<script>
var arr=[];
arr.push('#clist');
$.each($(arr), function (i, item) {
$('#company_id').append($('<option>', {
    value: $(item.company_id),
    text: $(item.company_id)
}));
});
</script> -->
</body>
</html>