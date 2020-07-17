<%@page import="com.oop.model.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.oop.service.impl.AdminServiceimpl"%>
<%@page import="com.oop.service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>

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
	<h1>Admins</h1><span><a href="addadmin.jsp">+ Add New Admin</a></span>

		<br><br><br><br><table class="list clearfix">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
      		<th>Phone</th>
      		<th>Password</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			AdminService serv = new AdminServiceimpl();
		
			ArrayList<Admin> list = serv.getAllAdmins();
			
			for(Admin a :list){
				
			
		%>
		<tr>
			<th><%=a.getaId()%></th>
			<th><%=a.getaName() %></th>
			<th><%=a.getaEmail() %></th>
			<th><%=a.getaPhone() %></th>
      		<th><%=a.getaPassword()%></th>
      		
      		<th><a href="editadmin.jsp?aId=<%=a.getaId()%>">Edit</a></th>
      		<th>
      			<a>
      				<form action="DeleteAdminServlet" method="post">
      					<input type="hidden" name="deleteValue" value="<%=a.getaId()%>">
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