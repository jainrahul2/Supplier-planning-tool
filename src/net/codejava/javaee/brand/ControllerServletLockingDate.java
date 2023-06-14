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


@WebServlet(urlPatterns = {"/newlockingdate", "/insertlockingdate","/deletelockingdate","/editlockingdate","/updatelockingdate","/updatelocktime"})
public class ControllerServletLockingDate extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static  LockingDateDAO LockingDateDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		
		LockingDateDAO= new LockingDateDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/newlockingdate":
				showNewlockingdate(request, response);
				break;      
			case "/insertlockingdate":
				insertlockingdate(request, response);
				break;
			case "/deletelockingdate":
				deletelockingdate(request, response);
				break;
			case "/editlockingdate":
				showEditFormlockingdate(request, response);
				break;
			case "/updatelockingdate":
				updatelockingdate(request, response);
				break;
			case "/updatelocktime":
				updatelocktime(request, response);
				break;
			default :
				lockingdateList(request, response);
				break;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
	}
	
	
	

	
	private void lockingdateList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<LockingDate> LockingDate  = LockingDateDAO.listLockingDate();
		request.setAttribute("LockingDate",LockingDate);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("LockingDateList.jsp");
		dispatcher.forward(request, response);
		
		
	}	
	private void showNewlockingdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("LockingDateForm.jsp");
		dispatcher.forward(request, response);
		
	}

	
	private void showEditFormlockingdate(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String year = request.getParameter("year");
		LockingDate LockingDate = LockingDateDAO.getLockingDate(year);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("LockingDateForm.jsp");
        request.setAttribute("LockingDate", LockingDate);
        dispatcher.forward(request, response);

	}

	
	private void insertlockingdate(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String year = request.getParameter("year");
		String feb = request.getParameter("feb");
		String mar = request.getParameter("mar");
		String apr = request.getParameter("april");
		String may = request.getParameter("may");
		String june =request.getParameter("june");
		String july = request.getParameter("july");
		String august = request.getParameter("august");
		String september = request.getParameter("september");
		String october = request.getParameter("october");
		String november = request.getParameter("november");
		String december = request.getParameter("december");
		String january = request.getParameter("january");
		String updated_by = request.getParameter("updated_by");
		String updated_on =request.getParameter("updated_on");
		

		LockingDate LockingDate =  new LockingDate(year,feb,mar,apr,may,june,july,august,september,october,november,december,january,updated_by,updated_on);

		LockingDateDAO.insertLockingDate(LockingDate);
		response.sendRedirect("lockingdateList");
	}

	private void updatelocktime(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String year = request.getParameter("year");
		String feb = request.getParameter("feb");
		String mar = request.getParameter("mar");
		String april = request.getParameter("april");
		String may = request.getParameter("may");
		String june =request.getParameter("june");
		String july = request.getParameter("july");
		String august = request.getParameter("august");
		String september = request.getParameter("september");
		String october = request.getParameter("october");
		String november = request.getParameter("november");
		String december = request.getParameter("december");
		String january = request.getParameter("january");
		String updated_by = request.getParameter("updated_by");
		String updated_on =request.getParameter("updated_on");
		String timevalue=request.getParameter("timevalue");
		
		LockingDate LockingDate =  new LockingDate(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on,timevalue);
	
		LockingDateDAO.updatelocktime(LockingDate);
		response.sendRedirect("lockingdateList");
	}
	
	private void updatelockingdate(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String year = request.getParameter("year");
		String feb = request.getParameter("feb");
		String mar = request.getParameter("mar");
		String april = request.getParameter("april");
		String may = request.getParameter("may");
		String june =request.getParameter("june");
		String july = request.getParameter("july");
		String august = request.getParameter("august");
		String september = request.getParameter("september");
		String october = request.getParameter("october");
		String november = request.getParameter("november");
		String december = request.getParameter("december");
		String january = request.getParameter("january");
		String updated_by = request.getParameter("updated_by");
		String updated_on =request.getParameter("updated_on");
		

		LockingDate LockingDate =  new LockingDate(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on);

		LockingDateDAO.updateLockingDate(LockingDate);
		response.sendRedirect("lockingdateList");
	}
	 
	private void deletelockingdate(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String year = request.getParameter("year");
		 
	        LockingDate LockingDate = new LockingDate(year);
	        LockingDateDAO.deleteLockingDate(LockingDate);
	        response.sendRedirect("lockingdateList");
	}

}
