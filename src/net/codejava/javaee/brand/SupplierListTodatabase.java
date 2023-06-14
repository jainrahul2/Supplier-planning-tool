package net.codejava.javaee.brand;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.function.Supplier;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class SupplierListTodatabase {

  
	
    public static void main(String args[]) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //diasUploadDAO up= new diasUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
           
            Connection con = (Connection) DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
            String sql = "INSERT INTO SA_ANALYTICS.spt.supplier_master(supplier_number,rpt_supplier,child_supplier,origin_indicator,major_category,country,ibo,region,supplier_plan,grade,status) "
            		+ "	VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            	//System.out.println("SQL Statement "+sql);
            PreparedStatement pstm = con.prepareStatement(sql);
            con.setAutoCommit(false);
            //File[] files = new File("C:\\Users\\rjain6\\Desktop\\dias").listFiles();
            String path="C:\\Users\\rjain6\\Downloads\\SupplierList (7).xlsx";
           
            File myFile = new File(path);
	        FileInputStream fis = new FileInputStream(myFile);

	        
			
	         XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
             
   	         Sheet sheet = myWorkBook.getSheetAt(0);
			
			
			
            for(int k=1;k<sheet.getPhysicalNumberOfRows();k++)                
			{
            	Row row = sheet.getRow(k);
            	Cell supplier_number = row.getCell(2);
    			Cell rpt_supplier=  row.getCell(0);
            	Cell child_supplier=  row.getCell(1);
            	Cell origin_indicator=  row.getCell(3);
            	Cell major_category=  row.getCell(4);
            	Cell country=  row.getCell(5);
            	Cell ibo=  row.getCell(6);
            	Cell region= row.getCell(7);
            	Cell supplier_plan=  row.getCell(8);
            	Cell grade=  row.getCell(9);
            	Cell status=  row.getCell(10);
                
                
                
                
                //System.out.println("value initiated");
   
     int i =0;
	 pstm.setString(++i, String.valueOf(supplier_number));
	 pstm.setString(++i, String.valueOf(rpt_supplier));
	 pstm.setString(++i, String.valueOf(child_supplier));
	 pstm.setString(++i, String.valueOf(origin_indicator));
	 pstm.setString(++i, String.valueOf(major_category));
	 pstm.setString(++i, String.valueOf(country));
	 pstm.setString(++i, String.valueOf(ibo));
	 pstm.setString(++i, String.valueOf(region));
	 pstm.setString(++i, String.valueOf(supplier_plan));
	 pstm.setString(++i, String.valueOf(grade));
	 pstm.setString(++i, String.valueOf(status));
	
	 
     pstm.addBatch();
	
//	 for(i=1 ; i<100; i++) {
		
//		 pstm.executeBatch();
//		 con.commit();
//	 }
	if (k % 500 == 0) {
        pstm.executeBatch();
    }
	 
	 
	
                  
            }
           System.out.println("done");
            pstm.executeBatch();
            
            
            con.commit();
           
            con.close();
            
        //System.out.println("Success");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        
    }
    

}