package net.codejava.javaee.brand;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.apache.poi.ss.usermodel.Cell;




public class email2 {

    //private static final String Assist = null;
    private static String jdbcURL;
	private static  String jdbcUsername;
	private  static String jdbcPassword;
	private static Connection jdbcConnection;
	
	public void diasUploadDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	public void getdelete(String filename) throws ClassNotFoundException 
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        diasUploadDAO up= new diasUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
	        Connection con = (Connection) DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
	       
	        String dias_id=up.getLastID(filename);
	        //int dias_id1=Integer.valueOf(dias_id);
//          dias_id1=dias_id1-1;
//          dias_id=String.valueOf(dias_id1);
	        Statement statement =con.createStatement();
	        String sql = "delete from SA_ANALYTICS.SPT.DIAS_MASTER where dias_id="+dias_id;
	        //System.out.println(sql);
	        statement.executeUpdate(sql);
	        //System.out.println(sql);
	        con.commit();

	        con.close();
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
    public void getinsert(String path,String filename,String Month) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            diasUploadDAO up= new diasUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
            String dias_id=up.getLastID();
           int dias_id1=Integer.valueOf(dias_id);
           dias_id1=dias_id1+1;
           dias_id=String.valueOf(dias_id1);
            Connection con = (Connection) DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
            String sql = "INSERT INTO SA_ANALYTICS.SPT.DIAS_MASTER(Contract_Nbr,Order_Nbr,Rpt_Supplier,Supplier_Name,Supplier_Nbr,Factory_ID,Factory_Name,SUB,LOT,PPK,Item_Description,PPM,Rpt_Brand,Channel,Country,IBO,Merch_ID,Sourcing_Director,Sourcing_Category,Sourcing_Sub_Cat,Classification,DCD_Date,ETA_Date,Units,FOB$,ELC,Month,dias_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            	//System.out.println("SQL Statement "+sql);
            PreparedStatement pstm = con.prepareStatement(sql);
            con.setAutoCommit(false);
            //System.out.println("in email2java");
            //File[] files = new File("C:\\Users\\rjain6\\Desktop\\dias").listFiles();
            String Path=path;
           
            File myFile = new File(Path);
	        FileInputStream fis = new FileInputStream(myFile);

	        
			
	         XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
             
   	         Sheet sheet = myWorkBook.getSheetAt(0);
   	      ArrayList<Cell> countryList=new ArrayList<Cell>();
          Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			//int counter=0;
			while (itr.hasNext())                 
			{  
				
				Row row = itr.next();
				//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
				Cell country = row.getCell(14);
				if(country!=null&&country.getCellType() != Cell.CELL_TYPE_BLANK)
				{
				//counter++;
				 
				countryList.add(country);
				
				}
				
				
			}
			countryList.subList(0, 2).clear();
			
			
            for(int k=1;k<=countryList.size()+1;k++)                
			{
            	Row row = sheet.getRow(k);
            	
                
                Cell Contract_Nbr=row.getCell(0);
                Cell Order_Nbr = row.getCell(1);
               
                Cell Rpt_Supplier = row.getCell(2);
                Cell Supplier_Name = row.getCell(3);
                Cell Supplier_Nbr = row.getCell(4);
                Cell Factory_ID = row.getCell(5);
                
                Cell Factory_Name = row.getCell(6);
                
                Cell SUB = row.getCell(7);
                
                Cell LOT = row.getCell(8);
                
                Cell PPK = row.getCell(9);
                
                Cell Item_Description = row.getCell(10);
                
                Cell PPM = row.getCell(11);
                
                Cell Rpt_Brand = row.getCell(12);
                Cell Channel = row.getCell(13);
                
                Cell Country = row.getCell(14);
                
                Cell IBO = row.getCell(15);
                
                Cell Merch_ID = row.getCell(16);
               
                Cell Sourcing_Director = row.getCell(17);
                Cell Sourcing_Category = row.getCell(18);
                
                Cell Sourcing_Sub_Cat = row.getCell(19);
               
                Cell Classification = row.getCell(20);
                
                Cell DCD_Date = row.getCell(21);
                Cell ETA_Date = row.getCell(22);
                Cell Units = row.getCell(23);
                Cell FOB$ = row.getCell(24);
                Cell ELC = row.getCell(25);
                
                
                
                //System.out.println("value initiated");
   
     int i =0;
	 pstm.setString(++i, String.valueOf(Contract_Nbr));
	 pstm.setString(++i, String.valueOf(Order_Nbr));
	 pstm.setString(++i, String.valueOf(Rpt_Supplier));
	 pstm.setString(++i, String.valueOf(Supplier_Name));
	 pstm.setString(++i, String.valueOf(Supplier_Nbr));
	 pstm.setString(++i, String.valueOf(Factory_ID));
	 pstm.setString(++i, String.valueOf(Factory_Name));
	 pstm.setString(++i, String.valueOf(SUB));
	 pstm.setString(++i, String.valueOf(LOT));
	 pstm.setString(++i, String.valueOf(PPK));
	 pstm.setString(++i, String.valueOf(Item_Description));
	 pstm.setString(++i, String.valueOf(PPM));
	 pstm.setString(++i, String.valueOf(Rpt_Brand));
	 pstm.setString(++i, String.valueOf(Channel));
	 pstm.setString(++i, String.valueOf(Country));
	 pstm.setString(++i, String.valueOf(IBO));
	 pstm.setString(++i, String.valueOf(Merch_ID));
	 pstm.setString(++i, String.valueOf(Sourcing_Director));
	 pstm.setString(++i,String.valueOf( Sourcing_Category));
	 pstm.setString(++i, String.valueOf(Sourcing_Sub_Cat));
	 pstm.setString(++i, String.valueOf(Classification));
	 pstm.setString(++i, String.valueOf(DCD_Date));
	 pstm.setString(++i, String.valueOf(ETA_Date));
	 pstm.setString(++i, String.valueOf(Units));
	 pstm.setString(++i, String.valueOf(FOB$));
	 pstm.setString(++i, String.valueOf(ELC));
	 pstm.setString(++i, String.valueOf(Month));
	 
     pstm.setString(++i, String.valueOf(dias_id)); 
     pstm.addBatch();
	
//	 for(i=1 ; i<100; i++) {
		
//		 pstm.executeBatch();
//		 con.commit();
//	 }
	if (k % 500 == 0) {
        pstm.executeBatch();
    }
	 
	 
	
                  
            }
           
            pstm.executeBatch();
            //System.out.println("in email2 java last ");
            
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