<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.oop.model.Admin"%>
<%@page import="com.oop.service.impl.AdminServiceimpl"%>
<%@page import="com.oop.service.AdminService"%>
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
	<div class="back"><a href="admin.jsp"><< </a></div>		
    <div class="name">&nbsp;RentJet</div>
    <div class="loggedin"> 
    <a href="logout.jsp">Log out</a>
    </div>

  </header>
	<div class="add">
				
	<h2>Modify Admin</h2>
<%
Admin adm =new Admin();
%>
<%
AdminService admservice= new AdminServiceimpl();
%>
	<form action="EditAdminServlet" method="post" class="adminform">
	<% 
	String aId = request.getParameter("aId");
	

	%>
		<p>
			<label for="">Id:</label>
			<input type="text" name="aId" value="<%=aId%>" readonly>
		</p>
		<p>
			<label for="">Name:</label>
			<input type="text" name="aName" value=""> 
		</p>
		<p>
			<label for="">Email Address:</label>
			<input type="text" name="aEmail" value="">
		</p>
		<p>
			<label for="">Contact:</label>
			<input type="text" name="aPhone" value="">
		</p>
		<p>
			<label for="">Password:</label>
			<input type="text" name="aPassword" value="">
		</p>
		<p>
			<label for="">&nbsp;</label>
			<button type="submit" name="submit">Update</button>
		</p>
	</form>		
	
	</div>
	</div>	
</body>
</html>