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


@WebServlet(urlPatterns = {"/newfiscalcalendar", "/insertfiscalcalendar","/deletefiscalcalendar","/editfiscalcalendar","/updatefiscalcalendar"})
public class ControllerServletFiscalCalendar extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static  FiscalCalendarDAO FiscalCalendarDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		
		FiscalCalendarDAO= new FiscalCalendarDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/newfiscalcalendar":
				showNewfiscalcalendar(request, response);
				break;      
			case "/insertfiscalcalendar":
				insertfiscalcalendar(request, response);
				break;
			case "/deletefiscalcalendar":
				deletefiscalcalendar(request, response);
				break;
			case "/editfiscalcalendar":
				showEditFormfiscalcalendar(request, response);
				break;
			case "/updatefiscalcalendar":
				updatefiscalcalendar(request, response);
				break;
			default :
				listfiscalcalendar(request, response);
				break;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
	}
	
	
	

	
	private void listfiscalcalendar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<FiscalCalendar> FiscalCalendar  = FiscalCalendarDAO.listFiscalCalendar();
		request.setAttribute("FiscalCalendar", FiscalCalendar);
		RequestDispatcher dispatcher = request.getRequestDispatcher("FiscalCalendarList.jsp");
		dispatcher.forward(request, response);
		
		
	}	
	private void showNewfiscalcalendar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("FiscalCalendarForm.jsp");
		dispatcher.forward(request, response);
		
	}

	
	private void showEditFormfiscalcalendar(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String year = request.getParameter("year");
        FiscalCalendar FiscalCalendar = FiscalCalendarDAO.getFiscalCalendar(year);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("FiscalCalendarForm.jsp");
        request.setAttribute("FiscalCalendar", FiscalCalendar);
        dispatcher.forward(request, response);

	}

	
	private void insertfiscalcalendar(HttpServletRequest request, HttpServletResponse response) 
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
		

		FiscalCalendar FiscalCalendar =  new FiscalCalendar(year,feb,mar,apr,may,june,july,august,september,october,november,december,january,updated_by,updated_on);

		FiscalCalendarDAO.insertFiscalCalendar(FiscalCalendar);
		response.sendRedirect("listfiscalcalendar");
	}


	
	private void updatefiscalcalendar(HttpServletRequest request, HttpServletResponse response) 
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
		

		FiscalCalendar FiscalCalendar =  new FiscalCalendar(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on);

		FiscalCalendarDAO.updateFiscalCalendar(FiscalCalendar);
		response.sendRedirect("listfiscalcalendar");
	}
	 
	private void deletefiscalcalendar(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String year = request.getParameter("year");
		 
	        FiscalCalendar FiscalCalendar = new FiscalCalendar(year);
	        FiscalCalendarDAO.deleteFiscalCalendar(FiscalCalendar);
	        response.sendRedirect("listfiscalcalendar");
	}

}
