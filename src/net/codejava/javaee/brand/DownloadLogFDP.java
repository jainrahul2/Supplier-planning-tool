package net.codejava.javaee.brand;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(description = "Download File From The Server", urlPatterns = { "/DownloadLogFDP" })
public class DownloadLogFDP extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    public static int BUFFER_SIZE = 1024 * 100;
    public static final String UPLOAD_DIR = "uploadedFiles";
 
    /***** This Method Is Called By The Servlet Container To Process A 'GET' Request *****/
    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       

        //String fileName = "C:\\Users\\rjain6\\Desktop\\jcpenney\\logs.txt";
        String fileName = "D:\\SPT Application Log\\FDPlogs.txt";
        String fileType = "text/plain";
        // Find this file id in database to get file name, and file type

        // You must tell the browser the file type you are going to send
        // for example application/pdf, text/plain, text/html, image/jpg
        response.setContentType(fileType);

        // Make sure to show the download dialog
        response.setHeader("Content-disposition","attachment; filename=Logs.txt");

        // Assume file name is retrieved from database
        // For example D:\\file\\test.pdf

        File my_file = new File(fileName);

        // This should send the file to browser
        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
   }
  
}
