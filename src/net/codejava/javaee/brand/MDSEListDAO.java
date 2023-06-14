package net.codejava.javaee.brand;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import net.codejava.javaee.brand.BrandList;

public class MDSEListDAO {
	private static String jdbcURL;
	private static  String jdbcUsername;
	private  static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public MDSEListDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		MDSEListDAO.jdbcURL = jdbcURL;
		MDSEListDAO.jdbcUsername = jdbcUsername;
		MDSEListDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertMDSEList(MDSEList MDSEList) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.spt.mdse_master(code,division_number,division_name,entity_number,entity_name,subdivison_number,subdivision_name,cls,status) VALUES(?, ?, ?,?, ?,?,?,?,?)";
        connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, MDSEList.getCode());
		statement.setString(2, MDSEList.getDivision_number());
		statement.setString(3, MDSEList.getDivision_name());
		statement.setString(4, MDSEList.getEntity_number());
		statement.setString(5, MDSEList.getEntity_name());
		statement.setString(6, MDSEList.getSubdivison_number());
		statement.setString(7, MDSEList.getSubdivision_name());
		statement.setString(8, MDSEList.getCls());
		statement.setString(9, MDSEList.getStatus());
		
		
	
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	public  List<MDSEList> listMDSEList() throws SQLException {
		List<MDSEList> listMDSEList = new ArrayList<>();
		
		String sql = "select * from SA_ANALYTICS.spt.mdse_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String code = resultSet.getString("code");
			String division_number= resultSet.getString("division_number");
			String division_name= resultSet.getString("division_name");
			String entity_number= resultSet.getString("entity_number");
			String entity_name = resultSet.getString("entity_name");
			String subdivison_number= resultSet.getString("subdivison_number");
			String subdivision_name= resultSet.getString("subdivision_name");
			String cls= resultSet.getString("cls");
			String status= resultSet.getString("status");
			
			MDSEList MDSEList =  new MDSEList(code,division_number,division_name,entity_number,entity_name,subdivison_number,subdivision_name,cls,status);
			
			
			
			listMDSEList.add(MDSEList);
			
		}
		
		resultSet.close();
		statement.close();
		
		
		return listMDSEList;
	
	}
	
	public boolean deleteMDSEList(MDSEList MDSEList) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.spt.mdse_master where code = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, MDSEList.getCode());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateMDSE(MDSEList MDSEList) throws SQLException {
		String sql = "UPDATE SA_ANALYTICS.spt.mdse_master SET division_number=?,division_name=?,entity_number=?,entity_name=?,subdivison_number=?,subdivision_name=?,cls=?,status=?";
		sql += " WHERE code = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, MDSEList.getDivision_number());
		statement.setString(2, MDSEList.getDivision_name());
		statement.setString(3, MDSEList.getEntity_number());
		statement.setString(4, MDSEList.getEntity_name());
		statement.setString(5, MDSEList.getSubdivison_number());
		statement.setString(6, MDSEList.getSubdivision_name());
		statement.setString(7, MDSEList.getCls());
		statement.setString(8, MDSEList.getStatus());
		statement.setString(9, MDSEList.getCode());
		
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public MDSEList getMDSEList(String code) throws SQLException {
		MDSEList MDSEList = null;
		String sql = "SELECT * FROM SA_ANALYTICS.spt.mdse_master WHERE code = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, code);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			code=resultSet.getString("code");
			
			String division_number= resultSet.getString("division_number");
			String division_name= resultSet.getString("division_name");
			String entity_number= resultSet.getString("entity_number");
			String entity_name = resultSet.getString("entity_name");
			String subdivison_number= resultSet.getString("subdivison_number");
			String subdivision_name= resultSet.getString("subdivision_name");
			String cls= resultSet.getString("cls");
			String status= resultSet.getString("status");
		
			MDSEList  =  new MDSEList(code,division_number,division_name,entity_number,entity_name,subdivison_number,subdivision_name,cls,status);
			
			}
		
		resultSet.close();
		statement.close();
		
		return MDSEList;
	}
}

