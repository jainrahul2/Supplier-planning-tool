package net.codejava.javaee.brand;
 
import java.sql.*;

import javax.jms.Session;

import org.apache.commons.lang.RandomStringUtils;
 
public class LoginDAO {
	
	public String resetCustomerPassword(String email) {
	    //Login Login = LoginDAO.findByEmail(email);
	     
	    String randomPassword = RandomStringUtils.randomAlphanumeric(10);
	     
	    //Login.setPassword(randomPassword);
	    //LoginDAO.update(Login);
	     
	    return randomPassword;
	}
	
    
	public Login checkLogin(String email_id, String password) throws SQLException,
            ClassNotFoundException {
    	
    	 String jdbcURL = "jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433";
         String dbUser = "sqladmin";
         String dbPassword = "sqladmin2017";
         
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
         String sql = "SELECT * FROM SA_ANALYTICS.dbo.user_login WHERE email_id = ? and password = ?";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1, email_id);
         statement.setString(2, password);
         
         ResultSet result = statement.executeQuery();
        
 
        Login login = null;
 
        if (result.next()) {
        	login = new Login();
        	login.setFirst_name(result.getString("first_name"));
        	login.setEmail_id("email_id");
        	login.setLast_name(result.getString("last_name"));
        	
        	
    }
        connection.close();
        return login;
        
}
 
}