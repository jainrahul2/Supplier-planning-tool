package net.codejava.javaee.brand;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.codejava.javaee.brand.BrandList;

public class BrandListDAO {
	private static String jdbcURL;
	private static  String jdbcUsername;
	private  static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public BrandListDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		BrandListDAO.jdbcURL = jdbcURL;
		BrandListDAO.jdbcUsername = jdbcUsername;
		BrandListDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertBrandList(BrandList BrandList) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.spt.brand_master(brand_number,rpt_brand,child_brand,brand_type,status) VALUES(?, ?, ?,?, ?)";
        connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, BrandList.getBrand_number());
		statement.setString(2, BrandList.getRpt_brand());
		statement.setString(3, BrandList.getChild_brand());
		statement.setString(4, BrandList.getBrand_type());
		statement.setString(5, BrandList.getStatus());
	
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	public  List<BrandList> listBrandList() throws SQLException {
		List<BrandList> listBrandList = new ArrayList<>();
		
		String sql = "select * from SA_ANALYTICS.spt.brand_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String brand_number = resultSet.getString("brand_number");
			String rpt_brand= resultSet.getString("rpt_brand");
			String child_brand= resultSet.getString("child_brand");
			String brand_type= resultSet.getString("brand_type");
			String status= resultSet.getString("status");
			
			BrandList BrandList =  new BrandList(brand_number,rpt_brand,child_brand,brand_type,status);
			
			
			
			listBrandList.add(BrandList);
			
		}
		
		resultSet.close();
		statement.close();
		
		
		return listBrandList;
	
	}
	
	public boolean deleteBrandList(BrandList BrandList) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.spt.brand_master where brand_number = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, BrandList.getBrand_number());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateBrand(BrandList BrandList) throws SQLException {
		String sql = "UPDATE SA_ANALYTICS.spt.brand_master SET rpt_brand=?,child_brand=?,brand_type=?,status=?";
		sql += " WHERE brand_number = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, BrandList.getRpt_brand());
		statement.setString(2, BrandList.getChild_brand());
		statement.setString(3, BrandList.getBrand_type());
		statement.setString(4, BrandList.getStatus());
		statement.setString(5, BrandList.getBrand_number());
		
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public BrandList getBrandList(String brand_number) throws SQLException {
		BrandList BrandList = null;
		String sql = "SELECT * FROM SA_ANALYTICS.spt.brand_master WHERE brand_number = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, brand_number);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			brand_number=resultSet.getString("brand_number");
			String rpt_brand= resultSet.getString("rpt_brand");
			String child_brand= resultSet.getString("child_brand");
			String brand_type= resultSet.getString("brand_type");
			String status= resultSet.getString("status");
		
			
			BrandList =  new BrandList(brand_number,rpt_brand,child_brand,brand_type,status);
			}
		
		resultSet.close();
		statement.close();
		
		return BrandList;
	}
}

