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
import com.oop.model.Vehicle;
import com.oop.service.VehicleService;
import com.oop.service.impl.VehicleServiceimpl;

/**
 * Servlet implementation class AddVehicle
 */
@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
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
		
		String vId = request.getParameter("vId");
		String model = request.getParameter("model");
		String registrationNo = request.getParameter("registrationNo");
		String type = request.getParameter("type");
		String seat = request.getParameter("seat");
		
		Vehicle vhl = new Vehicle();
		
		vhl.setvId(vId);
		vhl.setModel(model);
		vhl.setRegistrationNo(registrationNo);
		vhl.setType(type);
		vhl.setSeat(seat);
		
		VehicleService vhlservice = new VehicleServiceimpl();
		
		
		try {
			boolean isAdded = vhlservice.addNewVehicle(vhl);
		
			if(isAdded == true){
				System.out.println("Success");
				
				
				writer.println("<script>");
				writer.println("alert('Added Successfully')");
				writer.println("</script>");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/vehicle.jsp");
				rd.include(request, response);
			}
			else{
				System.out.println("Unsuccess");
				
				writer.println("<script>");
				writer.println("alert('Insertion Failed!')");
				writer.println("</script>");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/addvehicle.jsp");
				rd.include(request, response);
			}
		}catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
			}
			
	}

}
