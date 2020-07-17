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
import com.oop.model.Admin;
import com.oop.service.AdminService;
import com.oop.service.impl.AdminServiceimpl;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
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
		
		String aId = request.getParameter("aId");
		String aName = request.getParameter("aName");
		String aEmail = request.getParameter("aEmail");
		String aPhone = request.getParameter("aPhone");
		String aPassword = request.getParameter("aPassword");
		
		Admin adm = new Admin();
		
		adm.setaId(aId);
		adm.setaName(aName);
		adm.setaEmail(aEmail);
		adm.setaPhone(aPhone);
		adm.setaPassword(aPassword);
		
		AdminService admservice = new AdminServiceimpl();
		
		
		try {
			boolean isAdded = admservice.addNewAdmin(adm);
		
			if(isAdded == true){
				System.out.println("Success");
				
				writer.println("<script>");
				writer.println("alert('Added Successfully')");
				writer.println("</script>");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
				rd.include(request, response);
			}
			else{
				System.out.println("Unsuccess");
				
				writer.println("<script>");
				writer.println("alert('Insertion Failed!')");
				writer.println("</script>");
				
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/addadmin.jsp");
				rd.include(request, response);
			}
		}catch (SQLException | ClassNotFoundException e) {
					e.printStackTrace();
			}
			
	}
}
