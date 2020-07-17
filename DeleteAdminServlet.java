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
import com.oop.service.AdminService;
import com.oop.service.impl.AdminServiceimpl;

/**
 * Servlet implementation class DeleteAdminServlet
 */
@WebServlet("/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminServlet() {
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
		String aId = request.getParameter("deleteValue");
		
		AdminService admservice = new AdminServiceimpl();
		
		boolean isDeleted = false;
		try {
			isDeleted = admservice.deleteAdmin(aId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(isDeleted==true){
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Deleted Successfully')");
			writer.println("</script>");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
			rd.include(request, response);
		}
		else{
			PrintWriter writer = response.getWriter();
			
			writer.println("<script>");
			writer.println("alert('Deletion Failed!')");
			writer.println("</script>");
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin.jsp");
			rd.include(request, response);
		}
	}

}
