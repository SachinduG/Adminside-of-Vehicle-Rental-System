<%@page import="com.oop.model.Driver"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.impl.DriverServiceimpl"%>
<%@page import="com.oop.service.DriverService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Driver</title>

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
    height: 100%;
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
       backgrthound-repeat: repeat-x;
     }
    </style>
</head>
<body>
 <div class="mainbody">
	<header>
    <div class="back"><a href="home.jsp"><< </a></div>
    <div class="name">&nbsp;RentJet</span></div>
    <div class="loggedin"> 
    <a href="logout.jsp">Log out</a>
    </div>

  </header>
	<div class="main clearfix">		
	<h1>Drivers</h1><span><a href="adddriver.jsp">+ Add New Driver</a></span>
	
		<br><br><br><br><table class="list clearfix">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone</th>
      		<th>Address</th>
      		<th>Edit</th>
      		<th>Delete</th>
		</tr>
		
		<%
			DriverService serv = new DriverServiceimpl();
		
			ArrayList<Driver> list = serv.getAllDrivers();
			
			for(Driver d :list){
				
			
		%>
		<tr>
			<th><%=d.getdId()%></th>
			<th><%=d.getdName() %></th>
			<th><%=d.getdPhone() %></th>
      		<th><%=d.getdAddress()%></th>
      		
      		<th><a href="editdriver.jsp?dId=<%=d.getdId()%>">Edit</a></th>
      		<th>
      			<a>
      				<form action="DeleteDriverServlet" method="post">
      					<input type="hidden" name="deleteValue" value="<%=d.getdId()%>">
      					<input type="submit" name="Delete" value="Delete">
      				</form>
      			</a>
      		</th>
		</tr>
		<%
			}
		%>
		</table>
	</div>
</div>
</body>
</html>