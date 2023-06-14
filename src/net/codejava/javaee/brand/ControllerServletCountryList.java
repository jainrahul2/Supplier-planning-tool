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

@WebServlet(urlPatterns = {"/newcountry", "/insertcountry","/deletecountry","/editcountry","/updatecountry"})
public class ControllerServletCountryList extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CountryListDAO CountryListDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		
		CountryListDAO= new CountryListDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/newcountry":
				showNewcountry(request, response);
				break;
			case "/insertcountry":
				insertcountry(request, response);
				break;
			case "/deletecountry":
				deletecountry(request, response);
				break;
			case "/editcountry":
				showEditFormcountry(request, response);
				break;
			case "/updatecountry":
				updatecountry(request, response);
				break;
			default:
				countrylist(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

	
	private void countrylist(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<CountryList> CountryList  = CountryListDAO.listCountryList();
		request.setAttribute("CountryList", CountryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CountryList.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewcountry(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CountryForm.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showEditFormcountry(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String country_code = request.getParameter("country_code");
		CountryList CountryList = CountryListDAO.getCountryList(country_code);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CountryForm.jsp");
        request.setAttribute("CountryList", CountryList);
        dispatcher.forward(request, response);

	}

	
	private void insertcountry(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String country_code = request.getParameter("country_code");
		String country_name = request.getParameter("country_name");
		
		String status = request.getParameter("status");
		

		CountryList CountryList = new CountryList(country_code,country_name,status);
		CountryListDAO.insertCountry(CountryList);
		response.sendRedirect("countrylist");
	}


	
	private void updatecountry(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String country_code = request.getParameter("country_code");
		String country_name = request.getParameter("country_name");
		
		String status = request.getParameter("status");
		

		CountryList CountryList = new CountryList(country_code,country_name,status);
		CountryListDAO.updateCountry(CountryList);
		response.sendRedirect("countrylist");
	}
	

	
	
	private void deletecountry(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String country_code = request.getParameter("country_code");
		 
		 CountryList CountryList = new CountryList(country_code);
		 CountryListDAO.deleteCountry(CountryList);
			response.sendRedirect("countrylist");
	}

}


