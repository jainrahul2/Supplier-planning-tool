package net.codejava.javaee.brand;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
  
public class GenerateReporting { 
	static String jdbcURL;
	static  String jdbcUsername;
	static String jdbcPassword;
	static Connection jdbcConnection;
	static boolean flag1=true;
	static boolean flag2=true;
	static boolean flag3=true;
	static boolean counter1,counter2,counter3,counter4,counter5,counter6,counter7;
	public GenerateReporting(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		ValidationDIAS.jdbcURL = "jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433";
		ValidationDIAS.jdbcUsername = "sqladmin";
		ValidationDIAS.jdbcPassword = "sqladmin2017";
	}
	 
	
	 static void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(
										"jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
		}
	}
	
	 static void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public  List<DIASFDPUpload> listSupplier() throws SQLException {
		List<DIASFDPUpload> DIASFDPUpload = new ArrayList<>();
		
		String sql = "SELECT DISTINCT Rpt__Supplier FROM  SA_ANALYTICS.dbo.pp_mstr_fcst where Sourcing_director='Jerry Schroeder' and Year='2020 Act/Fcst'  and Rpt__Supplier='BEST SUPER' and YR='2020' " ;
				
		
		GenerateReporting.connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String Rpt_Supplier= resultSet.getString("Rpt__Supplier");
			DIASFDPUpload DIASFDPUpload1 =  new DIASFDPUpload(Rpt_Supplier);
			DIASFDPUpload.add(DIASFDPUpload1);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public  List<DIASFDPUpload> listBrand() throws SQLException {
		List<DIASFDPUpload> DIASFDPUpload = new ArrayList<>();
		
		String sql = "SELECT DISTINCT Rpt__Brand FROM  SA_ANALYTICS.dbo.pp_mstr_fcst where Sourcing_director='Jerry Schroeder' and Year='2020 Act/Fcst'  and Rpt__Supplier='BEST SUPER' and YR='2020' " ;
				
		
		GenerateReporting.connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String Rpt_Brand= resultSet.getString("Rpt__Brand");
			DIASFDPUpload DIASFDPUpload1 =  new DIASFDPUpload(Rpt_Brand);
			DIASFDPUpload.add(DIASFDPUpload1);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public  List<DIASFDPUpload> listDivision() throws SQLException {
		List<DIASFDPUpload> DIASFDPUpload = new ArrayList<>();
		
		String sql = "SELECT DISTINCT Division FROM  SA_ANALYTICS.dbo.pp_mstr_fcst where Sourcing_director='Jerry Schroeder' and Year='2020 Act/Fcst'  and Rpt__Supplier='BEST SUPER' and YR='2020' " ;
				
		
		GenerateReporting.connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String Division= resultSet.getString("Division");
			DIASFDPUpload DIASFDPUpload1 =  new DIASFDPUpload(Division);
			DIASFDPUpload.add(DIASFDPUpload1);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public  List<DIASFDPUpload> listSub() throws SQLException {
		List<DIASFDPUpload> DIASFDPUpload = new ArrayList<>();
		
		String sql = "SELECT DISTINCT Sub FROM  SA_ANALYTICS.dbo.pp_mstr_fcst where Sourcing_director='Jerry Schroeder' and Year='2020 Act/Fcst'  and Rpt__Supplier='BEST SUPER' and YR='2020' " ;
				
		
		GenerateReporting.connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String Sub= resultSet.getString("Sub");
			DIASFDPUpload DIASFDPUpload1 =  new DIASFDPUpload(Sub);
			DIASFDPUpload.add(DIASFDPUpload1);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public  List<DIASFDPUpload> listCountry() throws SQLException {
		List<DIASFDPUpload> DIASFDPUpload = new ArrayList<>();
		
		String sql = "SELECT DISTINCT Country FROM  SA_ANALYTICS.dbo.pp_mstr_fcst where Sourcing_director='Jerry Schroeder' and Year='2020 Act/Fcst'  and Rpt__Supplier='BEST SUPER' and YR='2020' " ;
				
		
		GenerateReporting.connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String Country= resultSet.getString("Country");
			DIASFDPUpload DIASFDPUpload1 =  new DIASFDPUpload(Country);
			DIASFDPUpload.add(DIASFDPUpload1);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public  LinkedHashMap<Integer, ArrayList> listData() throws SQLException {
		ArrayList SupplierPlanReport = new ArrayList<>();
		List<DIASFDPUpload> supplier= new ArrayList();
		ArrayList ar = new ArrayList();
		LinkedHashMap<Integer, ArrayList> li_hash_map =  
		        new LinkedHashMap<Integer, ArrayList>(); 
		String[] Month= {"FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC","JAN"};
		String sql="";
		String brand="";
		String division="";
		String sub="";
		String coo="";
		int Fob$;
		int Unit;
		String rpt_supplier="";
		List<DIASFDPUpload> listCountry;
		supplier=listSupplier();
		for(int i=0;i<listSupplier().size();i++)
		{
			for(int j=0;j<listBrand().size();j++)
			{
				for(int k=0;k<listDivision().size();k++)
				{
					for(int l=0;l<listSub().size();l++)
					{
						for(int m=0;m<listSub().size();m++)
						{
							for(int n=0;n<listCountry().size();n++)
							{
								for(int p=0;p<Month.length;p++)
								{
									String sql1="select SUM(FOB_DOL),SUM(UNITS),Rpt__Brand,Division,Sub,Country from SA_ANALYTICS.dbo.pp_mstr_fcst where Sourcing_director='Jerry Schroeder' and YR='2020'  and Year='2020 Act/Fcst' and Country='"+listCountry().get(n)+"'  and Rpt__Supplier='"+listSupplier().get(i)+"' and MONTH='"+Month[p]+"' group by Country,FOB_DOL,UNITS,Sub,Month,Division,Rpt__Supplier,Rpt__Brand";
									GenerateReporting.connect();
								
										Statement statement = jdbcConnection.createStatement();
										ResultSet resultSet = statement.executeQuery(sql1);
								
									 	while (resultSet.next()) {
									
									 		int FOB_DOL= resultSet.getInt(1);
											int Units = resultSet.getInt(2);
											String sub1= resultSet.getString(5);
											String coo2= resultSet.getString(6);
											String rptbrand = resultSet.getString(3);
											String Div= resultSet.getString(4);
											
								
								
											 reprotingSupplierReport SupplierPlan =  new reprotingSupplierReport(FOB_DOL,Units,rptbrand,Div,sub1,coo2);
											 SupplierPlanReport.add(SupplierPlan);
											 li_hash_map.put(p, SupplierPlanReport);
									 }
									 
							
									 	resultSet.close();
								 statement.close();
							
								 disconnect();
							
								}
							}
						}
							
					}
				}
			}
		}
		return li_hash_map;
			
				
	}
    public static void main(String[] args)  throws FileNotFoundException, IOException, SQLException 
    { 
  
        try {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    	LocalDateTime now = LocalDateTime.now();  
    	DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy");
    	
		String year=dtf3.format(now);
    	//LoginDAO login= new  LoginDAO();
    	Login login=new Login();
    	String name=login.getFirst_name();
    	
        GenerateReporting gr= new GenerateReporting("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
        List<DIASFDPUpload> supplier= new ArrayList();
        List<reprotingSupplierReport> ar=gr.listData();
       
        OutputStream fileOut = new FileOutputStream("C:\\Users\\rjain6\\Desktop\\SupplierPlanNew1.xlsx"); 
        supplier= gr.listSupplier();
        Workbook wb = new XSSFWorkbook();
        Sheet sheet1 = wb.createSheet("Cover Page");
        //SheetConditionalFormatting sheetCF = sheet1.getSheetConditionalFormatting();
        
        sheet1.createRow(11).createCell(9).setCellValue("JCPenney Purchasing Corporation");
        sheet1.createRow(12).createCell(9).setCellValue("Supplier Plan");
        sheet1.createRow(13).createCell(9).setCellValue("Report Name:Supplier Plan");
        sheet1.createRow(14).createCell(9).setCellValue("Report Created"+dtf.format(now));
        sheet1.createRow(15).createCell(9).setCellValue("User: "+name);
        sheet1.createRow(16).createCell(9).setCellValue("By Division");
        sheet1.createRow(17).createCell(9).setCellValue("Defult View: Monthly");
        sheet1.createRow(18).createCell(9).setCellValue("Sourcing Director:Jerry Schroder");
    	int rowCounter1=4;
    	int rowCounter2=5;
        for(int i=0;i<supplier.size();i++)
        {
        	Sheet sheet = wb.createSheet(supplier.get(i).getCountry_name());
        	sheet.createRow(0).createCell(0).setCellValue("Sourcing Director:Jerry Schroder");
        	sheet.createRow(1).createCell(0).setCellValue("Supplier"+supplier.get(i).getCountry_name());
        	sheet.createRow(2).createCell(0).setCellValue("Shipment by ETA Month");
        	
        	sheet.createRow(3);
        	sheet.createRow(4);
        	Row row = sheet.getRow(3);
        	
        	
        	row.createCell(0).setCellValue("Brand");
        	
        	
        	row.createCell(1).setCellValue("Division");
        	row.createCell(2).setCellValue("Sub");
        	row.createCell(3).setCellValue("COO");
        	row.createCell(4).setCellValue("FOB$/Unit");
        	row.createCell(5).setCellValue("FEB-"+year);
        	row.createCell(6).setCellValue("MAR-"+year);
        	row.createCell(7).setCellValue("APR-"+year);
        	row.createCell(8).setCellValue("MAY-"+year);
        	row.createCell(9).setCellValue("JUN-"+year);
        	row.createCell(10).setCellValue("JUL-"+year);
        	row.createCell(11).setCellValue("AUG-"+year);
        	row.createCell(12).setCellValue("SEP-"+year);
        	row.createCell(13).setCellValue("OCT-"+year);
        	row.createCell(14).setCellValue("NOV-"+year);
        	row.createCell(15).setCellValue("DEC-"+year);
        	row.createCell(16).setCellValue("JAN-"+year);
        	row.createCell(17).setCellValue("Total");
        	
        	
        	
        	for(int k=0;k<12;k++)
        	{
        		
        		sheet.createRow(rowCounter1);
        		sheet.createRow(rowCounter2);
            	Row row1 = sheet.getRow(rowCounter1);
            	Row row2 = sheet.getRow(rowCounter2);
            	
            	
            	row1.createCell(0).setCellValue(ar.get(3).getRpt__Brand());
            	row2.createCell(0).setCellValue("");
            	row1.createCell(1).setCellValue(ar.get(4).getDivision());
            	row2.createCell(1).setCellValue("");
            	row1.createCell(2).setCellValue(ar.get(5).getSub());
            	row2.createCell(2).setCellValue("");
            	row1.createCell(3).setCellValue(ar.get(6).getCountry());
            	row2.createCell(3).setCellValue("");
            	row1.createCell(4).setCellValue("Unit");
            	row2.createCell(4).setCellValue("FOB$");
            	
            	row1.createCell(5).setCellValue(ar.get(0).getUNITS());
            	row2.createCell(5).setCellValue(ar.get(0).getFOB_DOL());
            	row1.createCell(6).setCellValue(ar.get(1).getUNITS());
            	row2.createCell(6).setCellValue(ar.get(1).getFOB_DOL());
            	row1.createCell(7).setCellValue(ar.get(2).getUNITS());
            	row2.createCell(7).setCellValue(ar.get(2).getFOB_DOL());
            	row1.createCell(8).setCellValue(ar.get(3).getUNITS());
            	row2.createCell(8).setCellValue(ar.get(3).getFOB_DOL());
            	row1.createCell(9).setCellValue(ar.get(4).getUNITS());
            	row2.createCell(9).setCellValue(ar.get(4).getFOB_DOL());
            	row1.createCell(10).setCellValue(ar.get(5).getUNITS());
            	row2.createCell(10).setCellValue(ar.get(5).getFOB_DOL());
            	row1.createCell(11).setCellValue(ar.get(6).getUNITS());
            	row2.createCell(11).setCellValue(ar.get(6).getFOB_DOL());
            	row1.createCell(12).setCellValue(ar.get(7).getUNITS());
            	row2.createCell(12).setCellValue(ar.get(7).getFOB_DOL());
            	row1.createCell(13).setCellValue(ar.get(8).getUNITS());
            	row2.createCell(13).setCellValue(ar.get(8).getFOB_DOL());
            	row1.createCell(14).setCellValue(ar.get(9).getUNITS());
            	row2.createCell(14).setCellValue(ar.get(9).getFOB_DOL());
            	row1.createCell(15).setCellValue(ar.get(10).getUNITS());
            	row2.createCell(15).setCellValue(ar.get(10).getFOB_DOL());
            	row1.createCell(16).setCellValue(ar.get(11).getUNITS());
            	row2.createCell(16).setCellValue(ar.get(11).getFOB_DOL());
            	row1.createCell(17).setCellFormula("SUM(F"+rowCounter1+1+":Q"+rowCounter1+1+")");
            	row2.createCell(17).setCellFormula("SUM(F"+rowCounter2+1+":Q"+rowCounter2+1+")");
            	
            	
            	rowCounter1=rowCounter1+2;
            	rowCounter2=rowCounter1+1;
        	
        	}
        	
        	}
        	
        
        
        
        
       
        wb.write(fileOut);
        fileOut.close();
        System.out.println("done");
        }
        catch(Exception e)
        {
        	System.out.print(e);
        }
        
        
       
    } 
}
