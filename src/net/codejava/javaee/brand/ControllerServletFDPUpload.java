//package net.codejava.javaee.brand;
// 
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.time.YearMonth;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.sun.java.swing.plaf.windows.*;
// 
//@WebServlet(urlPatterns = {"/fdpupload"})
//@MultipartConfig(maxFileSize = 20177215)    // upload file's size up to 16MB
//public class ControllerServletFDPUpload extends HttpServlet {
//     
//    
//	private static final long serialVersionUID = 1L;
//	
//	private static  FDPUploadDAO FDPUploadDAO;
//	public void init() {
//		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
//		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
//		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
//
//		
//		FDPUploadDAO= new FDPUploadDAO(jdbcURL, jdbcUsername, jdbcPassword);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//	
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String action = request.getServletPath();
//
//		
//		try {
//			switch (action) {
//			case "/fdpupload":
//
//			 	int s=0;			
//		        s = Integer.parseInt(FDPUploadDAO.getLastID())+1;
//				String Id=String.valueOf(s);
//			 	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		    	LocalDateTime now = LocalDateTime.now();
//		    	YearMonth thisMonth= YearMonth.now();
//		    	String month =thisMonth.toString();
//		    	LockingDate lockingDate=null;
//		    	String message = null;
//		    	Login login=null;
//		    	
//		    	switch (month) {
//				case "JAN":
//					month=lockingDate.getJanuary();
//				break;
//				case "FEB":
//					month=lockingDate.getFeb();
//				break;
//				
//				case "MAR":
//					month=lockingDate.getMar();
//				break;
//				case "APR":
//					month=lockingDate.getApril();
//				break;
//				case "MAY":
//					month=lockingDate.getMay();
//				break;
//				case "JUN":
//					month=lockingDate.getJune();
//				break;
//				case "JUL":
//					month=lockingDate.getJuly();
//				break;
//				case "AUG":
//					month=lockingDate.getAugust();
//				break;
//				case "SEP":
//					month=lockingDate.getSeptember();
//				break;
//				case "OCT":
//					month=lockingDate.getOctober();
//				break;
//				case "NOV":
//					month=lockingDate.getNovember();
//				break;
//				case "DEC":
//					month=lockingDate.getDecember();	
//				break;
//				default:
//					month=dtf.format(now);
//					break;
//				}
//		    	Connection conn = null;
//				 String dbURL = "jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433";
//			     String dbUser = "sqladmin";
//			     String dbPass = "sqladmin2017";
//			     DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//			     conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
//				
//				
//				
//			 	String sql = "INSERT INTO SA_ANALYTICS.spt.fdp_file_upload_master (file_name,file_type,uploaded_by,upload_time,locking_time,status,id) values (?, ?,?,?,?,?,?)";
//				PreparedStatement statement = conn.prepareStatement(sql);
//		        
//				
//				
//		        try {
//		        		InputStream inputStream = null;
//		        		Part filePart = request.getPart("file_name");
//		             if (filePart != null) {
//		                 // prints out some information for debugging
//		                 System.out.println(filePart.getName());
//		                 System.out.println(filePart.getSize());
//		                 System.out.println(filePart.getContentType());
//		                  
//		                 // obtains input stream of the upload file
//		                 inputStream = filePart.getInputStream();
//		             }
//		        	statement.setString(1, request.getParameter("file_name"));
//		            statement.setString(2, "FDP");
//		            statement.setString(3, request.getParameter("first_name"));
//		            statement.setString(4, dtf.format(now));
//		            statement.setString(5, month);
//		            statement.setString(6, request.getParameter(message));
//		            statement.setString(7, Id); 
//		            
//		 
//		            // sends the statement to the database server
//		            int row = statement.executeUpdate();
//		            if (row > 0) {
//		                message = "File uploaded and saved into database";
//		            }
//		        } catch (SQLException ex) {
//		            message = "ERROR: " + ex.getMessage();
//		            ex.printStackTrace();
//		        } finally {
//		            if (conn != null) {
//		                // closes the database connection
//		                try {
//		                    conn.close();
//		                } catch (SQLException ex) {
//		                    ex.printStackTrace();
//		                }
//		            }
//		        }
//		            // sets the message in request scope
//		            request.setAttribute("message", message);
//		            response.sendRedirect("listFDPList");
//		           
//		    break;
//			default:
//				listFDPList(request, response);
//				break;
//			
//		        }
//		} catch (SQLException | ClassNotFoundException ex) {
//			ex.printStackTrace();
//			throw new ServletException(ex);
//		}
//    }
//		
//    
//    	
//    
//    
//		private void listFDPList(HttpServletRequest request, HttpServletResponse response)
//				throws SQLException, IOException, ServletException, ClassNotFoundException {
//			
//			List<FDPList> FDPList  = FDPUploadDAO.listFDPList();
//			request.setAttribute("FDPList", FDPList);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
//			dispatcher.forward(request, response);
//		}
//		
//		
//		
//        
//    }
