<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>
<body>
<h1 align="center">Students List</h1>
<table id="t02"  cellpadding="2">
<tr>
<th>
<a  href="/entry"><h2>Home Page:Entry New Student Details</h2></a>

</th>

<th>

<a  align ="right" href="/delete"><h2>Delete All Students</h2></a>
</th>
</tr>
</table>
<table >
<tr>


  <th>Page No : 
<c:forEach var="count" items="${pageCount}"  varStatus="theCount"> 
<a align="right" href="/viewstudentmarks/${theCount.count}">${theCount.count}</a>   
</c:forEach>  
</th>

</tr>

</table>
   
<form:form  class="form-horizontal" >
<table id="t01" border="2" width="70%" cellpadding="2">
<tr><th>Id</th><th>name</th><th>marks</th>
</tr>  

   <c:forEach var="studentmarks" items="${list}"> 
   <tr>  
   <td>${studentmarks.id}</td>  
   <td>${studentmarks.name}</td> 
   <td>${studentmarks.marks}</td> 
    
   <td><a href="/editstudentmarks/${studentmarks.id}">Edit</a></td>  
   <td><a href="/deletestudentmarks/${studentmarks.id}">Delete</a></td>  
   </tr>  
   </c:forEach> 
   
   
   </table>  
   <br/>
   
  
   </form:form>
</body>
</html>