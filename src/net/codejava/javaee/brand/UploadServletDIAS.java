package net.codejava.javaee.brand;


import java.io.BufferedInputStream;

//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;
//import java.nio.file.attribute.FileAttributeView;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.time.YearMonth;
//import java.time.format.DateTimeFormatter;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.servlet.http.Part;
//
//
//@WebServlet(name = "UploadServlet", urlPatterns = {"/UploadServlet"})
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
//        maxFileSize = 1024 * 1024 * 1000, // 1 GB
//        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
//public class UploadServlet extends HttpServlet {
//
//    PrintWriter out = null;
//    Connection con = null;
//    PreparedStatement ps = null;
//    HttpSession session = null;
//   
//    @SuppressWarnings("null")
//	@Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/plain;charset=UTF-8");
//       
//        try {
//        	
//            out = response.getWriter();
//            session = request.getSession(false);
//            String folderName = "resources";
//            //String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;//for netbeans use this code
//            String uploadPath = request.getServletContext().getRealPath("") + folderName;//for eclipse use this code
//            File dir = new File(uploadPath);
//         
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            Login login= new Login();
//            Part filePart = request.getPart("file");//Textbox value of name file.
//            String fileName = filePart.getName();
//            CategoryListDAO cat=null;
//            String path = folderName + File.separator + fileName;
//            Timestamp added_date = new Timestamp(System.currentTimeMillis());
//            String upload_time=String.valueOf(added_date);
//            System.out.println("fileName: " + fileName);
//            System.out.println("Path: " + uploadPath);
//            System.out.println("username"+login.getFirst_name());
//            try {
//				System.out.println("value of file"+cat.getLastId());
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//            //System.out.println("Name: " + firstName);
//            InputStream is = filePart.getInputStream();
//            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
//            
//            try {
//           
//            	
//            	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
//		    	LocalDateTime now = LocalDateTime.now();
//		    	YearMonth thisMonth= YearMonth.now();
//		    	String month =thisMonth.toString();
//		    	LockingDate lockingDate=null;
//		    	
//		    	switch (month) {
//				case "JAN":
//					month=lockingDate.getJanuary();
//				break;
//				case "FEB":
//					month=lockingDate.getFeb();
//				break;
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
//					month=lockingDate.getJuly();
//					break;
//				}
//		    	//int s=Integer.parseInt(getLastId())+1;
//				//String Id=String.valueOf(s);
//				System.out.println("fileName: " + fileName);
//	            System.out.println("Path: " + uploadPath);
//	            System.out.println("fileName: " + month);
//	            System.out.println("Path: " + upload_time);
//	            //System.out.println("firstname: " + login.getEmail_id());
//	           
//				
//                con = DB.getConnection();
//                System.out.println("connection done");
//                String sql = "insert into SA_ANALYTICS.spt.fdp_file_upload_master(file_name,file_type,uploaded_by,upload_time,locking_time,status,Id) values(?,?,?,?,?,?,?)";
//                ps = con.prepareStatement(sql);
//                //ps.setString(1, firstName);
//                //ps.setString(2, lastName);
//                ps.setString(1, path);
//                ps.setString(2, fileName);
//                ps.setString(3, login.getFirst_name());
//                ps.setString(4, upload_time);
//                ps.setString(5, month);
//                ps.setString(6, "success");
//                ps.setString(7, "3");
//              
//                int status = ps.executeUpdate();
//                if (status > 0) {
//                    session.setAttribute("fileName", fileName);
//                    String msg = "" + fileName + " File uploaded successfully...";
//                    request.setAttribute("msg", msg);
//                    RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
//                    rd.forward(request, response);
//                    System.out.println("File uploaded successfully...");
//                    System.out.println("Uploaded Path: " + uploadPath);
//                }
//            } catch (SQLException e) {
//                out.println("Exception: " + e);
//                System.out.println("Exception1: " + e);
//            } finally {
//                try {
//                    if (ps != null) {
//                        ps.close();
//                        
//                    }
//                    if (con != null) {
//                        con.close();
//                    }
//                } catch (SQLException e) {
//                    out.println(e);
//                }
//            }
//
//        } catch (IOException | ServletException e) {
//            out.println("Exception: " + e);
//            System.out.println("Exception2: " + e);
//        }
//    }
//
//}

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.codehaus.jackson.format.InputAccessor;


