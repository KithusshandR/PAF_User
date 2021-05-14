
<%@page import="com.User"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/bootstrap.min.js">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/jquery-3.2.1.js"></script>
<script src="Components/User.js"></script>
<meta charset="ISO-8859-1">
<title>Investor service</title>
</head>
<body>
	
<div class="container">
<div class="row">
	
	<div class="col-8">
	<form id="formItem" name="formItem">
	
			 Investor Name: 
			<input id="Name" name="Name" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Mail: 
			<input id="email" name="email" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Project Code: 
			<input id="phoneNo" name="phoneNo" type="text" 
			 class="form-control form-control-sm">
			 
			<br> Project Name: 
			<input id="password" name="password" type="text" 
			 class="form-control form-control-sm">
			<br>
			
			<input id="btnSave" name="btnSave" type="button" value="Save" 
			 class="btn btn-primary">
			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
			</form>
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>
			
			<br>
			<div id="divItemsGrid">
			<%
				User itemObj = new User();
				out.print(itemObj.readUser());
			%>	
			</div>
			
			
			
			
	
		</div>

	</div>

</div>
	
</body>
</html>