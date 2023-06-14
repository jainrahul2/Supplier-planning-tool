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
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/newmdselist", "/insertmdselist","/deletemdselist","/editmdselist","/updatemdselist"})
public class ControllerServletMDSEList extends HttpServlet {
	
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private static  MDSEListDAO MDSEListDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		
		MDSEListDAO= new MDSEListDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/newmdselist":
				showNewmdse(request, response);
				break;      
			case "/insertmdselist":
				insertmdse(request, response);
				break;
			case "/deletemdselist":
				deletemdse(request, response);
				break;
			case "/editmdselist":
				showEditFormmdse(request, response);
				break;
			case "/updatemdselist":
				updatemdse(request, response);
				break;
			default :
				listmdselist(request, response);
				break;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("login");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
	}
	
	

	
	private void listmdselist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<MDSEList> MDSEList  = MDSEListDAO.listMDSEList();
		request.setAttribute("MDSEList", MDSEList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("MDSEList.jsp");
		dispatcher.forward(request, response);
		
		
	}	
	private void showNewmdse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("MDSEListForm.jsp");
		dispatcher.forward(request, response);
		
	}

	
	private void showEditFormmdse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String code = request.getParameter("code");
        MDSEList MDSEList = MDSEListDAO.getMDSEList(code);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("MDSEListForm.jsp");
        request.setAttribute("MDSEList", MDSEList);
        dispatcher.forward(request, response);

	}
	
	
	private void insertmdse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String code = request.getParameter("code");
		String division_number = request.getParameter("division_number");
		String division_name = request.getParameter("division_name");
		String entity_number = request.getParameter("entity_number");
		String entity_name = request.getParameter("entity_name");
		String subdivison_number = request.getParameter("subdivison_number");
		String subdivision_name = request.getParameter("subdivision_name");
		String cls = request.getParameter("cls");
		String status = request.getParameter("status");
		

		MDSEList MDSEList =  new MDSEList(code,division_number,division_name,entity_number,entity_name,subdivison_number,subdivision_name,cls,status);
		
		MDSEListDAO.insertMDSEList(MDSEList);
		response.sendRedirect("listmdselist");
	}


	
	private void updatemdse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String code = request.getParameter("code");
		String division_number = request.getParameter("division_number");
		String division_name = request.getParameter("division_name");
		String entity_number = request.getParameter("entity_number");
		String entity_name = request.getParameter("entity_name");
		String subdivison_number = request.getParameter("subdivison_number");
		String subdivision_name = request.getParameter("subdivision_name");
		String cls = request.getParameter("cls");
		String status = request.getParameter("status");
		

		MDSEList MDSEList =  new MDSEList(code,division_number,division_name,entity_number,entity_name,subdivison_number,subdivision_name,cls,status);
		
		MDSEListDAO.updateMDSE(MDSEList);
		response.sendRedirect("listmdselist");
	}
	 
	private void deletemdse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String code = request.getParameter("code");
		 
	        MDSEList MDSEList = new MDSEList(code);
	        MDSEListDAO.deleteMDSEList(MDSEList);
	        response.sendRedirect("listmdselist");
	}

}
