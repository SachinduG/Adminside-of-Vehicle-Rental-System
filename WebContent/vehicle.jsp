<%@page import="com.oop.model.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.impl.VehicleServiceimpl"%>
<%@page import="com.oop.service.VehicleService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle</title>

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
       background-repeat: repeat-x;
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
	<h1>Vehicles</h1><span><a href="addvehicle.jsp">+ Add New Vehicle</a></span>

		<br><br><br><br><table class="list clearfix">
		<tr>
			<th>ID</th>
			<th>Model</th>
			<th>Registration Number</th>
      		<th>Type</th>
      		<th>Number of Seats</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			VehicleService serv = new VehicleServiceimpl();
		
			ArrayList<Vehicle> list = serv.getAllVehicles();
			
			for(Vehicle v :list){
				
			
		%>
		<tr>
			<th><%=v.getvId()%></th>
			<th><%=v.getModel() %></th>
			<th><%=v.getRegistrationNo() %></th>
			<th><%=v.getType() %></th>
      		<th><%=v.getSeat()%></th>
      		
      		<th><a href="editvehicle.jsp?vId=<%=v.getvId()%>">Edit</a></th>
      		<th>
      			<a>
      				<form action="DeleteVehicleServlet" method="post">
      					<input type="hidden" name="deleteValue" value="<%=v.getvId()%>">
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