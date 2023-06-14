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

@WebServlet(urlPatterns = {"/newcontroloffice", "/insertcontroloffice","/deletecontroloffice","/editcontroloffice","/updatecontroloffice"})
public class ControllerServletControlOffice extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static ControlOfficeDAO ControlOfficeDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		
		ControlOfficeDAO= new ControlOfficeDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/newcontroloffice":
				showNewcontroloffice(request, response);
				break;
			case "/insertcontroloffice":
				insertcontroloffice(request, response);
				break;
			case "/deletecontroloffice":
				deletecontroloffice(request, response);
				break;
			case "/editcontroloffice":
				showEditFormcontroloffice(request, response);
				break;
			case "/updatecontroloffice":
				updatecontroloffice(request, response);
				break;
			default:
				controllist(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

	
	private void controllist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<ControlList> ControlList  = ControlOfficeDAO.listControlList();
		request.setAttribute("ControlList", ControlList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ControlOfficeList.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewcontroloffice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ControlOfficeForm.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showEditFormcontroloffice(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String id = request.getParameter("id");
		ControlList ControlList = ControlOfficeDAO.getControlList(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ControlOfficeForm.jsp");
        request.setAttribute("ControlList", ControlList);
        dispatcher.forward(request, response);

	}

	
	private void insertcontroloffice(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String id = request.getParameter("id");
		String control_office = request.getParameter("control_office");
		String region = request.getParameter("region");
		String status = request.getParameter("status");
		

		ControlList ControlList = new ControlList(id,control_office,region,status);
		ControlOfficeDAO.insertControlOffice(ControlList);
		response.sendRedirect("controllist");
	}


	
	private void updatecontroloffice(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String id = request.getParameter("id");
		String control_office = request.getParameter("control_office");
		String region = request.getParameter("region");
		String status = request.getParameter("status");
		

		ControlList ControlList = new ControlList(id,control_office,region,status);
		ControlOfficeDAO.updateControlOffice(ControlList);
		response.sendRedirect("controllist");
	}
	

	
	
	private void deletecontroloffice(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String id = request.getParameter("id");
		 
		 ControlList ControlList = new ControlList(id);
	        ControlOfficeDAO.deleteControlList(ControlList);
	        response.sendRedirect("controllist");
	}

}


