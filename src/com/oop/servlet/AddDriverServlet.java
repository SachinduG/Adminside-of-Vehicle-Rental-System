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
 * Servlet implementation class AddDriverServlet
 */
@WebServlet("/AddDriverServlet")
public class AddDriverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDriverServlet() {
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
		
		
		try {
			boolean isAdded = driservice.addNewDriver(dri);
		
			if(isAdded == true){
				System.out.println("Success");
				
	
				writer.println("<script>");
				writer.println("alert('Added Successfully')");
				writer.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/driver.jsp");
				dispatcher.include(request, response);
			}
			else{
				System.out.println("Unsuccess");
				
				writer.println("<script>");
				writer.println("alert('Insertion Failed!')");
				writer.println("</script>");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/adddriver.jsp");
				rd.include(request, response);
			}
		}catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
			}
			
	}

}
