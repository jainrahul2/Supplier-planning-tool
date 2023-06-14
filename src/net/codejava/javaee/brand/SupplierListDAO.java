package net.codejava.javaee.brand;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class SupplierListDAO {
	private static String jdbcURL;
	private static  String jdbcUsername;
	private  static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public SupplierListDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		SupplierListDAO.jdbcURL = jdbcURL;
		SupplierListDAO.jdbcUsername = jdbcUsername;
		SupplierListDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertSupplier(supplierList supplierList) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.spt.supplier_master(supplier_number,rpt_supplier,child_supplier,origin_indicator,major_category,country,ibo,region,supplier_plan,grade,status) VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?, ?)";
        connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, supplierList.getSupplier_number());
		statement.setString(2, supplierList.getRpt_supplier());
		statement.setString(3, supplierList.getChild_supplier());
		statement.setString(4, supplierList.getOrigin_indicator());
		statement.setString(5, supplierList.getMajor_category());
		statement.setString(6, supplierList.getCountry());
		statement.setString(7, supplierList.getIbo());
		statement.setString(8, supplierList.getRegion());
		statement.setString(9, supplierList.getSupplier_plan());
		statement.setString(10, supplierList.getGrade());
		statement.setString(11, supplierList.getStatus());
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public List<supplierList> listSupplierList() throws SQLException {
		List<supplierList> listSupplierList = new ArrayList<>();
		
		String sql = "select * from SA_ANALYTICS.spt.supplier_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String supplier_number = resultSet.getString("supplier_number");
			
			String rpt_supplier= resultSet.getString("rpt_supplier");
			String child_supplier= resultSet.getString("child_supplier");
			String origin_indicator= resultSet.getString("origin_indicator");
			String major_category= resultSet.getString("major_category");
			String country= resultSet.getString("country");
			String ibo= resultSet.getString("ibo");
			String region= resultSet.getString("region");
			String supplier_plan= resultSet.getString("supplier_plan");
			String grade= resultSet.getString("grade");
			String status= resultSet.getString("status");
			
			supplierList supplierList = new supplierList(supplier_number,rpt_supplier,child_supplier,origin_indicator,major_category,country,ibo,region,supplier_plan,grade,status);
			listSupplierList.add(supplierList);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
	
	public boolean deleteSupplierList(supplierList supplierList) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.spt.supplier_master where supplier_number = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, supplierList.getSupplier_number());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateSupplier(supplierList supplierList) throws SQLException {
		String sql = "UPDATE SA_ANALYTICS.spt.supplier_master SET rpt_supplier=?,child_supplier=?,origin_indicator=?,major_category=?,country=?,ibo=?,region=?,supplier_plan=?,grade=?,status=?";
		sql += " WHERE supplier_number = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, supplierList.getRpt_supplier());
		statement.setString(2, supplierList.getChild_supplier());
		statement.setString(3, supplierList.getOrigin_indicator());
		statement.setString(4, supplierList.getMajor_category());
		statement.setString(5, supplierList.getCountry());
		statement.setString(6, supplierList.getIbo());
		statement.setString(7, supplierList.getRegion());
		statement.setString(8, supplierList.getSupplier_plan());
		statement.setString(9, supplierList.getGrade());
		statement.setString(10, supplierList.getStatus());
		statement.setString(11, supplierList.getSupplier_number());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public supplierList getSupplierList(String supplier_number) throws SQLException {
		supplierList supplierList = null;
		String sql = "SELECT * FROM SA_ANALYTICS.spt.supplier_master WHERE supplier_number = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, supplier_number);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) 
		{
			supplier_number=resultSet.getString("supplier_number");
			String rpt_supplier= resultSet.getString("rpt_supplier");
			String child_supplier= resultSet.getString("child_supplier");
			String origin_indicator= resultSet.getString("origin_indicator");
			String major_category= resultSet.getString("major_category");
			String country= resultSet.getString("country");
			String ibo= resultSet.getString("ibo");
			String region= resultSet.getString("region");
			String supplier_plan= resultSet.getString("supplier_plan");
			String grade= resultSet.getString("grade");
			String status= resultSet.getString("status");
			
			supplierList =  new supplierList(supplier_number,rpt_supplier,child_supplier,origin_indicator,major_category,country,ibo,region,supplier_plan,grade,status);
		}
		
		resultSet.close();
		statement.close();
		
		return supplierList;
	}
}
