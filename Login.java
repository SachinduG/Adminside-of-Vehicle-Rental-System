package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aId = request.getParameter("aId");
		String aPassword = request.getParameter("aPassword");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/OVRS", "root", "1234");
			
			Statement stm = conn.createStatement();
			
			ResultSet rs = stm.executeQuery("select aId, aPassword from admin where aId ='"+aId+"'and aPassword = '"+aPassword+"' ");
		
			if(rs.next()){
				HttpSession session = request.getSession();
				session.setAttribute("aId", aId);
				
				PrintWriter writer = response.getWriter();
				writer.println("<script>");
				writer.println("alert('Logged in successfully!')");
				writer.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.include(request, response);
			}
			else{
				PrintWriter writer = response.getWriter();
				writer.println("<script>");
				writer.println("alert('Invalid ID or Password')");
				writer.println("</script>");
			
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
