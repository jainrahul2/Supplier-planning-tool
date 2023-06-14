package net.codejava.javaee.brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.management.j2ee.statistics.JDBCConnectionPoolStats;
import javax.management.j2ee.statistics.JDBCStats;

import org.hibernate.criterion.RowCountProjection;


public class CountryListDAO {
	private static String jdbcURL;
	private static  String jdbcUsername;
	private  static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public CountryListDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		CountryListDAO.jdbcURL = jdbcURL;
		CountryListDAO.jdbcUsername = jdbcUsername;
		CountryListDAO.jdbcPassword = jdbcPassword;
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
	
	public boolean insertCountry(CountryList CountryList) throws SQLException {
		String sql = "INSERT INTO SA_ANALYTICS.spt.country_management_master(country_code,country_name,status) VALUES(?, ?, ?)";
        connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, CountryList.getCountry_code());
		statement.setString(2, CountryList.getCountry_name());
		
		statement.setString(3, CountryList.getStatus());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowInserted;
	}
	
	public  List<CountryList> listCountryList() throws SQLException {
		List<CountryList> listCountryList = new ArrayList<>();
		
		String sql = "SELECT * FROM  SA_ANALYTICS.spt.country_management_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			String country_code = resultSet.getString("country_code");
			String country_name= resultSet.getString("country_name");
			String status =resultSet.getString("status");
			
			CountryList CountryList =  new CountryList(country_code,country_name,status);

			listCountryList.add(CountryList);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listCountryList;
	}
	
	public boolean deleteCountry(CountryList CountryList) throws SQLException {
		String sql = "DELETE FROM SA_ANALYTICS.spt.country_management_master where country_code = ?";
		
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		statement.setString(1, CountryList.getCountry_code());
	
		boolean rowDeleted = statement.executeUpdate() > 0;
		
		
		statement.close();
		disconnect();
		return rowDeleted;		
	}
	
	
	public boolean updateCountry(CountryList CountryList) throws SQLException {
		String sql = "UPDATE SA_ANALYTICS.spt.country_management_master SET country_name=?,status=?";
		sql += " WHERE country_code = ?";
		connect();
		
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		
		
		statement.setString(3, CountryList.getCountry_code());
		statement.setString(1, CountryList.getCountry_name());
		
		statement.setString(2, CountryList.getStatus());
		
		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		disconnect();
		return rowUpdated;		
	}
	
	
	
	public CountryList getCountryList(String country_code) throws SQLException {
		CountryList CountryList = null;
		String sql = "SELECT * FROM SA_ANALYTICS.spt.country_management_master WHERE country_code = ?";
	
		connect();
		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, country_code);
		
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			country_code = resultSet.getString("country_code");
			String country_name= resultSet.getString("country_name");
			
			String status =resultSet.getString("status");
					
			CountryList =  new CountryList(country_code,country_name,status);
			statement.clearBatch();
			statement.getFetchDirection();
			}
		
		resultSet.close();
		statement.close();
		
		return CountryList;
	}
}

