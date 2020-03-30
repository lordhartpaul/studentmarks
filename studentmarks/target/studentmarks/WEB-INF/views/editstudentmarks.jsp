<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="/css/bootstrap.css"      rel="stylesheet">
	<link href="/css/custom.css"      rel="stylesheet">
	<link href="/css/main.css"      rel="stylesheet">
</head>

<body>

 	<div class="form-container">
 	
 	<h1>Edit Student Details</h1>
 	
	<form:form method="POST" modelAttribute="studentmarks" commandName="studentmarks" class="form-horizontal" action="/editsave">

<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Name</label>
				<div class="col-md-7">
					<form:hidden path="id"  class="form-control input-sm"/>
					<div class="has-error">
						
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="name">Name</label>
				<div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="name" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>

		

		
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="marks">Marks</label>
				<div class="col-md-7">
					<form:input type="text" path="marks" id="marks" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="marks" class="help-inline"/>
					</div>
				</div>
			</div>
		</div>


		
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Edit" class="btn btn-primary btn-sm">
			</div>
		</div>
	</form:form>
	</div>
</body>
</html>