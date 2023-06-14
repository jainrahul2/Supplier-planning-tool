package net.codejava.javaee.brand;
 
import java.sql.*;



public class UserSettingDAO {
	
	
	
    
	public boolean changepassword(String email_id,String newpassword) throws SQLException,
            ClassNotFoundException {
    	
    	 String jdbcURL = "jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433";
         String dbUser = "sqladmin";
         String dbPassword = "sqladmin2017";
  
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
         String sql = "update  SA_ANALYTICS.dbo.user_login set password = ? where email_id = ?";
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(2, email_id);
         statement.setString(1, newpassword);
         
         	
         	boolean rowUpdated = statement.executeUpdate() > 0;
 			statement.close();
 			connection.close();
 			return rowUpdated;
        
        
}
	
	 
	 
}