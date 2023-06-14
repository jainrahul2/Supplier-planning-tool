package net.codejava.javaee.brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ControlOfficeDAO {
	private static String jdbcURL;
	private static  String jdbcUsername;
	private  static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public ControlOfficeDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		ControlOfficeDAO.jdbcURL = jdbcURL;
		ControlOfficeDAO.jdbcUsername = jdbcUsername;
		ControlOfficeDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertControlOffice(ControlList ControlList) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.spt.control_office_management_master(id,control_office,region,status) VALUES(?, ?, ?,?)";
        connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, ControlList.getId());
		statement.setString(2, ControlList.getControl_office());
		statement.setString(3, ControlList.getRegion());
		statement.setString(4,ControlList.getStatus());
		
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public  List<ControlList> listControlList() throws SQLException {
		List<ControlList> listControlList = new ArrayList<>();
		
		String sql = "SELECT * FROM  SA_ANALYTICS.spt.control_office_management_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String control_office= resultSet.getString("control_office");
			String region= resultSet.getString("region");
			String status =resultSet.getString("status");
			
			ControlList ControlList =  new ControlList(id,control_office,region,status);

			listControlList.add(ControlList);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listControlList;
	}
	
	public boolean deleteControlList(ControlList ControlList) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.spt.control_office_management_master where id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, ControlList.getId());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateControlOffice(ControlList ControlList) throws SQLException {
		String sql = "UPDATE SA_ANALYTICS.spt.control_office_management_master SET control_office=?,region=?,status=?";
		sql += " WHERE id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		
		statement.setString(4, ControlList.getId());
		statement.setString(1, ControlList.getControl_office());
		statement.setString(2, ControlList.getRegion());
		statement.setString(3, ControlList.getStatus());
		
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public ControlList getControlList(String id) throws SQLException {
		ControlList ControlList = null;
		String sql = "SELECT * FROM SA_ANALYTICS.spt.control_office_management_master WHERE id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			id = resultSet.getString("id");
			String control_office= resultSet.getString("control_office");
			String region= resultSet.getString("region");
			String status =resultSet.getString("status");
			
			ControlList =  new ControlList(id,control_office,region,status);
			statement.clearBatch();
			statement.getFetchDirection();
			}
		
		resultSet.close();
		statement.close();
		
		return ControlList;
	}
}

