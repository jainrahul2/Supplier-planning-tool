package net.codejava.javaee.brand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FdpFileNameExtracter {
	public void getinsert(String path , String filename) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        FDPUploadDAO up= new FDPUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
	        //String fdp_id=up.getLastID(filename);
	       
//	           int fdp_id1=Integer.valueOf(fdp_id);
//	           fdp_id1=fdp_id1+1;
//	           fdp_id=String.valueOf(fdp_id1);
	        //int fdp_id1=Integer.valueOf(fdp_id);
            Connection con = DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
            String sql = "INSERT INTO SA_ANALYTICS.SPT.fdp_master(ppm,sourcing_director,sourcing_manager,major_category,sourcing_category,sourcing_sub_cat,classification,rpt_supplier,rpt_brand,country,plan_level,plan_name,channel,fashion_or_replenishment,pps,flow_model,division,sub,lot,ppk,dir,item_description,year,month,units,fob$,avg_fob,fdp_id,commment) "
            		+ "	VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            	//System.out.println("SQL Statement "+sql);
            PreparedStatement pstm = con.prepareStatement(sql);
            con.setAutoCommit(false);
            String fdp_id=up.getLastID();
			 int fdp_id1=Integer.valueOf(fdp_id);
		     fdp_id1=fdp_id1+1;
	        fdp_id=String.valueOf(fdp_id1);
	        
            String Path=path;
            String year="";
            File myFile = new File(Path);
	        FileInputStream fis = new FileInputStream(myFile);
	        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
	        Pattern pattern = Pattern.compile("(\\d{4})");

			 Matcher matcher = pattern.matcher(filename);
			   
			    if (matcher.find()) {
			        //System.out.println(matcher.group(1));
			    	year=matcher.group(1);
			        //val = matcher.group(1);
			    }
			    //Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
				
	            
	        //ArrayList<Cell> planname= new ArrayList<Cell>();
	        //ArrayList<Cell> fobdol= new ArrayList<Cell>();
            Sheet sheet = myWorkBook.getSheetAt(0);
//            for(int k=2;k<sheet.getLastRowNum();k++)
//   		 	{                
//			
//            	Row row = sheet.getRow(k);
//            	Cell plan_name= row.getCell(11);
//            	Cell fob$=row.getCell(35);
//            	
//            
//            	planname.add(plan_name);
//            	fobdol.add(fob$);
//			}
//            System.out.println(planname+ "    "+fobdol);
            System.out.println(sheet.getPhysicalNumberOfRows()+"   "+sheet.getLastRowNum());
            ArrayList<Cell> countryList=new ArrayList<Cell>();
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			int counter=0;
			while (itr.hasNext())                 
			{  
				
				Row row = itr.next();
				//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
				Cell country = row.getCell(0);
				if(country!=null&&country.getCellType() != Cell.CELL_TYPE_BLANK)
				{
				counter++;
				 
				countryList.add(country);
				
				}
				
				
			}
			countryList.subList(0, 2).clear();
			System.out.print(countryList+ " " +counter);
			
			//System.out.println(sheet.getPhysicalNumberOfRows()-countryList.size());
            String Month[]= {"feb", "mar","apr","may","jun","jul","aug","sept","oct","nov","dec","jan"};
			for(int q=0;q<Month.length;q++)
            {
				
                	 for(int k=2;k<=countryList.size()+1;k++)
            		 {
            			 	 Row row = sheet.getRow(k);
            			 	
            			 	Cell ppm = row.getCell(0);
            			 	Cell sourcing_director = row.getCell(1);
            			 	Cell sourcing_manager = row.getCell(2);
            			 	Cell major_category = row.getCell(3);
            			 	Cell sourcing_category = row.getCell(4);
            			 	Cell sourcing_sub_cat = row.getCell(5);
            			 	Cell classification = row.getCell(6);
            			 	Cell rpt_supplier = row.getCell(7);
            			 	Cell rpt_brand = row.getCell(8);
            			 	Cell country = row.getCell(9);
            			 	Cell plan_level = row.getCell(10);
            			 	
            			 	 Cell plan_name= row.getCell(11);
            			 	//plan_name=(row.getCell(11).getStringCellValue());
            			 	Cell channel = row.getCell(12);
            			 	Cell fashion_or_replenishment = row.getCell(13);
            			 	Cell pps = row.getCell(14);
            			 	Cell flow_model = row.getCell(15);
            			 	Cell division = row.getCell(16);
            			 	Cell sub = row.getCell(17);
            			 	Cell lot = row.getCell(18);
            			 	Cell ppk = row.getCell(19);
            			 	Cell dir = row.getCell(20);
            			 	Cell item_description = row.getCell(21);
            			 	
            			 	Cell units = row.getCell(22+q);
            			 	Cell fob$=row.getCell(35+q);
            			 	//System.out.print(fob$.getCel);
            			 	if(fob$.getCellType()==2)
            			 	{
            			 		fob$=null;
            			 	}
            			 	//fob$=(fob_dol.getNumericCellValue());
            			 	String month= Month[q];            			 	
            			 	
            			 	Cell avg_fob = row.getCell(48+q);
            			 	Cell commment = row.getCell(60);
            			 	
            		        
            			 	
            			 	int m =0;
                             pstm.setString(++m, String.valueOf(ppm));
                             pstm.setString(++m, String.valueOf(sourcing_director));
                             pstm.setString(++m, String.valueOf(sourcing_manager));
                             pstm.setString(++m, String.valueOf(major_category));
                             pstm.setString(++m, String.valueOf(sourcing_category));
                             pstm.setString(++m, String.valueOf(sourcing_sub_cat));
                             pstm.setString(++m, String.valueOf(classification));
                             pstm.setString(++m, String.valueOf(rpt_supplier));
                             pstm.setString(++m, String.valueOf(rpt_brand));
                             pstm.setString(++m, String.valueOf(country));
                             pstm.setString(++m, String.valueOf(plan_level));
                             pstm.setString(++m, String.valueOf(plan_name));
                             pstm.setString(++m, String.valueOf(channel));
                             pstm.setString(++m, String.valueOf(fashion_or_replenishment));
                             pstm.setString(++m, String.valueOf(pps));
                             pstm.setString(++m, String.valueOf(flow_model));
                             pstm.setString(++m, String.valueOf(division));
                             pstm.setString(++m, String.valueOf(sub));
                             pstm.setString(++m, String.valueOf(lot));
                             pstm.setString(++m, String.valueOf(ppk));
                             pstm.setString(++m, String.valueOf(dir));
                             pstm.setString(++m, String.valueOf(item_description));
                             pstm.setString(++m, String.valueOf(year));
                             pstm.setString(++m, String.valueOf(month));
                             pstm.setString(++m, String.valueOf(units));
                             pstm.setString(++m, String.valueOf(fob$));
                             pstm.setString(++m, String.valueOf(avg_fob));
                             pstm.setString(++m, String.valueOf(fdp_id));
                             pstm.setString(++m, String.valueOf(commment));	
                        	
                             pstm.addBatch();
                             
                             if (k % 500 == 0) {
                              	
                                 pstm.executeBatch();
                                 
                              }
            			 	 
                            
            		 }
                	 
                    
            		} 
                		 
                			
                		 
                		
                     
                
                
                
                
                
                
                
                //System.out.println("value initiated");
   

	 
	 
			
                  
            
                
            pstm.executeBatch();
            
           
            con.commit();
            
            con.close();
            
        System.out.println("Success");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
        
    }
	public static void main(String args[])
	{
		
		 String Path="C:\\Users\\rjain6\\Downloads\\2016_Jan_Stubbs_Kaiser_Lindblad_Childrens Knits-Sweaters-Wovens.xlsx";
		 String filename="2016_Jan_Stubbs_Kaiser_Lindblad_Childrens Knits-Sweaters-Wovens.xlsx";
		 FdpFileNameExtracter fx= new FdpFileNameExtracter();
		 fx.getinsert(Path, filename);
	}
}
