package com.oop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oop.model.Driver;
import com.oop.service.DriverService;
import com.oop.service.impl.DriverServiceimpl;

/**
 * Servlet implementation class EditDriverServlet
 */
@WebServlet("/EditDriverServlet")
public class EditDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDriverServlet() {
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
		PrintWriter writer = response.getWriter();
		
		String dId = request.getParameter("dId");
		String dName = request.getParameter("dName");
		String dPhone = request.getParameter("dPhone");
		String dAddress = request.getParameter("dAddress");
	
		Driver dri = new Driver();
		
		dri.setdId(dId);
		dri.setdName(dName);
		dri.setdPhone(dPhone);
		dri.setdAddress(dAddress);
		
		DriverService driservice = new DriverServiceimpl();
		
	
		try{
			boolean isUpdated = driservice.editDriver(dri, dId);
		
			if(isUpdated == true){
				System.out.println("Success");
		
				writer.println("<script>");
				writer.println("alert('Updated Successfully')");
				writer.println("</script>");

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/driver.jsp");
				rd.include(request, response);
			}
			else{
				System.out.println("Unsuccess");
				
				
				writer.println("<script>");
				writer.println("alert('Update Failed!')");
				writer.println("</script>");
			
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/editdriver.jsp");
				rd.include(request, response);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
}
