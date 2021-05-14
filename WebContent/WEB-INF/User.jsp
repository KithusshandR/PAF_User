
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	 
  	<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet” type=”text/css” />
	<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
  

</head>
 <body>
		<div class="container">
<div class="row">
	
	<div class="col-8">
	<form id="formItem" name="formItem" method="post" action="Investors.jsp">
	
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
			
			<div id="alertSuccess" class="alert alert-success">
				<%
					out.print(session.getAttribute("statusMsg"));
				%>
			</div>
			
			<div id="alertError" class="alert alert-danger"></div>
			
			<br>
			
	
		</div>

	</div>

</div>
		
 </body>
</html>