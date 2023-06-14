package net.codejava.javaee.brand;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;

import java.io.OutputStream;
import java.sql.SQLException;


@WebServlet(name = "DownloadServlet", urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int BUFFER_SIZE = 1024 * 100;
	fileNameValidation fd= new fileNameValidation();
	 
     //String month=request.getParameter("month");
     //System.out.println("month");
	
    //public static final String UPLOAD_DIR = "resources";
   
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * *** Get The Absolute Path Of The File To Be Downloaded ****
         */
    	 String fileName = null;
    	String id1="";
    	int id;
    	String UPLOAD_DIR;
    	//HttpSession session= request.getSession();
        diasUploadDAO dud= new diasUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
        try {
			 id1=dud.getLastID();
			 id=(Integer.parseInt(id1))-1;
			 id1=String.valueOf(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String status= String.valueOf(request.getParameter("status"));
//		
//		System.out.println("status value from download"+status);
//		if(status.equalsIgnoreCase("Success"))
//		{
//			fileName = request.getParameter("fileName");
//			String month=fd.getFolderNameByMonth(fileName);
//			 UPLOAD_DIR="resourcesDIAS\\"+month;
//		}
//		else
//		{
			
//			fileName = id1+"Fail.xlsx";
//			 UPLOAD_DIR="resourcesDIAS\\"+"FailedFile";
			 
			 fileName = request.getParameter("fileName");
				String month=fd.getFolderNameByMonth(fileName);
				 UPLOAD_DIR="resourcesDIAS\\"+month;
		//}
		
		   /***** Get The Absolute Path Of The File To Be Downloaded *****/
         //fileName = request.getParameter("fileName"),
                String applicationPath = getServletContext().getRealPath("");
                String downloadPath = applicationPath + File.separator + UPLOAD_DIR;
                String filePath = downloadPath + File.separator + fileName;
 
        File file = new File(filePath);
        OutputStream outStream = null;
        FileInputStream inputStream = null;
 
        if (file.exists()) {
        	
            /**** Setting The Content Attributes For The Response Object ****/
            

            String mimeType = "application/octet-stream";
            response.setContentType(mimeType);
           
 
            /**** Setting The Headers For The Response Object ****/
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
            response.setHeader(headerKey, headerValue);
            
            try {
 
                /**** Get The Output Stream Of The Response ****/
                outStream = response.getOutputStream();
                
                inputStream = new FileInputStream(file);
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
 
                /**** Write Each Byte Of Data Read From The Input Stream Write Each Byte Of Data  Read From The Input Stream Into The Output Stream ****/
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }

            } catch(IOException ioExObj) {
                System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
            } finally {             
                if (inputStream != null) {
                    inputStream.close();
                }
 
                outStream.flush();
                if (outStream != null) {
                    outStream.close();
                }
            }
           
        } else {
 
            /***** Set Response Content Type *****/
            response.setContentType("text/html");
 
            /***** Print The Response *****/
            response.getWriter().println("<h3>File "+ fileName +" Is Not Present .....!</h3>");
           
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.sendRedirect("file-listDIAS.jsp");
		
    }
    }



