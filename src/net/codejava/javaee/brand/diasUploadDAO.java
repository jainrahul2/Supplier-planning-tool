


	package net.codejava.javaee.brand;


	import java.io.IOException;
	import java.io.InputStream;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.time.LocalDateTime;
	import java.time.YearMonth;
	import java.time.format.DateTimeFormatter;
	import java.util.ArrayList;
	import java.util.List;

	import javax.faces.model.ResultSetDataModel;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.Part;

	import net.codejava.javaee.brand.CountryListDAO;
	import net.codejava.javaee.brand.FDPList;


	/**
	 * Servlet implementation class FDPUploadDAO
	 */

	public class diasUploadDAO extends HttpServlet {

		static String jdbcURL;
		static  String jdbcUsername;
		static String jdbcPassword;
		private static Connection jdbcConnection;
		
		public diasUploadDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
			diasUploadDAO.jdbcURL = jdbcURL;
			diasUploadDAO.jdbcUsername = jdbcUsername;
			diasUploadDAO.jdbcPassword = jdbcPassword;
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
		
		public String getsqlQuery(String folderName)
		{
			String sql="";
			try 
			{
				if(folderName.contains("Feb")||folderName.contains("Feburary")||folderName.contains("FEBURARY")||folderName.contains("feb")||folderName.contains("FEB")||folderName.contains("feburary"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%FEBURARY%' or filename like '%feb%' or filename like '%Feburary%' or filename like '%FEB%' or filename like '%feburary%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Mar")||folderName.contains("March")||folderName.contains("MARCH")||folderName.contains("mar")||folderName.contains("MAR")||folderName.contains("march"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%MARCH%' or filename like '%MAR%' or filename like '%Mar' or filename like '%march%' or filename like '%mar%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Apr")||folderName.contains("April")||folderName.contains("APRIL")||folderName.contains("apr")||folderName.contains("APR")||folderName.contains("april"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%APRIL%' or filename like '%APR%' or filename like '%April%' or filename like '%april%' or filename like '%apr%'   ORDER BY Id DESC ";	
				else if(folderName.contains("May")||folderName.contains("May")||folderName.contains("MAY")||folderName.contains("MAY")||folderName.contains("MAY")||folderName.contains("may"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%MAY%' or filename like '%MAY%' or filename like '%May%' or filename like '%may%' or filename like '%may%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Jun")||folderName.contains("June")||folderName.contains("JUNE")||folderName.contains("jun")||folderName.contains("JUN")||folderName.contains("june"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%JUNE%' or filename like '%JUN%' or filename like '%June%' or filename like '%june%' or filename like '%jun%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Jul")||folderName.contains("July")||folderName.contains("JULY")||folderName.contains("jul")||folderName.contains("JUL")||folderName.contains("july"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%JULY%' or filename like '%JUL%' or filename like '%July%' or filename like '%july%' or filename like '%jul%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Aug")||folderName.contains("August")||folderName.contains("AUGUST")||folderName.contains("aug")||folderName.contains("AUG")||folderName.contains("august"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%AUGUST%' or filename like '%AUG%' or filename like '%August%' or filename like '%august%' or filename like '%aug%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Sept")||folderName.contains("September")||folderName.contains("SEPTEMBER")||folderName.contains("sept")||folderName.contains("SEP")||folderName.contains("september"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%SEPTEMBER%' or filename like '%SEPT%' or filename like '%September%' or filename like '%september%' or filename like '%sept%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Oct")||folderName.contains("October")||folderName.contains("OCTOBER")||folderName.contains("oct")||folderName.contains("OCT")||folderName.contains("october"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%OCTOBER%' or filename like '%OCT%' or filename like '%October%' or filename like '%october%' or filename like '%oct%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Nov")||folderName.contains("November")||folderName.contains("NOVEMBER")||folderName.contains("nov")||folderName.contains("NOV")||folderName.contains("november"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%NOVEMBER%' or filename like '%NOV%' or filename like '%November%' or filename like '%november%' or filename like '%feburary%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Dec")||folderName.contains("December")||folderName.contains("DECEMBER")||folderName.contains("dec")||folderName.contains("DEC")||folderName.contains("december"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%Dec%' or filename like '%December%' or filename like '%dec%' or filename like '%DEC%' or filename like '%december%'   ORDER BY Id DESC ";	
				else if(folderName.contains("Jan")||folderName.contains("January")||folderName.contains("JANUARY")||folderName.contains("jan")||folderName.contains("JAN")||folderName.contains("january"))
					sql="select top 1 Id from SA_ANALYTICS.spt.dias_upload_master where filename like '%Jan%' or filename like '%January%' or filename like '%JANUARY%' or filename like '%JAN%' or filename like '%january%'   ORDER BY Id DESC ";	
				
				
				
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return sql;
			
			
		}
		
			public String getLastID(String monthbyFileName) throws SQLException
			{
				String sql=getsqlQuery(monthbyFileName);
				String Id="";
		    	String sql1 = sql;
		    	connect();
				Statement statement = jdbcConnection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql1);
				
				
				while (resultSet.next()) {
					Id=resultSet.getString("Id");
				}
				//System.out.print("sql query for delete and last id="+Id+" "+sql1);
				return Id;
				
			}
			
			public String getLastID() throws SQLException
			{
				//String sql=getsqlQuery(monthbyFileName);
				String Id="";
		    	String sql1 = "select top 1 Id from SA_ANALYTICS.spt.dias_upload_master  ORDER BY Id DESC ";
		    	connect();
				Statement statement = jdbcConnection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql1);
				
				
				while (resultSet.next()) {
					Id=resultSet.getString("Id");
				}
				
				return Id;
				
			}
//			
//			
//		public String getFileName() throws SQLException
//		{
//			String id= getLastID();
//			String file_name="";
//			
//	    	String sql = "select  file_name from SA_ANALYTICS.spt.dias_upload_master  where Id="+id;
//	    	connect();
//			Statement statement = jdbcConnection.createStatement();
//			ResultSet resultSet = statement.executeQuery(sql);
//			
//			while (resultSet.next()) {
//				file_name=resultSet.getString("file_name");
//			}
//			
//			
//			return file_name;
//		}
		 
		 public List<DIASList> listDiasList() throws SQLException, ClassNotFoundException
		 {
			 String jdbcURL = "jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433";
	         String dbUser = "sqladmin";
	         String dbPassword = "sqladmin2017";
	         
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
	         	
				List<DIASList> DIASList = new ArrayList<>();
				String sql = "select * from SA_ANALYTICS.spt.dias_upload_master";
				
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql);
				
				while (resultSet.next()) {
					String file_name = resultSet.getString("file_name");
					String file_type= resultSet.getString("file_type");
					String uploaded_by= resultSet.getString("uploaded_by");
					String upload_time= resultSet.getString("upload_time");
					String locking_time= resultSet.getString("locking_time");
					String status =resultSet.getString("status");
					String Id =resultSet.getString("Id");
					DIASList DIASList1 =  new DIASList(file_name,file_type,uploaded_by,upload_time,locking_time,status,Id);
					
					DIASList.add(DIASList1);
					
				}
				resultSet.close();
				statement.close();
				 
				return DIASList;
			}
		 
		/*
		 * public boolean inserFDPList(FDPList fDPList) { }
		 */

	}


