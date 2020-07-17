<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.oop.model.Vehicle"%>
<%@page import="com.oop.service.impl.VehicleServiceimpl"%>
<%@page import="com.oop.service.VehicleService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit admin</title>
<link rel="stylesheet" href="style/main.css">
	
	 <style>
		 body{
      margin: 0;
      padding: 0;
    }
	.mainbody {
    background: url(images/parking.jpg);
    background-size: cover;
    background-attachment: fixed;
    background-repeat: no-repeat;
    width:100%;
    height:100vh; 
	display: flex;          
	}
    header .name {
       float: left;
       font-family: cursive;
       text-transform: uppercase;
       color:white;
       text-align: center;
       font-size: 2em;
       background-repeat: repeat-x;
     }
    </style>
</head>
<body>
	<div class="mainbody">
	<header>
	<div class="back"><a href="vehicle.jsp"><< </a></div>		
    <div class="name">&nbsp;RentJet</div>
    <div class="loggedin"> 
    <a href="logout.jsp">Log out</a>
    </div>

  </header>
	<div class="add">
				
	<h2>Modify Vehicle</h2>
<%
Vehicle vhl =new Vehicle();
%>
<%
VehicleService vhlservice= new VehicleServiceimpl();
%>
	<form action="EditVehicleServlet" method="post" class="adminform">
	<% 
	String vId = request.getParameter("vId");
	%>
		<p>
			<label for="">Id:</label>
			<input type="text" name="vId" value="<%=vId%>" readonly>
		</p>
		<p>
			<label for="">Model:</label>
			<input type="text" name="model" value="" >
		</p>
		<p>
			<label for="">Registration Number:</label>
			<input type="text" name="registrationNo" value="">
		</p>
		<p>
			<label for="">Type:</label>
			<input type="text" name="type" value="">
		</p>
		<p>
			<label for="">Number of Seats:</label>
			<input type="text" name="seat" value="">
		</p>
		<p>
			<label for="">&nbsp;</label>
			<button type="submit" name="submit">Save</button>
		</p>
	</form>		
	
	</div>
	</div>	
</body>
</html>