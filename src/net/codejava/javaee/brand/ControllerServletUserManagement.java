package net.codejava.javaee.brand;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/newuser", "/insertuser","/deleteuser","/edituser","/updateuser"})
public class ControllerServletUserManagement extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static  UserManagementDAO UserManagementDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		
		UserManagementDAO= new UserManagementDAO(jdbcURL, jdbcUsername, jdbcPassword);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		
		try {
			switch (action) {
			case "/newuser":
				showNewUser(request, response);
				break;
			case "/insertuser":
				insertUser(request, response);
				break;
			case "/deleteuser":
				deleteUserList(request, response);
				break;
			case "/edituser":
				showEditFormUser(request, response);
				break;
			case "/updateuser":
				updateUser(request, response);
				break;
			default:
				listUser(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<UserManagement> UserManagement  = UserManagementDAO.listUserList();
		request.setAttribute("UserList", UserManagement);
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserManagementList.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("UserManagementForm.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showEditFormUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String user_id = request.getParameter("user_id");
        UserManagement user = UserManagementDAO.getUserList(user_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserManagementForm.jsp");
        request.setAttribute("UserList", user);
        dispatcher.forward(request, response);

	}

	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String user_id = request.getParameter("user_id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email_id = request.getParameter("email_id");
		String contact_number = request.getParameter("contact_number");
		String role = request.getParameter("role");
		String category = request.getParameter("category");
		String supporting = request.getParameter("supporting");
		String status = request.getParameter("status");
		

		UserManagement UserManagement = new UserManagement(user_id,first_name,last_name,email_id,contact_number,role,category,supporting,status);
		UserManagementDAO.insertUserList(UserManagement);
		response.sendRedirect("listuser");
	}


	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String user_id = request.getParameter("user_id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String email_id = request.getParameter("email_id");
		String contact_number = request.getParameter("contact_number");
		String role = request.getParameter("role");
		String category = request.getParameter("category");
		String supporting = request.getParameter("supporting");
		String status = request.getParameter("status");
		

		UserManagement UserManagement = new UserManagement(user_id,first_name,last_name,email_id,contact_number,role,category,supporting,status);
		UserManagementDAO.updateUser(UserManagement);
		response.sendRedirect("listuser");
	}
	

	
	
	private void deleteUserList(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String user_id = request.getParameter("user_id");
		 
	        UserManagement UserManagement = new UserManagement(user_id);
	        UserManagementDAO.deleteUserList(UserManagement);
	        response.sendRedirect("listuser");
	}

}


