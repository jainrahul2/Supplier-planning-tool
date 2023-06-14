package net.codejava.javaee.brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class FiscalCalendarDAO {
	private static String jdbcURL;
	private static  String jdbcUsername;
	private  static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public FiscalCalendarDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		FiscalCalendarDAO.jdbcURL = jdbcURL;
		FiscalCalendarDAO.jdbcUsername = jdbcUsername;
		FiscalCalendarDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertFiscalCalendar(FiscalCalendar FiscalCalendar) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.dbo.locking_date_management(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, FiscalCalendar.getYear());
		statement.setString(2, FiscalCalendar.getFeb());
		statement.setString(3, FiscalCalendar.getMar());
		statement.setString(4,FiscalCalendar.getApril());
		statement.setString(5,FiscalCalendar.getMay());
		statement.setString(6,FiscalCalendar.getJune());
		statement.setString(7,FiscalCalendar.getJuly());
		statement.setString(8,FiscalCalendar.getAugust());
		statement.setString(9,FiscalCalendar.getSeptember());
		statement.setString(10,FiscalCalendar.getOctober());
		statement.setString(11,FiscalCalendar.getNovember());
		statement.setString(12,FiscalCalendar.getDecember());
		statement.setString(13,FiscalCalendar.getJanuary());
		statement.setString(14,FiscalCalendar.getUpdated_by());
		statement.setString(15,FiscalCalendar.getUpdated_on());
		
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public  List<FiscalCalendar> listFiscalCalendar() throws SQLException {
		List<FiscalCalendar> listFiscalCalendar = new ArrayList<>();
		
		String sql = "SELECT * FROM  SA_ANALYTICS.dbo.locking_date_management";
		
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
			
			FiscalCalendar FiscalCalendar =  new FiscalCalendar(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on);

			listFiscalCalendar.add(FiscalCalendar);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listFiscalCalendar;
	}
	
	public boolean deleteFiscalCalendar(FiscalCalendar FiscalCalendar) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.dbo.locking_date_management WHERE year = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, FiscalCalendar.getYear());
		
		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	public boolean updateFiscalCalendar(FiscalCalendar FiscalCalendar) throws SQLException {
		String sql = " UPDATE SA_ANALYTICS.dbo.locking_date_management SET feb=?,mar=?,april=?,may=?,june=?,july=?,august=?,september=?,october=?,november=?,december=?,january=?,updated_by=?,updated_on=?";
		sql += " WHERE year = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		
		
		statement.setString(1, FiscalCalendar.getFeb());
		statement.setString(2, FiscalCalendar.getMar());
		statement.setString(3,FiscalCalendar.getApril());
		statement.setString(4,FiscalCalendar.getMay());
		statement.setString(5,FiscalCalendar.getJune());
		statement.setString(6,FiscalCalendar.getJuly());
		statement.setString(7,FiscalCalendar.getAugust());
		statement.setString(8,FiscalCalendar.getSeptember());
		statement.setString(9,FiscalCalendar.getOctober());
		statement.setString(10,FiscalCalendar.getNovember());
		statement.setString(11,FiscalCalendar.getDecember());
		statement.setString(12,FiscalCalendar.getJanuary());
		statement.setString(13,FiscalCalendar.getUpdated_by());
		statement.setString(14,FiscalCalendar.getUpdated_on());
		statement.setString(15, FiscalCalendar.getYear());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	public FiscalCalendar getFiscalCalendar(String year) throws SQLException {
		FiscalCalendar FiscalCalendar = null;
		String sql = "SELECT *  from SA_ANALYTICS.dbo.locking_date_management WHERE year = ?";
		
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
			
			FiscalCalendar =  new FiscalCalendar(year,feb,mar,april,may,june,july,august,september,october,november,december,january,updated_by,updated_on);

			
			}
		
		resultSet.close();
		statement.close();
		
		return FiscalCalendar;
	}
}

