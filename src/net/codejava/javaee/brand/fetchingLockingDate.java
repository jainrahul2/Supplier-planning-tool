package net.codejava.javaee.brand;

import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;  
public class fetchingLockingDate { 

	static String Month;
	
	public String LockingDate2() throws SQLException {
		
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		   DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM");
		   DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy");
		   LocalDateTime now = LocalDateTime.now();
		 
			String year=dtf3.format(now);
			switch (dtf2.format(now)) {
			case "01":
				Month="January";
				break; 
			case "02":
				Month="feb";
				break;
			case "03":
				Month="mar";
				break;
			case "04":
				Month="april";
				break;
			case "05":
				Month="may";
				break;
			case "06":
				Month="june";
				break;
			case "07":
				Month="july";
				break;
			case "08":
				Month="august";
				break;
			case "09":
				Month="september";
				break;
			case "10":
				Month="october";
				break;
			case "11":
				Month="november";
				break;
			case "12":
				Month="december";
				break;
			default :
				Month="January";
				break;
			}
		String LockingDate=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 Connection con = DriverManager.getConnection(
				"jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
		
		String sql = "SELECT * from SA_ANALYTICS.spt.locking_date_management_master  WHERE year = "+year;
		Statement statement = con.createStatement();
		
		
		ResultSet resultSet = statement.executeQuery(sql);
		if(resultSet.next()) {
			
			
			LockingDate = resultSet.getString(Month);
			
			
			}
		return LockingDate;
	}
	public boolean lockingDateChecker()
	{
		 boolean flag=false;
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		 LocalDateTime now = LocalDateTime.now();
		 String SystemDate=dtf.format(now);
		 String lockingDate=null;
		try {
			lockingDate = LockingDate2();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		if (SystemDate.compareTo(lockingDate) < 0||(SystemDate.compareTo(lockingDate) == 0)) {
           
            flag=true;
           
        }
		else if (SystemDate.compareTo(lockingDate) > 0)
		{
	            
	            flag=false;
	           
	    } 
		 
	        
		
		return flag;
		
		
	}
//	public static void main(String args[])
//	{
//		 fetchingLockingDate fd= new fetchingLockingDate();
//		 fd.lockingDateChecker();
//		 
//	}
   
}  

