package net.codejava.javaee.brand;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManagementDAO {
	private static String jdbcURL;
	private static  String jdbcUsername;
	private static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public UserManagementDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		UserManagementDAO.jdbcURL = jdbcURL;
		UserManagementDAO.jdbcUsername = jdbcUsername;
		UserManagementDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertUserList(UserManagement UserList) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.dbo.user_management(user_id,first_name,last_name,email_id,contact_number,role,category,supporting,status) VALUES(?, ?, ?,?, ?,?,?,?,?)";
        connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, UserList.getUser_id());
		statement.setString(2, UserList.getFirst_name());
		statement.setString(3, UserList.getLast_name());
		statement.setString(4, UserList.getEmail_id());
		statement.setString(5, UserList.getContact_number());
		statement.setString(6, UserList.getRole());
		statement.setString(7, UserList.getCategory());
		statement.setString(8, UserList.getSupporting());
		statement.setString(9, UserList.getStatus());
		
	
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	public  List<UserManagement> listUserList() throws SQLException {
		List<UserManagement> listUserList = new ArrayList<>();
		
		String sql = "select * from SA_ANALYTICS.dbo.user_management";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String user_id = resultSet.getString("user_id");
			String first_name= resultSet.getString("first_name");
			String last_name= resultSet.getString("last_name");
			String email_id= resultSet.getString("email_id");
			String contact_number= resultSet.getString("contact_number");
			String role= resultSet.getString("role");
			String category= resultSet.getString("category");
			String supporting= resultSet.getString("supporting");
			String status= resultSet.getString("status");
			
			UserManagement UserList =  new UserManagement(user_id,first_name,last_name,email_id,contact_number,role,category,supporting, status);
			
			
			
			listUserList.add(UserList);
			
		}
		
		resultSet.close();
		statement.close();
		
		
		return listUserList;
	
	}
	
	public boolean deleteUserList(UserManagement UserList) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.dbo.user_management where user_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, UserList.getUser_id());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateUser(UserManagement UserList) throws SQLException {
		String sql = "UPDATE SA_ANALYTICS.dbo.user_management SET first_name=?,last_name=?,email_id=?,contact_number=?,role=?,category=?,supporting=?,status=?";
		sql += " WHERE user_id = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		
		statement.setString(1, UserList.getFirst_name());
		statement.setString(2, UserList.getLast_name());
		statement.setString(3, UserList.getEmail_id());
		statement.setString(4, UserList.getContact_number());
		statement.setString(5, UserList.getRole());
		statement.setString(6, UserList.getCategory());
		statement.setString(7, UserList.getSupporting());
		statement.setString(8, UserList.getStatus());
		statement.setString(9, UserList.getUser_id());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public UserManagement getUserList(String user_id) throws SQLException {
		UserManagement UserList = null;
		String sql = "SELECT * FROM SA_ANALYTICS.dbo.user_management WHERE user_id = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, user_id);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			user_id=resultSet.getString("user_id");
			String first_name= resultSet.getString("first_name");
			String last_name= resultSet.getString("last_name");
			String email_id= resultSet.getString("email_id");
			String contact_number= resultSet.getString("contact_number");
			String role= resultSet.getString("role");
			String category= resultSet.getString("category");
			String supporting= resultSet.getString("supporting");
			String status= resultSet.getString("status");
		
			
			 UserList =  new UserManagement(user_id,first_name,last_name,email_id,contact_number,role,category,supporting, status);
			}
		
		resultSet.close();
		statement.close();
		
		return UserList;
	}
}


