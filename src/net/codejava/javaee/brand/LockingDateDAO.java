package net.codejava.javaee.brand;

import java.io.Console;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LockingDateDAO {
	static String jdbcURL;
	static  String jdbcUsername;
	static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public LockingDateDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		LockingDateDAO.jdbcURL = jdbcURL;
		LockingDateDAO.jdbcUsername = jdbcUsername;
		LockingDateDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertLockingDate(LockingDate LockingDate) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.spt.locking_date_management_master(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, LockingDate.getYear());
		statement.setString(2, LockingDate.getFeb());
		statement.setString(3, LockingDate.getMar());
		statement.setString(4,LockingDate.getApril());
		statement.setString(5,LockingDate.getMay());
		statement.setString(6,LockingDate.getJune());
		statement.setString(7,LockingDate.getJuly());
		statement.setString(8,LockingDate.getAugust());
		statement.setString(9,LockingDate.getSeptember());
		statement.setString(10,LockingDate.getOctober());
		statement.setString(11,LockingDate.getNovember());
		statement.setString(12,LockingDate.getDecember());
		statement.setString(13,LockingDate.getJanuary());
		statement.setString(14,LockingDate.getUpdated_by());
		statement.setString(15,LockingDate.getUpdated_on());
		
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public  List<LockingDate> listLockingDate() throws SQLException {
		List<LockingDate> listLockingDate = new ArrayList<>();
		
		String sql = "SELECT * FROM  SA_ANALYTICS.spt.locking_date_management_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String year = resultSet.getString("year");
			String feb = resultSet.getString("feb");
			String mar = resultSet.getString("mar");
			String april = resultSet.getString("april");
			String may = resultSet.getString("may");
			String june = resultSet.getString("june");
			String july = resultSet.getString("july");
			String august = resultSet.getString("august");
			String september = resultSet.getString("september");
			String october = resultSet.getString("october");
			String november = resultSet.getString("november");
			String december = resultSet.getString("december");
			String january = resultSet.getString("january");
			String updated_by = resultSet.getString("updated_by");
			String updated_on = resultSet.getString("updated_on");
			String timevalue=   resultSet.getString("timevalue");
			
			LockingDate LockingDate =  new LockingDate(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on,timevalue);

			listLockingDate.add(LockingDate);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listLockingDate;
	}
	
	public boolean deleteLockingDate(LockingDate LockingDate) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.spt.locking_date_management_master WHERE year = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, LockingDate.getYear());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	
	public boolean updatelocktime(LockingDate LockingDate) throws SQLException
	{
		
		String sql="UPDATE SA_ANALYTICS.spt.locking_date_management_master SET timevalue=?";
				
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, LockingDate.getTimevalue());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		
		disconnect();
		
		return rowUpdated;
	}
	
	public boolean updateLockingDate(LockingDate LockingDate) throws SQLException {
		String sql = " UPDATE SA_ANALYTICS.spt.locking_date_management_master SET feb=?,mar=?,april=?,may=?,june=?,july=?,august=?,september=?,october=?,november=?,december=?,january=?,updated_by=?,updated_on=?";
		sql += " WHERE year = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		
		
		statement.setString(1, LockingDate.getFeb());
		statement.setString(2, LockingDate.getMar());
		statement.setString(3,LockingDate.getApril());
		statement.setString(4,LockingDate.getMay());
		statement.setString(5,LockingDate.getJune());
		statement.setString(6,LockingDate.getJuly());
		statement.setString(7,LockingDate.getAugust());
		statement.setString(8,LockingDate.getSeptember());
		statement.setString(9,LockingDate.getOctober());
		statement.setString(10,LockingDate.getNovember());
		statement.setString(11,LockingDate.getDecember());
		statement.setString(12,LockingDate.getJanuary());
		statement.setString(13,LockingDate.getUpdated_by());
		statement.setString(14,LockingDate.getUpdated_on());
		statement.setString(15, LockingDate.getYear());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public LockingDate getLockingDate(String year) throws SQLException {
		LockingDate LockingDate = null;
		String sql = "SELECT *  from SA_ANALYTICS.spt.locking_date_management_master WHERE year = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, year);
		
		ResultSet resultSet = statement.executeQuery();
		
		if (resultSet.next()) {
			 year = resultSet.getString("year");
			String feb = resultSet.getString("feb");
			String mar = resultSet.getString("mar");
			String april = resultSet.getString("april");
			String may = resultSet.getString("may");
			String june = resultSet.getString("june");
			String july = resultSet.getString("july");
			String august = resultSet.getString("august");
			String september = resultSet.getString("september");
			String october = resultSet.getString("october");
			String november = resultSet.getString("november");
			String december = resultSet.getString("december");
			String january = resultSet.getString("january");
			String updated_by = resultSet.getString("updated_by");
			String updated_on = resultSet.getString("updated_on");
			String timevalue=resultSet.getString("timevalue");
			LockingDate =  new LockingDate(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on,timevalue);

			
			}
		
		resultSet.close();
		statement.close();
		
		return LockingDate;
	}
}

