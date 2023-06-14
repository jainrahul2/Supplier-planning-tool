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

@WebServlet(urlPatterns = {"/newsupplier", "/insertsupplier","/deletesupplier","/editsupplier","/updatesupplier"})

public class ControllerServletSupplier extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  SupplierListDAO SupplierListDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		SupplierListDAO = new SupplierListDAO(jdbcURL, jdbcUsername, jdbcPassword);
		
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
			case "/newsupplier":
				showNewForm(request, response);
				break;
			case "/insertsupplier":
				insertSupplier(request, response);
				break;
			case "/deletesupplier":
				deleteSupplierList(request, response);
				break;
			case "/editsupplier":
				showEditForm(request, response);
				break;
			case "/updatesupplier":
				updateSupplier(request, response);
				break;
			default:
				listsupplier(request, response);
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

	private void listsupplier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<supplierList> supplierList = SupplierListDAO.listSupplierList();
		request.setAttribute("supplierList", supplierList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SupplierList.jsp");
		dispatcher.forward(request, response);
	}
	
	

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("SupplierForm.jsp");
		dispatcher.forward(request, response);
	}
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String supplier_number = request.getParameter("supplier_number");
        supplierList supp = SupplierListDAO.getSupplierList(supplier_number);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SupplierForm.jsp");
        request.setAttribute("supplierList", supp);
        dispatcher.forward(request, response);

	}
	

	private void insertSupplier(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String supplier_number =request.getParameter("supplier_number");
		
		String rpt_supplier = request.getParameter("rpt_supplier");
		String child_supplier = request.getParameter("child_supplier");
		String origin_indicator = request.getParameter("origin_indicator");
		String major_category = request.getParameter("major_category");
		String country = request.getParameter("country");
		String ibo = request.getParameter("ibo");
		String region = request.getParameter("region");
		String supplier_plan = request.getParameter("supplier_plan");
		String grade = request.getParameter("grade");
		String status = request.getParameter("status");
		

		supplierList supplierList = new supplierList(supplier_number,rpt_supplier,child_supplier,origin_indicator,major_category,country,ibo,region,supplier_plan,grade,status);
		SupplierListDAO.insertSupplier(supplierList);
		response.sendRedirect("supplierList");
	}
	

	private void updateSupplier(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String supplier_number = request.getParameter("supplier_number");
		String rpt_supplier = request.getParameter("rpt_supplier");
		String child_supplier = request.getParameter("child_supplier");
		String origin_indicator = request.getParameter("origin_indicator");
		String major_category = request.getParameter("major_category");
		String country = request.getParameter("country");
		String ibo = request.getParameter("ibo");
		String region = request.getParameter("region");
		String supplier_plan = request.getParameter("supplier_plan");
		String grade = request.getParameter("grade");
		String status = request.getParameter("status");

		supplierList supplierList = new supplierList(supplier_number,rpt_supplier,child_supplier,origin_indicator,major_category,country,ibo,region,supplier_plan,grade,status);
		SupplierListDAO.updateSupplier(supplierList);
		response.sendRedirect("supplierList");
	}
	
	private void deleteSupplierList(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String supplier_number = request.getParameter("supplier_number");
		 
	        supplierList supplierList = new supplierList(supplier_number);
	        SupplierListDAO.deleteSupplierList(supplierList);
	        response.sendRedirect("supplierList");
	}
	

}
