package net.codejava.javaee.brand;

import java.io.FileFilter;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.apache.tomcat.jni.File;

public class uploadPath {

	public String getUploadPath()
	{
			String Month="";
			
			String folderName="resourcesDIAS\\";
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
				Month="feburary";
				break;
			case "03":
				Month="march";
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
		
		return  folderName+Month;
	}
	public  String[] getid()
	{
		String id="";
		String month="";
		String[] idMonth= new String[2];
		 try{
	            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            
	            Connection con = (Connection) DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
	            String sql="select top 1 id,DATEPART(month, added_date) from SA_ANALYTICS.SPT.DIAS_MASTER where id=id ORDER BY id DESC";
	            
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				
				while (resultSet.next()) {
					id=resultSet.getString(1);
					month=resultSet.getString(2);
					
				}
	            idMonth[0]=id;
	            idMonth[1]=month;
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		return idMonth;
	}
	
	
}
