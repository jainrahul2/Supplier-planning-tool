package net.codejava.javaee.brand;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;



public class ControllerServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static  BrandListDAO BrandListDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		
		BrandListDAO= new BrandListDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/new":
				showNewBrand(request, response);
				break;      
			case "/insert":
				insertBrand(request, response);
				break;
			case "/delete":
				deleteBrandList(request, response);
				break;
			case "/edit":
				showEditFormBrand(request, response);
				break;
			case "/update":
				updateBrand(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			default :
				listBrand(request, response);
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
	
	

	
	private void listBrand(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<BrandList> BrandList  = BrandListDAO.listBrandList();
		request.setAttribute("BrandList", BrandList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("BrandList.jsp");
		dispatcher.forward(request, response);
		
		
	}	
	private void showNewBrand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("BrandForm.jsp");
		dispatcher.forward(request, response);
		
	}

	
	private void showEditFormBrand(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String brand_number = request.getParameter("brand_number");
        BrandList brand = BrandListDAO.getBrandList(brand_number);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("BrandForm.jsp");
        
        request.setAttribute("BrandList", brand);
        
        dispatcher.forward(request, response);

	}

	
	private void insertBrand(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String brand_number = request.getParameter("brand_number");
		String rpt_brand = request.getParameter("rpt_brand");
		String child_brand = request.getParameter("child_brand");
		String brand_type = request.getParameter("brand_type");
		String status = request.getParameter("status");
		

		BrandList BrandList = new BrandList(brand_number,rpt_brand,child_brand,brand_type,status);
		BrandListDAO.insertBrandList(BrandList);
		response.sendRedirect("list");
	}


	
	private void updateBrand(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String brand_number = request.getParameter("brand_number");
		String rpt_brand = request.getParameter("rpt_brand");
		String child_brand = request.getParameter("child_brand");
		String brand_type = request.getParameter("brand_type");
		String status = request.getParameter("status");

		BrandList BrandList = new BrandList(brand_number,rpt_brand,child_brand,brand_type,status);
		BrandListDAO.updateBrand(BrandList);
		response.sendRedirect("list");
	}
	 
	private void deleteBrandList(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String brand_number = request.getParameter("brand_number");
		 
	        BrandList BrandList = new BrandList(brand_number);
	        BrandListDAO.deleteBrandList(BrandList);
	        response.sendRedirect("list");
	}

}
