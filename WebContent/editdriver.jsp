<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.oop.model.Driver"%>
<%@page import="com.oop.service.impl.DriverServiceimpl"%>
<%@page import="com.oop.service.DriverService"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit driver</title>
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
	<div class="back"><a href="driver.jsp"><< </a></div>		
    <div class="name">&nbsp;RentJet</div>
    <div class="loggedin"> 
    <a href="logout.jsp">Log out</a>
    </div>

  </header>
	<div class="add">
				
	<h2>Modify Driver</h2>
<%
Driver dri =new Driver();
%>
<%
DriverService driservice= new DriverServiceimpl();
%>	
	<form action="EditDriverServlet" method="post" class="adminform">
	<% 
	String dId = request.getParameter("dId");
	%>
		<p>
			<label for="">Id:</label>
			<input type="text" name="dId" value="<%=dId%>" readonly>
		</p>
		<p>
			<label for="">Name:</label>
			<input type="text" name="dName" value="" >
		</p>
		<p>
			<label for="">Phone:</label>
			<input type="text" name="dPhone" value="">
		</p>
		<p>
			<label for="">Address:</label>
			<input type="text" name="dAddress" value="">
		</p>
			<label for="">&nbsp;</label>
			<button type="submit" name="submit">Update</button>
		</p>
	</form>		
	
	</div>
	</div>	
</body>
</html>