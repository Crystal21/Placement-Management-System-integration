<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
 <head>  
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
  <title>Feedback</title>
  <style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>  
 </head>  
 <body>  
  <h2>Add Feedback Data</h2>  
  <form:form method="POST" action="save.html">  
  
      <table>  
     
     
       <tr hidden>  
           <td><form:label path="username">User name:</form:label></td>  
           <td><form:input path="username" value= "${sessionScope.userName}" /></td>  
           <td><form:errors path="username" cssClass="error" /></td>
       </tr>  
       <tr>  
           <td><form:label path="feeback">Feedback:</form:label></td>  
           <td><form:input path="feeback" /></td>  
           <td><form:errors path="feeback" cssClass="error" /></td>
       </tr>  
       <tr>  
           <td><form:label path="company">Company:</form:label></td>  
           <td><form:input path="company" /></td> 
           <td><form:errors path="company" cssClass="error" /></td> 
       </tr>  
          <tr>  
         <td colspan="2"><input type="submit" value="Submit"/></td>  
        </tr>  
   </table>   
  </form:form>  
  </body>
  </html>