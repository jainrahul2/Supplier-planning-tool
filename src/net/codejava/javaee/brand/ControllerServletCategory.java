package net.codejava.javaee.brand;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.protocol.HTTP;


import com.nimbusds.oauth2.sdk.Request;


@WebServlet(urlPatterns = {"/newcat", "/insertcat","/deletecat","/editcat","/updatecat"})
public class ControllerServletCategory extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static  CategoryListDAO CategoryListDAO;
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
	
		CategoryListDAO= new CategoryListDAO(jdbcURL, jdbcUsername, jdbcPassword);
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
			case "/newcat":
				showNewCategory(request, response);
				break;
			case "/insertcat":
				insertCategory(request, response);
				break;
			case "/deletecat":
				deleteCategoryList(request, response);
				break;
			case "/editcat":
				showEditFormCategory(request, response);
				break;
			case "/updatecat":
				updateCategory(request, response);
				break;
			case "/logout":
				logout1(request, response);
				break;
			default:
				listCategory(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}

	
	private void logout1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("login");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
	}
	
	private void listCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<CategoryList> CategoryList  = CategoryListDAO.listCategoryList();
		request.setAttribute("CategoryList", CategoryList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CategoryList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listCategoryForDropdown(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		List<CategoryList> CategoryListForDropDown  = CategoryListDAO.CategoryListForDropDown();
		request.setAttribute("CategoryListForDropDown", CategoryListForDropDown);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CategoryForm.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void showNewCategory(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CategoryForm.jsp");
		dispatcher.forward(request, response);
	}

	
	
	private void showEditFormCategory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String category_number = request.getParameter("category_number");
        CategoryList category = CategoryListDAO.getCategoryList(category_number);
        RequestDispatcher dispatcher = request.getRequestDispatcher("CategoryForm.jsp");
        request.setAttribute("CategoryList",category);
        dispatcher.forward(request, response);

	}

	
	private void insertCategory(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String category_number = request.getParameter("category_number");
		String major_category = request.getParameter("major_category");
		String sourcing_category = request.getParameter("sourcing_category");
		String sourcing_sub_category = request.getParameter("sourcing_sub_category");
		String classification = request.getParameter("classification");
		String status = request.getParameter("status");
		
		CategoryList CategoryList = new CategoryList(category_number,major_category,sourcing_category,sourcing_sub_category,classification,status);
		CategoryListDAO.insertCategoryList(CategoryList);
		response.sendRedirect("listCategory");
	}

	
	
	private void updateCategory(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String category_number = request.getParameter("category_number");
		String major_category = request.getParameter("major_category");
		String sourcing_category = request.getParameter("sourcing_category");
		String sourcing_sub_category = request.getParameter("sourcing_sub_category");
		String classification = request.getParameter("classification");
		String status = request.getParameter("status");
		

		CategoryList CategoryList = new CategoryList(category_number,major_category,sourcing_category,sourcing_sub_category,classification,status);
		CategoryListDAO.updateCategory(CategoryList);
		response.sendRedirect("listCategory");
	}
	
	
	private void deleteCategoryList(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 String category_number = request.getParameter("category_number");
		 
	        CategoryList Categorylist = new CategoryList(category_number);
	        CategoryListDAO.deleteCategoryList(Categorylist);
	        response.sendRedirect("listCategory");
	}
}
