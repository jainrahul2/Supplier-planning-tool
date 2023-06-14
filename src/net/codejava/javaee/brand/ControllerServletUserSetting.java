package net.codejava.javaee.brand;

import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;




public class ControllerServletUserSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public ControllerServletUserSetting() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email_id = request.getParameter("email_id");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword=request.getParameter("confirmpassword");
		UserSettingDAO UserSettingDAO = new UserSettingDAO();

		try {
				
				
				String destPage = "UserSettingForm.jsp";
				boolean  checkpassowrd = UserSettingDAO.changepassword(email_id, newpassword);
				if (checkpassowrd) 
				{
				
					HttpSession session = request.getSession(false);
			        if (session != null) {
			            session.removeAttribute("login");
			             
			            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			            dispatcher.forward(request, response);
			        }
				} 
				else 
				{
					String message = "Invalid password";
					request.setAttribute("message", message);
					RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
					dispatcher.forward(request, response);
					
				}
			
		} 
		catch(SQLException | ClassNotFoundException ex)
		{
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
		
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {}
			
}