@SuppressWarnings("serial")
@WebServlet(name = "UploadServletDIAS", urlPatterns = {"/UploadServletDIAS"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 1000, // 1 GB
        maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB
public class UploadServletDIAS extends HttpServlet {
	
	
    PrintWriter out = null;
    Connection con = null;
    PreparedStatement ps = null;
    HttpSession session = null;
    private static String getSubmittedFileName(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }
    static int   counterForRowStatus;
	
	public int  getcounterForRowStatus(int rowstatus)
	{
		counterForRowStatus=rowstatus;
		//System.out.print(counterForRowStatus);
		return counterForRowStatus;
		
	}
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try {
            out = response.getWriter();
            HttpSession session=request.getSession(); 
            session = request.getSession(true);
            //HttpSession session=request.getSession(); 
            //uploadPath up= new uploadPath();
            //String folderName = up.getUploadPath();
            Part filePart = request.getPart("file");//Textbox value of name file.
            String firstName = request.getParameter("firstname");//Textbox value of name firstname.
            String lastName = request.getParameter("lastname");//Textbox value of name lastname.
            String fileName =getSubmittedFileName(filePart);
            fileNameValidation fd= new fileNameValidation();
            String month=fd.getFolderNameByMonth(fileName);
            //String month=request.getParameter("month");
            //System.out.println("month");
            //String folderNameErrorFile="resourcesDIAS\\"+"FailedFile";
            String folderName="resourcesDIAS\\"+month;
            //String uploadPath = request.getServletContext().getRealPath("") + File.separator + folderName;//for netbeans use this code
            String uploadPath = request.getServletContext().getRealPath("") + folderName;//for eclipse use this code
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //String uploadPath1 = request.getServletContext().getRealPath("") + folderNameErrorFile;//for eclipse use this code
//            File dir1 = new File(uploadPath1);
//            if (!dir1.exists()) {
//                dir1.mkdirs();
//            }
            String id="";
            String id1="";
            String path = folderName + File.separator + fileName;
            
            String absPath=uploadPath+"\\"+fileName;
            //Timestamp added_date = new Timestamp(System.currentTimeMillis());
            //System.out.println("file path is "+absPath);
            InputStream is = filePart.getInputStream();
            Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
            //Files.copy(is, Paths.get(uploadPath1 + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
            email2 saveintodatabase= new email2();
            UpdateMasterDataTable md= new UpdateMasterDataTable();
            diasUploadDAO dud= new diasUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
            try {
				 id=dud.getLastID(fileName);
				 id1=dud.getLastID();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//            String pathErrorFile=folderNameErrorFile + File.separator + id1+"Fail.xlsx";
//            String absPathErrorFile=uploadPath1+"\\"+id1+"Fail.xlsx";
//            Files.copy(is, Paths.get(uploadPath1 + File.separator + id1+"Fail.xlsx"), StandardCopyOption.REPLACE_EXISTING);
            //System.out.println(absPathErrorFile+ " absaptherror "+absPathErrorFile);
            try {
            	int counter = 0;
            	int counter1=0;
            	String result="";
                con = DB.getConnection();
                //System.out.println("connection done for DIAS");
                ValidationDIAS validation= new ValidationDIAS(ValidationDIASFDP.jdbcURL, ValidationDIASFDP.jdbcUsername, ValidationDIASFDP.jdbcPassword);
                boolean val=validation.ValidateExcelFiledias(absPath,absPath);
                File myFile = new File(absPath);
                FileInputStream fis = new FileInputStream(myFile);
                XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
                Sheet sheet = myWorkBook.getSheetAt(0);
                //Row header = sheet.getRow(0);
                if(sheet.getLastRowNum()<1 || sheet.getLastRowNum()==1){
                	result="Sheet Cannot be empty";
                 	session.setAttribute("fileName", fileName);
         			//String msg = "" + fileName + " File contain Error,Please click on download log to check errors";
         			request.setAttribute("msg", result);
         		RequestDispatcher rd = request.getRequestDispatcher("/SuccessDias.jsp");
         		con.close();
         		rd.forward(request, response);
                }
                else if(month==null)
                {
                	result="File Name Must contain Month Name before uploading";
                 	session.setAttribute("fileName", fileName);
         			//String msg = "" + fileName + " File contain Error,Please click on download log to check errors";
         			request.setAttribute("msg", result);
         		RequestDispatcher rd = request.getRequestDispatcher("/SuccessDias.jsp");
         		con.close();
         		rd.forward(request, response);
                }
                else
                {
                	
                
                if(val)
                {
                	//boolean currentMonthCheck=fd.getValidatedCurrentMonth(month);
//                	if(currentMonthCheck)
//                	{
                		
                		Statement statement=con.createStatement();
                		//System.out.println("F");
                		String isDatabaseEmpty="select count(*) from SA_ANALYTICS.SPT.DIAS_MASTER";
                		//statement.executeUpdate(isDatabaseEmpty);
                		ResultSet resultSet = statement.executeQuery(isDatabaseEmpty);
                		//System.out.println("G");
                		if (resultSet.next()) {
                			counter=resultSet.getInt(1);
                		}
                		else
                			counter=1;
                		
                		//System.out.println("counter " + counter);
                		if(counter==0)
                		{
                			saveintodatabase.getinsert(absPath,fileName,month);
                			//System.out.println("this is the first insert");
                		}
                		else
                		{
                			String idInDatabase="";
                			Statement statement1=con.createStatement();
                			//System.out.println("A");
                    		String lastidexists="select dias_id from SA_ANALYTICS.SPT.DIAS_MASTER where dias_id='+"+id+"+'";
                    		
                    		ResultSet resultSet1 = statement1.executeQuery(lastidexists);
                    		//System.out.println("B");
                    		if (resultSet1.next()) {
                    			idInDatabase=resultSet1.getString(1);
                    		}
                    		if(idInDatabase.equalsIgnoreCase("")||idInDatabase.equalsIgnoreCase(null)||idInDatabase.equalsIgnoreCase(" "))
                    		{
                    			saveintodatabase.getinsert(absPath,fileName,month);
                    		}
                    		else
                    		{
                    			saveintodatabase.getdelete(fileName);
                    			//System.out.print("delete done");
                    			saveintodatabase.getinsert(absPath,fileName,month);
                    		}
                		}
	                		String sts="Success";
	                		//System.out.println("C");
	            			String sql = "insert into SA_ANALYTICS.spt.dias_upload_master(firstname,lastname,filename,path,status,ErrorRowCount) values(?,?,?,?,?,?)";
	            			ps = con.prepareStatement(sql);
	            			//System.out.println("D");
	            			ps.setString(1, firstName);
	            			ps.setString(2, lastName);
	            			ps.setString(3, fileName);
	            			ps.setString(4, path);
	            			ps.setString(5, sts);
	            			ps.setNString(6, "0");
	            			session.setAttribute("fileName", fileName);
    	                	session.setAttribute("status", sts);
                			//ps.setTimestamp(5, );
                			ps.executeUpdate();
                			
                			//System.out.println("E");
                			//DownloadServlet ds= new DownloadServlet();
                			
                			//session.setAttribute("status", sts);
                			Statement statement1 = con.createStatement();
                			String isDatabaseEmptyMaster = "select count(*) from SA_ANALYTICS.SPT.master_data";
                    		//statement.executeUpdate(isDatabaseEmpty);
                    		ResultSet resultSet1 = statement1.executeQuery(isDatabaseEmptyMaster);
                    		
                    		if (resultSet1.next()) {
                    			counter1=resultSet1.getInt(1);
                    		}
                    		else
                    			counter1=1;
                    		if(counter1==0)
                    		{
                    			
                    			md.getinsertMaster();
                    			md.getinsertMasterDiasData();
                    		}
                    		else
                    		{
                    			md.getdeletemaster();
                    			md.getinsertMaster();
                    			md.getinsertMasterDiasData();
                    			
                    		}
                			String msg = "" + fileName + " File uploaded successfully...";
                			request.setAttribute("msg", msg);
                			request.setAttribute("status", sts);
                			RequestDispatcher rd = request.getRequestDispatcher("/SuccessDias.jsp");
                			con.close();
                			//diasUploadDAO disupload= new diasUploadDAO(ValidationDIASFDP.jdbcURL, ValidationDIASFDP.jdbcUsername, ValidationDIASFDP.jdbcPassword);
                			//String filename=disupload.getFileName();
                			rd.forward(request, response);
                		
//                	}
//                	else
//                	{
//                		
//                		//System.out.println("this is not the current month");
//                		saveintodatabase.getdelete(fileName);
//            			//System.out.print("delete done");
//            			saveintodatabase.getinsert(absPath,fileName);
//                		String sql = "insert into SA_ANALYTICS.spt.dias_upload_master(firstname,lastname,filename,path) values(?,?,?,?)";
//            			ps = con.prepareStatement(sql);
//            			ps.setString(1, firstName);
//            			ps.setString(2, lastName);
//            			ps.setString(3, fileName);
//            			ps.setString(4, path);
//            			//ps.setTimestamp(5, );
//            			int status = ps.executeUpdate();
//            			session.setAttribute("fileName", fileName);
//            			String msg = "" + fileName + " File uploaded successfully...";
//            			request.setAttribute("msg", msg);
//            			RequestDispatcher rd = request.getRequestDispatcher("/SuccessDias.jsp");
//            			//diasUploadDAO disupload= new diasUploadDAO(ValidationDIASFDP.jdbcURL, ValidationDIASFDP.jdbcUsername, ValidationDIASFDP.jdbcPassword);
//            			//String filename=disupload.getFileName();
//            			rd.forward(request, response);
//                	}
                }
	                else
	                {
	                	String sts="Fail";
	                	//System.out.println("in upload"+counterForRowStatus);
            			String sql = "insert into SA_ANALYTICS.spt.dias_upload_master(firstname,lastname,filename,path,status,ErrorRowCount) values(?,?,?,?,?,?)";
            			ps = con.prepareStatement(sql);
            			ps.setString(1, firstName);
            			ps.setString(2, lastName);
            			ps.setString(3, fileName);
            			ps.setString(4, path);
            			ps.setString(5, sts);
            			ps.setNString(6, String.valueOf(counterForRowStatus-1));
	                	session.setAttribute("fileName", fileName);
	                	session.setAttribute("status", sts);
	                	//DownloadServlet ds= new DownloadServlet();
	                	ps.executeUpdate();
	            		String msg = "" + fileName + " File contain Error,Please click on download log to check errors";
	            		request.setAttribute("msg", msg);
	            		request.setAttribute("status", sts);
	            		RequestDispatcher rd = request.getRequestDispatcher("/SuccessDias.jsp");
	            		con.close();
	            		rd.forward(request, response);
	                }
                }
                	
                	
                
                
                
            } catch (SQLException e) {
                out.println("Exception: " + e);
                System.out.println("Exception1: " + e);
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
            	
				e.printStackTrace();
			} finally {
                try {
                    if (ps != null) {
                        ps.close();
                    }
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    out.println(e);
                }
            }

        } catch (IOException | ServletException e) {
            out.println("Exception: " + e);
            System.out.println("Exception2: " + e);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		
		try {
			switch (action) {
			case "/UploadServletDIAS":
				uploaddias(request, response);
				break;
			default:
				uploaddias(request, response);
				break;
			
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
	}
    private void uploaddias(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("DIASupload.jsp");
		dispatcher.forward(request, response);
	}

    


}

