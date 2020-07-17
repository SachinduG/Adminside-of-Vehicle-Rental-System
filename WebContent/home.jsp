<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<link rel="stylesheet" href="style/main.css">
    <style>
    body{
      margin: 0;
      padding: 0;
    }
    body {
      background: url(images/parking.jpg);
      background-size: cover;
      background-attachment: fixed;
      background-repeat: no-repeat;
      width:100%;
      height:100vh;
      display: flex;
    }
    .mainbody{
      height: 100vh;
      width: 100%;

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
<div class="mainbody clearfix">
  <header>
    <div class="name">RentJet</div>
    <div class="loggedin"> 
    <a href="logout.jsp">Log out</a>
    </div>

  </header>

    <section class="mbody clearfix">
     <div class="menubar">
      
        <ul>
           <li><a href="vehicle.jsp">VEHICLE</a></li> <br>
              <li><a href="customer.jsp">CUSTOMER</a></li> <br>
               <li><a href="driver.jsp">DRIVER</a></li> <br>
              <li><a href="admin.jsp">ADMIN</a></li>     
        </ul>
     </div>
  </section>
</div>
</body>
</html>