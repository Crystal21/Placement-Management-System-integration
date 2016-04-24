<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<%ResultSet resultset =null;%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Room Allotment</title>
</head>
<body>


<form:form method="POST" enctype="multipart/form-data" modelAttribute="allotmentBean" action="saveAllotment">
	<h2><u>Room Allotment Details</u></h2>
		<table>
		
			 <tr>
				
				<td><form:input path="allotment_id" type="hidden" /></td>
			</tr> 
			
			<tr>
				<td>Company Name:</td>
				<td><form:select path="company_name">
				<%
    				try{
							Class.forName("org.postgresql.Driver").newInstance();
							Connection connection = DriverManager.getConnection
            				("jdbc:postgresql://localhost:5432/placementdb2?user=postgres&password=root");

       						Statement statement = connection.createStatement() ;

       						resultset =statement.executeQuery("select company_name from job_schema.company") ;
				%>
				<%  while(resultset.next()){ %>
            		<option><%= resultset.getString(1)%></option>
        		<% } %>
        		<%
        		}
        		catch(Exception e)
        		{
             			out.println("wrong entry"+e);
        		}
				%>
					</form:select></td>
			</tr>
			
			<tr>
				<td>Round No. :</td>
				<td><form:input path="round_no" /></td>
			</tr>
			
			<tr>
				<td>Room No. :</td>
				<td><form:input path="room_no" /></td>
			</tr>
			
			<tr>
				<td>Description :</td>
				<td><form:textarea path="job_description" /></td>
			</tr>
			
			<tr>
				<td>Drive date :</td>
				<td><form:input path="drive_date" placeholder="yyyy/mm/dd"/></td>
			</tr>
			
			<tr>
				<td>Upload File :</td>
				<td><form:input type="file" path="fileUpload"/></td> 
			</tr>
			
			<tr></tr><tr></tr>
			
			<tr>
			
				<td colspan="2"><input type="submit" value="Save"></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
