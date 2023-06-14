package net.codejava.javaee.brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CategoryListDAO {
	static String jdbcURL;
	static  String jdbcUsername;
	static String jdbcPassword;
	static Connection jdbcConnection;
	
	public CategoryListDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		CategoryListDAO.jdbcURL = jdbcURL;
		CategoryListDAO.jdbcUsername = jdbcUsername;
		CategoryListDAO.jdbcPassword = jdbcPassword;
	}
	
	protected static void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	protected static void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public boolean insertCategoryList(CategoryList CategoryList) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.spt.category_master(category_number,major_category,sourcing_category,sourcing_sub_category,classification,status) VALUES(?, ?, ?,?, ?,?)";
        connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		int s=Integer.parseInt(getLastCategoryID())+1;
		String cat_number=String.valueOf(s);
		statement.setString(1,cat_number);
		
		statement.setString(2, CategoryList.getMajor_category());
		statement.setString(3, CategoryList.getSourcing_category());
		statement.setString(4, CategoryList.getSourcing_sub_category());
		statement.setString(5, CategoryList.getClassification());
		statement.setString(6,CategoryList.getStatus());
		
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public String getLastCategoryID() throws SQLException
	{
		String category_id="";
		
		String sql = "select top 1 category_number from SA_ANALYTICS.spt.category_master  ORDER BY category_number DESC ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			category_id=resultSet.getString("category_number");
		}
		
		return category_id;
	}
	
	 public String getLastId() throws SQLException
		{
			String Id="";
			
			String sql = "select top 1 Id from SA_ANALYTICS.spt.fdp_file_upload_master  ORDER BY Id DESC ";
			connect();
			
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			
			while (resultSet.next()) {
				Id=resultSet.getString("Id");
			}
			
			return Id;
		}
	
	public  List<CategoryList> listCategoryList() throws SQLException {
		List<CategoryList> listCategoryList = new ArrayList<>();
		
		String sql = "select * from SA_ANALYTICS.spt.category_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		
		
		while (resultSet.next()) {
			String category_number = resultSet.getString("category_number");
			String major_category= resultSet.getString("major_category");
			String sourcing_category= resultSet.getString("sourcing_category");
			String sourcing_sub_category= resultSet.getString("sourcing_sub_category");
			String classification= resultSet.getString("classification");
			String status =resultSet.getString("status");
			
			CategoryList CategoryList =  new CategoryList(category_number,major_category,sourcing_category,sourcing_sub_category,classification,status);

			listCategoryList.add(CategoryList);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listCategoryList;
	}
	public  List<CategoryList> CategoryListForDropDown() throws SQLException {
		List<CategoryList> CategoryListForDropDown = new ArrayList<>();
		
		String sql = "select distinct major_category,sourcing_category,sourcing_sub_category,classification,status from SA_ANALYTICS.spt.category_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		
		
		while (resultSet.next()) {
			
			String major_category= resultSet.getString("major_category");
			String sourcing_category= resultSet.getString("sourcing_category");
			String sourcing_sub_category= resultSet.getString("sourcing_sub_category");
			String classification= resultSet.getString("classification");
			String status =resultSet.getString("status");
			
			CategoryList CategoryList =  new CategoryList(major_category,sourcing_category,sourcing_sub_category,classification,status);

			CategoryListForDropDown.add(CategoryList);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return CategoryListForDropDown;
	}
	
	public boolean deleteCategoryList(CategoryList CategoryList) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.spt.category_master where category_number = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, CategoryList.getCategory_number());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateCategory(CategoryList CategoryList) throws SQLException {
		String sql = "UPDATE SA_ANALYTICS.spt.category_master SET major_category=?,sourcing_category=?,sourcing_sub_category=?,classification=?,status=?";
		sql += " WHERE category_number = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		
		statement.setString(1, CategoryList.getMajor_category());
		statement.setString(2, CategoryList.getSourcing_category());
		statement.setString(3, CategoryList.getSourcing_sub_category());
		statement.setString(4, CategoryList.getClassification());
		statement.setString(5,CategoryList.getStatus());
		statement.setString(6, CategoryList.getCategory_number());
		
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public CategoryList getCategoryList(String category_number) throws SQLException {
		CategoryList CategoryList = null;
		String sql = "SELECT * FROM SA_ANALYTICS.spt.category_master WHERE category_number = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, category_number);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			category_number = resultSet.getString("category_number");
			String major_category= resultSet.getString("major_category");
			String sourcing_category= resultSet.getString("sourcing_category");
			String sourcing_sub_category= resultSet.getString("sourcing_sub_category");
			String classification= resultSet.getString("classification");
			String status =resultSet.getString("status");
			
			 CategoryList =  new CategoryList(category_number,major_category,sourcing_category,sourcing_sub_category,classification,status);
			statement.clearBatch();
			statement.getFetchDirection();
			}
		
		resultSet.close();
		statement.close();
		
		return CategoryList;
	}
}

