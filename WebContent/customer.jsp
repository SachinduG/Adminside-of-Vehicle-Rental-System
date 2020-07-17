<%@page import="com.oop.model.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.impl.CustomerServiceimpl"%>
<%@page import="com.oop.service.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer</title>
	<link rel="stylesheet" href="style/main.css">
	<link rel="stylesheet" href="style/user.css">
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
    <div class="back"><a href="home.jsp"><< </a></div>
    <div class="name">&nbsp;RentJet</div>
    <div class="loggedin"> 
    <a href="logout.jsp">Log out</a>
    </div> 
  </header>
 <div class="mains clearfix">   
  <div class="h clearfix"><h1>Customers</h1></div>
    <br>
    <table class="lists clearfix">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Phone</th>
      <th>Email</th>
      <th>Address</th>
    </tr>
    
		<%
			CustomerService serv = new CustomerServiceimpl();
		
			ArrayList<Customer> list = serv.getAllCustomers();
			
			for(Customer c :list){
				
			
		%>
		<tr>
			<th><%=c.getcId()%></th>
			<th><%=c.getcName() %></th>
			<th><%=c.getcPhone() %></th>
      		<th><%=c.getcEmail() %></th>
      		<th><%=c.getcAddress()%></th>
		</tr>
		<%
			}
		%>
        </table>
  </div>
</div>
</body>
</html>