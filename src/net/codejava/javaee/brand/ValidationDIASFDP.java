package net.codejava.javaee.brand;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.*;
import java.util.*;

import javax.mail.FetchProfile.Item;
import javax.servlet.Filter;
import javax.ws.rs.BeanParam;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ValidationDIASFDP  
{  
	static String jdbcURL;
	static  String jdbcUsername;
	static String jdbcPassword;
	static Connection jdbcConnection;
	static boolean flag1=true;
	static boolean flag2=true;
	static boolean flag3=true;
	static boolean flagFinal;
	static int headervaluecount=0;
	ArrayList<String> Headerlist= new ArrayList<String>();
	ArrayList<String> ErrorList = new ArrayList<String>();
	ArrayList Ppm = new ArrayList();
	ArrayList Sourcing_director = new ArrayList();
	ArrayList Sourcing_manager = new ArrayList();
	ArrayList Major_category = new ArrayList();
	ArrayList Sourcing_category = new ArrayList();
	ArrayList Sourcing_sub_cat = new ArrayList();
	ArrayList Classification = new ArrayList();
	ArrayList Rpt_supplier = new ArrayList();
	ArrayList Rpt_brand = new ArrayList();
	ArrayList Country = new ArrayList();
	ArrayList Plan_level = new ArrayList();
	ArrayList Plan_name= new ArrayList();
	ArrayList Channel = new ArrayList();
	ArrayList Fashion_or_replenishment = new ArrayList();
	ArrayList Pps = new ArrayList();
	ArrayList Flow_model = new ArrayList();
	ArrayList Division = new ArrayList();
	ArrayList Sub = new ArrayList();
	ArrayList Lot = new ArrayList();
	ArrayList Ppk = new ArrayList();
	ArrayList Dir = new ArrayList();
	ArrayList Item_description = new ArrayList();
	ArrayList unit= new ArrayList();
	ArrayList dol=new ArrayList();
	//String Month= Month[q];            			 	
	ArrayList avgFob = new ArrayList();
	ArrayList Commment = new ArrayList();
	TreeMap<Integer,ArrayList<String>> ErrorMap=new TreeMap<Integer,ArrayList<String>>();
	static boolean counter1,counter2,counter3,counter4,counter5,counter6,counter7,counter8;
	public ValidationDIASFDP(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		ValidationDIASFDP.jdbcURL = "jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433";
		ValidationDIASFDP.jdbcUsername = "sqladmin";
		ValidationDIASFDP.jdbcPassword = "sqladmin2017";
	}
	
	 static void connect() throws SQLException {
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
	
	 static void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public  List<String> listCountry() throws SQLException {
		ArrayList<String> DIASFDPUpload = new ArrayList<String>();
		
		String sql = "SELECT DISTINCT country_name FROM  SA_ANALYTICS.spt.country_management_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			String country_name= resultSet.getString("country_name");
			//DIASFDPUpload DIASFDPUpload1 =  new DIASFDPUpload(country_name);
			DIASFDPUpload.add(country_name);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public ArrayList<String> listRptBrand() throws SQLException {
		ArrayList<String> DIASFDPUploadrptBrand = new ArrayList<String>();
		
		String sql = "SELECT DISTINCT rpt_brand FROM  SA_ANALYTICS.spt.brand_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			
			String rpt_brand= resultSet.getString("rpt_brand");
			
			//DIASFDPUploadBrand BRANDlist =  new DIASFDPUploadBrand(rpt_brand);
			DIASFDPUploadrptBrand.add(rpt_brand);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUploadrptBrand;
	}
	
	public  ArrayList<String> listSupplierList() throws SQLException {
		ArrayList<String> listSupplierList = new ArrayList<String>();
		
		String sql = "select DISTINCT  rpt_supplier from SA_ANALYTICS.spt.supplier_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			
			String rpt_supplier= resultSet.getString("rpt_supplier");
			
			
			//DIASDFDPUploadSupplier supplierList = new DIASDFDPUploadSupplier(rpt_supplier);
			listSupplierList.add(rpt_supplier);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
	public  ArrayList<String> getmajorCat() throws SQLException {
		ArrayList<String> listSupplierList = new ArrayList<String>();
		
		String sql = "select DISTINCT  major_category from SA_ANALYTICS.spt.category_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			
			String major_category= resultSet.getString("major_category");
			
			
			//DIASDFDPUploadSupplier supplierList = new DIASDFDPUploadSupplier(rpt_supplier);
			listSupplierList.add(major_category);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
	public  ArrayList<String> getSoucingCat() throws SQLException {
		ArrayList<String> listSupplierList = new ArrayList<String>();
		
		String sql = "select DISTINCT  sourcing_category from SA_ANALYTICS.spt.category_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			
			String sourcing_cat= resultSet.getString("sourcing_category");
			
			
			//DIASDFDPUploadSupplier supplierList = new DIASDFDPUploadSupplier(rpt_supplier);
			listSupplierList.add(sourcing_cat);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
	public  ArrayList<String> getSourcingSub() throws SQLException {
		ArrayList<String> listSupplierList = new ArrayList<String>();
		
		String sql = "select DISTINCT  sourcing_sub_category from SA_ANALYTICS.spt.category_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			
			String sourcing_sub_cat= resultSet.getString("sourcing_sub_category");
			
			
			//DIASDFDPUploadSupplier supplierList = new DIASDFDPUploadSupplier(rpt_supplier);
			listSupplierList.add(sourcing_sub_cat);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
	public  ArrayList<String> getClassi() throws SQLException {
		ArrayList<String> listSupplierList = new ArrayList<String>();
		
		String sql = "select DISTINCT classification   from SA_ANALYTICS.spt.category_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while (resultSet.next()) {
			
			
			String classification= resultSet.getString("classification");
			
			
			//DIASDFDPUploadSupplier supplierList = new DIASDFDPUploadSupplier(rpt_supplier);
			listSupplierList.add(classification);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
	public  ArrayList<String> removeDuplicates(ArrayList<String> list) 
    { 
  
        // Create a new LinkedHashSet 
        Set<String> set = new LinkedHashSet<String>(); 
  
        // Add the elements to set 
        set.addAll(list); 
  
        // Clear the list 
        list.clear(); 
  
        // add the elements of set 
        // with no duplicates to the list 
        list.addAll(set); 
  
        // return the list 
        return list; 
        
       
    }

	
	public boolean ValidateFDPFile(String path,String ErrorFilePath)
	{
		
		try  
		{  
			
//			//PrintStream o = new PrintStream(new File("C:\\Users\\rjain6\\Desktop\\jcpenney\\logs.txt"));
//			PrintStream o = new PrintStream(new File("D:\\SPT Application Log\\FDPlogs.txt"));
//	        // Store current System.out before assigning a new value 
//	        PrintStream console = System.out; 
//	  
//	        // Assign o to output stream 
//	        System.setOut(o); 
	        
	       
			//ValidationDIASFDP fdp= new ValidationDIASFDP("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
			List<String> ctry= listCountry();
			List<String> DIASFDPUploadrptBrand= listRptBrand();
			List<String> supplierlst= listSupplierList();
			ArrayList<String> majorcat= getmajorCat();
			ArrayList<String> SourcingSub= getSourcingSub();
			ArrayList<String> SourcingCat= getSoucingCat();
			ArrayList<String> classi=getClassi();
			 //Workbook workbook = new XSSFWorkbook(inputStream);
			 File myFile = new File(path);
	         FileInputStream fis = new FileInputStream(myFile);

	            // Finds the workbook instance for XLSX file
	         XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
			
			//XSSFWorkbook workBook = new XSSFWorkbook();
			Sheet sheet = myWorkBook.getSheetAt(0);
			 int rowTotal = sheet.getLastRowNum();

			 if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
			     rowTotal++;
			 }
			 String[] HeaderNames={"PPM","Sourcing Director","Sourcing Manager","Major Category","Sourcing Category","Sourcing Sub-Cat","Classification","Rpt. Supplier","Rpt. Brand","Country","Plan Level","Plan Name","Channel","Fashion or Replenishment","PPS","Flow Model","Division","Sub","Lot","PPK","DIR","Item Description","Feb Units","Mar Units","Apr Units","May Units","Jun Units","Jul Units","Aug Units","Sep Units","Oct Units","Nov Units","Dec Units","Jan Units","TOTAL UNITS","Feb FOB$","Mar FOB$","Apr FOB$","May FOB$","Jun FOB$","Jul FOB$","Aug FOB$","Sep FOB$","Oct FOB$","Nov FOB$","Dec FOB$","Jan FOB$","TOTAL $","Avg FOB Feb","Avg FOB March","Avg FOB April","Avg FOB May","Avg FOB June","Avg FOB July","Avg FOB Aug","Avg FOB Sept","Avg FOB Oct","Avg FOB Nov","Avg FOB Dec","Avg FOB Jan","Comments"}; 
			 for(int i=0;i<61;i++)
			 {
				 Cell k= sheet.getRow(1).getCell(i);
				 if(!(String.valueOf(k).equalsIgnoreCase(HeaderNames[i])));
				 {
					 headervaluecount=headervaluecount+1;

				 }
				
				 //if(String.valueOf(k).equalsIgnoreCase(anotherString))
			 }
			 if(headervaluecount>0)
				{
					
					 Headerlist.add("Error Description;Column header does not match required template");
				}
				else
				{
					
					 Headerlist.add("Error Description");
				}
			//creating a Sheet object to retrieve object  
			//Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			String Month[]= {"feb", "mar","apr","may","jun","jul","aug","sept","oct","nov","dec","jan"};
			
				
                	 for(int k=0;k<rowTotal;k++)
            		 {
            			  Row row = sheet.getRow(2+k);
            			 	
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
            			 	Cell units;
            			 	Cell fob$ = null;
            			 	Cell avg_fob=null;
            			 	for(int q=0;q<Month.length;q++)
            	            {
            			 	 units = row.getCell(22+q);
            			 	
            			 	 fob$=row.getCell(35+q);
            			 	
            			 	String month= Month[q];            			 	
            			 	
            			 	 avg_fob = row.getCell(48+q);
            			 
//            			 	Units.add(units);
//            			 	Fob$.add(fob$);
//            			 	//String Month Month[q];            			 	
//            			 	Avg_fob.add(avg_fob);
            			 	
            			 	
            			 	//ArrayList dol = new ArrayList();
            			 	
            			 	//ArrayList avgFob = new ArrayList();
            			 	
            			 	
            			 	
            			 	
            			 	
            			 	
            	            }
            			 	Cell commment = row.getCell(60);
            			 	
            			 	Ppm.add(ppm);
        					Sourcing_director.add(sourcing_director);
            			 	Sourcing_manager.add(sourcing_manager);
            			 	Major_category.add(major_category);
            			 	Sourcing_category.add(sourcing_category);
            			 	Sourcing_sub_cat.add(sourcing_sub_cat);
            			 	Classification.add(classification);
            			 	Rpt_supplier.add(rpt_supplier);
            			 	Rpt_brand.add(rpt_brand);
            			 	Country.add(country);
            			 	Plan_level.add(plan_level);
            			 	Plan_name.add(plan_name);
            			 	Channel.add(channel);
            			 	Fashion_or_replenishment.add(fashion_or_replenishment);
            			 	Pps.add(pps);
            			 	Flow_model.add(flow_model);
            			 	Division.add(division);
            			 	Sub.add(sub);
            			 	Lot.add(lot);
            			 	Ppk.add(ppk);
            			 	Dir.add(dir);
            			 	Item_description.add(item_description);
            			 	dol.add(fob$);
            			 	avgFob.add(avg_fob);
            			 	Commment.add(commment);
//            			 	if(!((String.valueOf(unit.get(k)).equals(null)||String.valueOf(unit.get(k)).equals("")||String.valueOf(unit.get(k)).equals(" ")||String.valueOf(unit.get(k)).isEmpty()||String.valueOf(unit.get(k)).length()==0||String.valueOf(unit.get(k)).trim().isEmpty()||unit.get(k)==null)
//                    			 	||(String.valueOf(avgFob.get(k)).equals(null)||String.valueOf(avgFob.get(k)).equals("")||String.valueOf(avgFob.get(k)).equals(" ")||String.valueOf(avgFob.get(k)).isEmpty()||String.valueOf(avgFob.get(k)).length()==0||String.valueOf(avgFob.get(k)).trim().isEmpty()||avgFob.get(k)==null)))
//                    			 	{
//                    			 		ErrorList.add("Avg FOB required when Units contains a value for the same month;");
//                    			 	}
//                    			 	if(!(String.valueOf(unit.get(k)).equals(null)||String.valueOf(unit.get(k)).equals("")||String.valueOf(unit.get(k)).equals(" ")||String.valueOf(unit.get(k)).isEmpty()||String.valueOf(unit.get(k)).length()==0||String.valueOf(unit.get(k)).trim().isEmpty()||unit.get(k)==null))
//                    			 	{
//                    			 		if(!(String.valueOf(unit.get(k)).matches("[0-9]+")))
//                    			 				{
//                    			 					ErrorList.add("Unit should be numeric;");
//                    			 				}
//                    			 	}
//                    			 	if(!(String.valueOf(dol.get(k)).equals(null)||String.valueOf(dol.get(k)).equals("")||String.valueOf(dol.get(k)).equals(" ")||String.valueOf(dol.get(k)).isEmpty()||String.valueOf(dol.get(k)).length()==0||String.valueOf(dol.get(k)).trim().isEmpty()||dol.get(k)==null))
//                    			 	{
//                    			 		if(!(String.valueOf(dol.get(k)).matches("[0-9]+")))
//                    			 				{
//                    			 					ErrorList.add("Dollar should be numeric;");
//                    			 				}
//                    			 	}
            			 	if(String.valueOf(Ppm.get(k)).equals(null)||String.valueOf(Ppm.get(k)).equals("")||String.valueOf(Ppm.get(k)).equals(" ")||String.valueOf(Ppm.get(k)).isEmpty()||String.valueOf(Ppm.get(k)).length()==0||String.valueOf(Ppm.get(k)).trim().isEmpty()||Ppm.get(k)==null)
        					{
        						ErrorList.add("PPM required;");
        					}
            			 	if(String.valueOf(Plan_level.get(k)).equals(null)||String.valueOf(Plan_level.get(k)).equals("")||String.valueOf(Plan_level.get(k)).equals(" ")||String.valueOf(Plan_level.get(k)).isEmpty()||String.valueOf(Plan_level.get(k)).length()==0||String.valueOf(Plan_level.get(k)).trim().isEmpty()||Plan_level.get(k)==null)
        					{
        						ErrorList.add("Plan level required;");
        					}
            			 	else if((!(String.valueOf(Plan_level.get(k)).matches("^[a-zA-Z\\s]*$"))) && ((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("P")||String.valueOf(Plan_level.get(k)).equalsIgnoreCase("C")||String.valueOf(Plan_level.get(k)).equalsIgnoreCase("I"))))
							{
								ErrorList.add("Accepted values for Plan Level are P, C and I;");
							}
            			 	if(String.valueOf(Rpt_supplier.get(k)).equals(null)||String.valueOf(Rpt_supplier.get(k)).equals("")||String.valueOf(Rpt_supplier.get(k)).equals(" ")||String.valueOf(Rpt_supplier.get(k)).isEmpty()||String.valueOf(Rpt_supplier.get(k)).length()==0||String.valueOf(Rpt_supplier.get(k)).trim().isEmpty()||Rpt_supplier.get(k)==null||String.valueOf(Rpt_supplier.get(k)).isEmpty())
        					{
        						ErrorList.add("Rpt. Supplier required;");
        					}
            			 	else if((!(supplierlst.contains(Rpt_supplier.get(k)))) || (!(String.valueOf(Rpt_supplier.get(k)).matches("^[a-zA-Z\\s]*$"))))
            			 	{
            			 		ErrorList.add("Rpt. Supplier does not exist in SPT;");
            			 	}
            			 	else 
            				{
            					connect();
            					PreparedStatement preparedStatement2 =jdbcConnection.prepareStatement("select *  from SA_ANALYTICS.spt.supplier_master where major_category like ? and rpt_supplier in (?)");
            					connect();
            					preparedStatement2.setString(1,"%" + String.valueOf(Major_category.get(k)) + "%");
            					preparedStatement2.setString(2,String.valueOf(Rpt_supplier.get(k)));
            					ResultSet resultSet2 = preparedStatement2.executeQuery();
            					while (!resultSet2.next()) {
            						ErrorList.add("Rpt. Supplier is not linked with the Major Category in SPT;");
            					}
            					
            				}
            			 	if((!(String.valueOf(Rpt_brand.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Rpt_brand.get(k)).equals(null)||String.valueOf(Rpt_brand.get(k)).equals("")||String.valueOf(Rpt_brand.get(k)).equals(" ")||String.valueOf(Rpt_brand.get(k)).isEmpty()||String.valueOf(Rpt_brand.get(k)).length()==0||String.valueOf(Rpt_brand.get(k)).trim().isEmpty()||Rpt_brand.get(k)==null||String.valueOf(Rpt_supplier.get(k)).isEmpty())))
        					{
        						ErrorList.add("Rpt. Brand required;");
        					}
            			 	else if((!(DIASFDPUploadrptBrand.contains(Rpt_brand.get(k)))) || (!(String.valueOf(Rpt_brand.get(k)).matches("^[a-zA-Z\\s]*$"))))
            			 	{
            			 		ErrorList.add("Rpt. Brand does not exist in SPT;");
            			 	}
            			 	if((!(String.valueOf(Plan_name.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Plan_name.get(k)).equals(null)||String.valueOf(Plan_name.get(k)).equals("")||String.valueOf(Plan_name.get(k)).equals(" ")||String.valueOf(Plan_name.get(k)).isEmpty()||String.valueOf(Plan_name.get(k)).length()==0||String.valueOf(Plan_name.get(k)).trim().isEmpty()||Plan_name.get(k)==null||String.valueOf(Plan_name.get(k)).isEmpty())))
        					{
        						ErrorList.add("Plan Name required;");
        					}
            			 	else if(String.valueOf(Plan_name.get(k)).length()>96)
        					{
        						ErrorList.add("Plan Name cannot exceed 96 characters");
        					}
            			 	if(((String.valueOf(Division.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Division.get(k)).equals(null)||String.valueOf(Division.get(k)).equals("")||String.valueOf(Division.get(k)).equals(" ")||String.valueOf(Division.get(k)).isEmpty()||String.valueOf(Division.get(k)).length()==0||String.valueOf(Division.get(k)).trim().isEmpty()||Division.get(k)==null||String.valueOf(Division.get(k)).isEmpty())))
        					{
        						ErrorList.add("Division required;");
        					}
            			 	else if((!(String.valueOf(Division.get(k)).matches("[0-9]+")))||String.valueOf(Division.get(k)).matches("^[a-zA-Z\\s]*$"))
            			 	{
            			 		ErrorList.add("Accepted value of division are between 0-9;");
            			 	}
            			 	else
            			 	{
            			 		ErrorList.add("System cannot change Division Number for an existing plan");
            			 	}
            			 	if((!(String.valueOf(Sourcing_director.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Sourcing_director.get(k)).equals(null)||String.valueOf(Sourcing_director.get(k)).equals("")||String.valueOf(Sourcing_director.get(k)).equals(" ")||String.valueOf(Sourcing_director.get(k)).isEmpty()||String.valueOf(Sourcing_director.get(k)).length()==0||String.valueOf(Sourcing_director.get(k)).trim().isEmpty()||Sourcing_director.get(k)==null||String.valueOf(Sourcing_director.get(k)).isEmpty())))
        					{
        						ErrorList.add("Sourcing Director required;");
        					}
            			 	if((!(String.valueOf(Major_category.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Major_category.get(k)).equals(null)||String.valueOf(Major_category.get(k)).equals("")||String.valueOf(Major_category.get(k)).equals(" ")||String.valueOf(Major_category.get(k)).isEmpty()||String.valueOf(Major_category.get(k)).length()==0||String.valueOf(Major_category.get(k)).trim().isEmpty()||Major_category.get(k)==null||String.valueOf(Major_category.get(k)).isEmpty())))
        					{
        						ErrorList.add("Major Category required;");
        					}
            			 	else if(!majorcat.contains(String.valueOf(Major_category.get(k))))
            			 	{
            			 		ErrorList.add("Major Category does not exists in SPT;");
            			 	}
            			 	else 
            				{
            					connect();
            					PreparedStatement preparedStatement2 =jdbcConnection.prepareStatement("select *  from SA_ANALYTICS.spt.supplier_master where major_category like ? and rpt_supplier in (?)");
            					connect();
            					preparedStatement2.setString(1,"%" + String.valueOf(Major_category.get(k)) + "%");
            					preparedStatement2.setString(2,String.valueOf(Rpt_supplier.get(k)));
            					ResultSet resultSet2 = preparedStatement2.executeQuery();
            					while (!resultSet2.next()) {
            						ErrorList.add("Major Category is not linked with Rpt. Supplier in SPT.;");
            					}
            					
            				}
            			 	if((!(String.valueOf(Sourcing_sub_cat.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Sourcing_sub_cat.get(k)).equals(null)||String.valueOf(Sourcing_sub_cat.get(k)).equals("")||String.valueOf(Sourcing_sub_cat.get(k)).equals(" ")||String.valueOf(Sourcing_sub_cat.get(k)).isEmpty()||String.valueOf(Sourcing_sub_cat.get(k)).length()==0||String.valueOf(Sourcing_sub_cat.get(k)).trim().isEmpty()||Sourcing_sub_cat.get(k)==null||String.valueOf(Sourcing_sub_cat.get(k)).isEmpty())))
        					{
        						ErrorList.add("Sourcing Sub Category required;");
        					}
            			 	else if(!SourcingSub.contains(String.valueOf(Sourcing_sub_cat.get(k)))) 
            			 	{
            			 		ErrorList.add("Sourcing Sub Category does not exists in SPT;");
            			 	}
            			 	else 
        					{
        						connect();
        						
        						PreparedStatement preparedStatement1 =jdbcConnection.prepareStatement("select * from SA_ANALYTICS.spt.category_master where sourcing_category like ? and sourcing_sub_category like ?");
        						connect();
        						preparedStatement1.setString(1,"%" + String.valueOf(Sourcing_category.get(k)) + "%");
        						preparedStatement1.setString(2,"%" + String.valueOf(Sourcing_sub_cat.get(k)) + "%");
        						ResultSet resultSet1 = preparedStatement1.executeQuery();
        						while (!resultSet1.next()) {
        							ErrorList.add("Country is not linked with Rpt. Supplier;");
        						}
        						
        					}
            			 	if((!(String.valueOf(Sourcing_category.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Sourcing_category.get(k)).equals(null)||String.valueOf(Sourcing_category.get(k)).equals("")||String.valueOf(Sourcing_category.get(k)).equals(" ")||String.valueOf(Sourcing_category.get(k)).isEmpty()||String.valueOf(Sourcing_category.get(k)).length()==0||String.valueOf(Sourcing_category.get(k)).trim().isEmpty()||Sourcing_category.get(k)==null||String.valueOf(Sourcing_category.get(k)).isEmpty())))
        					{
        						ErrorList.add("Sourcing Category required;");
        					}
            			 	else if(!SourcingCat.contains(String.valueOf(Sourcing_category.get(k)))) 
            			 	{
            			 		ErrorList.add("Sourcing Category does not exists in SPT;");
            			 	}
            			 	else 
        					{
        						connect();
        						
        						PreparedStatement preparedStatement1 =jdbcConnection.prepareStatement("select * from SA_ANALYTICS.spt.category_master where sourcing_category like ? and major_category like ?");
        						connect();
        						preparedStatement1.setString(1,"%" + String.valueOf(Sourcing_category.get(k)) + "%");
        						preparedStatement1.setString(2,"%" + String.valueOf(Major_category.get(k)) + "%");
        						ResultSet resultSet1 = preparedStatement1.executeQuery();
        						while (!resultSet1.next()) {
        							ErrorList.add("Sourcing Category is not linked with Major Category in SPT;");
        						}
        						
        					}
            			 	if((!(String.valueOf(Country.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Country.get(k)).equals(null)||String.valueOf(Country.get(k)).equals("")||String.valueOf(Country.get(k)).equals(" ")||String.valueOf(Country.get(k)).isEmpty()||String.valueOf(Country.get(k)).length()==0||String.valueOf(Country.get(k)).trim().isEmpty()||Country.get(k)==null||String.valueOf(Country.get(k)).isEmpty())))
        					{
        						ErrorList.add("Country required;");
        					}
            			 	else if(!ctry.contains(String.valueOf(Country.get(k)))) 
            			 	{
            			 		ErrorList.add("Country does not exists in SPT;");
            			 	}
            			 	else 
        					{
        						connect();
        						
        						PreparedStatement preparedStatement1 =jdbcConnection.prepareStatement("select * from SA_ANALYTICS.spt.supplier_master where country like ? and rpt_supplier in (?)");
        						connect();
        						preparedStatement1.setString(1,"%" + String.valueOf(Country.get(k)) + "%");
        						preparedStatement1.setString(2,String.valueOf(Rpt_supplier.get(k)));
        						ResultSet resultSet1 = preparedStatement1.executeQuery();
        						while (!resultSet1.next()) {
        							ErrorList.add("Country is not linked with Rpt. Supplier;");
        						}
        						
        					}
            			 	if(((!(String.valueOf(Classification.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Classification.get(k)).equals(null)||String.valueOf(Classification.get(k)).equals("")||String.valueOf(Classification.get(k)).equals(" ")||String.valueOf(Classification.get(k)).isEmpty()||String.valueOf(Classification.get(k)).length()==0||String.valueOf(Classification.get(k)).trim().isEmpty()||Classification.get(k)==null||String.valueOf(Classification.get(k)).isEmpty()))) && 
            			 			((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("C"))||((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("I")))))
            			 	{
            			 		ErrorList.add("Classification required;");
            			 	}
            			 	else if(!classi.contains(String.valueOf(Classification.get(k)))) 
            			 	{
            			 		ErrorList.add("Classification does not exists in SPT;");
            			 	}
            			 	else 
        					{
        						connect();
        						PreparedStatement preparedStatement1 =jdbcConnection.prepareStatement("select * from SA_ANALYTICS.spt.category_master where classification like ? and sourcing_sub_category like ?");
        						connect();
        						preparedStatement1.setString(1,"%" + String.valueOf(Classification.get(k)) + "%");
        						preparedStatement1.setString(2,"%" + String.valueOf(Sourcing_sub_cat.get(k)) + "%");
        						ResultSet resultSet1 = preparedStatement1.executeQuery();
        						while (!resultSet1.next()) {
        							ErrorList.add("Classification is not linked with Sourcing Sub-Cat in SPT;");
        						}
        						
        					}
            			 	if(((String.valueOf(Sub.get(k)).matches("^[a-zA-Z\\s]*$") && (String.valueOf(Sub.get(k)).equals(null)||String.valueOf(Sub.get(k)).equals("")||String.valueOf(Sub.get(k)).equals(" ")||String.valueOf(Sub.get(k)).isEmpty()||String.valueOf(Sub.get(k)).length()==0||String.valueOf(Sub.get(k)).trim().isEmpty()||Sub.get(k)==null||String.valueOf(Sub.get(k)).isEmpty()))) && 
            			 			((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("C"))||((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("I"))||(String.valueOf(Plan_level.get(k)).equalsIgnoreCase("P")))))
            			 	{
            			 		ErrorList.add("Sub required;");
            			 	}
            			 	
            			 	else if(String.valueOf(Sub.get(k)).matches("^[a-zA-Z\\s]*$") && (String.valueOf(Sub.get(k)).length()>3))
            			 	{
            			 		ErrorList.add("Sub must be numeric and cannot exceed 3 digits;");
            			 	}
            			 	else 
        					{
        						connect();
        						
        						PreparedStatement preparedStatement1 =jdbcConnection.prepareStatement("select * from SA_ANALYTICS.spt.mdse_master where subdivison_number= ? and division_number like ?");
        						connect();
        						preparedStatement1.setString(1,"%" + String.valueOf(Sub.get(k)) + "%");
        						preparedStatement1.setString(2,"%" + String.valueOf(Division.get(k)) + "%");
        						ResultSet resultSet1 = preparedStatement1.executeQuery();
        						while (!resultSet1.next()) {
        							ErrorList.add("Sub is not linked with Division in SPT;");
        						}
        						
        					}
            			 	if(!((String.valueOf(Dir.get(k)).matches("^[a-zA-Z\\s]*$") && (String.valueOf(Dir.get(k)).equals(null)||String.valueOf(Dir.get(k)).equals("")||String.valueOf(Dir.get(k)).equals(" ")||String.valueOf(Dir.get(k)).isEmpty()||String.valueOf(Dir.get(k)).length()==0||String.valueOf(Dir.get(k)).trim().isEmpty()||Dir.get(k)==null||String.valueOf(Dir.get(k)).isEmpty()))||String.valueOf(Dir.get(k)).equalsIgnoreCase("Y")||String.valueOf(Dir.get(k)).equalsIgnoreCase("N")))
            			 	{
            			 		ErrorList.add("DIR must be Y, N or blank.;");
            			 	}
            			 	if(((!(String.valueOf(Item_description.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Item_description.get(k)).equals(null)||String.valueOf(Item_description.get(k)).equals("")||String.valueOf(Item_description.get(k)).equals(" ")||String.valueOf(Item_description.get(k)).isEmpty()||String.valueOf(Item_description.get(k)).length()==0||String.valueOf(Item_description.get(k)).trim().isEmpty()||Item_description.get(k)==null||String.valueOf(Item_description.get(k)).isEmpty()))) && 
            			 			((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("C"))||((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("I"))||((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("P"))))))
            			 	{
            			 		ErrorList.add("Item Description required when Plan Level = I or when Plan Level = P or C;");
            			 	}
            			 	else if(String.valueOf(Item_description.get(k)).length()>40)
            			 	{
            			 		ErrorList.add("Item Description cannot exceed 40 characters;");
            			 	}
            			 	if(((String.valueOf(Lot.get(k)).matches("^[a-zA-Z\\s]*$") && (String.valueOf(Lot.get(k)).equals(null)||String.valueOf(Lot.get(k)).equals("")||String.valueOf(Lot.get(k)).equals(" ")||String.valueOf(Lot.get(k)).isEmpty()||String.valueOf(Lot.get(k)).length()==0||String.valueOf(Lot.get(k)).trim().isEmpty()||Lot.get(k)==null||String.valueOf(Lot.get(k)).isEmpty()))) && 
            			 		((String.valueOf(Plan_level.get(k)).equalsIgnoreCase("I"))))	
            			 	{
            			 		ErrorList.add("Lot required;");
            			 	} 
            			 	else if(String.valueOf(Lot.get(k)).matches("^[a-zA-Z\\s]*$") && (String.valueOf(Lot.get(k)).length()>4))
            			 	{
            			 		ErrorList.add("Lot must be numeric and cannot exceed 3 digits;");
            			 	}
            			 	
            			 	if((!(String.valueOf(Channel.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Channel.get(k)).equals(null)||String.valueOf(Channel.get(k)).equals("")||String.valueOf(Channel.get(k)).equals(" ")||String.valueOf(Channel.get(k)).isEmpty()||String.valueOf(Channel.get(k)).length()==0||String.valueOf(Channel.get(k)).trim().isEmpty()||Channel.get(k)==null||String.valueOf(Channel.get(k)).isEmpty())))
        					{
        						ErrorList.add("Channel required;");
        					}
            			 	else if(!(String.valueOf(Channel.get(k)).equalsIgnoreCase("COM")||String.valueOf(Channel.get(k)).equalsIgnoreCase("Enterprise")||String.valueOf(Channel.get(k)).equalsIgnoreCase("Store")))
            			 	{
            			 		ErrorList.add("Accepted Channel values are .Com, Enterprise and Store");
            			 	}
            			 	if((!(String.valueOf(Fashion_or_replenishment.get(k)).matches("^[a-zA-Z\\s]*$")) && (String.valueOf(Fashion_or_replenishment.get(k)).equals(null)||String.valueOf(Fashion_or_replenishment.get(k)).equals("")||String.valueOf(Fashion_or_replenishment.get(k)).equals(" ")||String.valueOf(Fashion_or_replenishment.get(k)).isEmpty()||String.valueOf(Fashion_or_replenishment.get(k)).length()==0||String.valueOf(Fashion_or_replenishment.get(k)).trim().isEmpty()||Fashion_or_replenishment.get(k)==null||String.valueOf(Fashion_or_replenishment.get(k)).isEmpty())))
        					{
        						ErrorList.add("Fashion or Replenishment required;");
        					}
            			 	else if(!(String.valueOf(Fashion_or_replenishment.get(k)).equalsIgnoreCase("R")||String.valueOf(Fashion_or_replenishment.get(k)).equalsIgnoreCase("F")))
            			 	{
            			 		ErrorList.add("Accepted Fashion/Replenishment values are F, R");
            			 	}
            			 if(String.valueOf(Flow_model.get(k)).equals(null)||String.valueOf(Flow_model.get(k)).equals("")||String.valueOf(Flow_model.get(k)).equals(" ")||String.valueOf(Flow_model.get(k)).isEmpty()||String.valueOf(Flow_model.get(k)).length()==0||String.valueOf(Flow_model.get(k)).trim().isEmpty()||Flow_model.get(k)==null||String.valueOf(Flow_model.get(k)).isEmpty() &&
                			 		((String.valueOf(Fashion_or_replenishment.get(k)).equalsIgnoreCase("R"))))	
                			 	{
                			 		ErrorList.add("FLow Model required when Fashion_or_replenishment=R;");
                			 	}
            			 	else if(!((String.valueOf(Flow_model.get(k)).equalsIgnoreCase("3PL"))||(String.valueOf(Flow_model.get(k)).equalsIgnoreCase("HYB"))||(String.valueOf(Flow_model.get(k)).equalsIgnoreCase("DTS"))||(String.valueOf(Flow_model.get(k)).equalsIgnoreCase("FOB"))||(String.valueOf(Flow_model.get(k)).equalsIgnoreCase("NA2"))))
            			 	{
            			 		ErrorList.add("Accepted Flow Model values are 3PL, DTS, FOB, HYB and NA2;");
            			 	}
            			 	else if(String.valueOf(Fashion_or_replenishment.get(k)).equalsIgnoreCase("F") && (!(String.valueOf(Flow_model.get(k)).equalsIgnoreCase("FOB"))))
            			 	{
            			 		ErrorList.add("Accepted Flow Model is FOB when fashion or replinishment value is F;");
            			 	}
            			 	if(((String.valueOf(Pps.get(k)).matches("^[a-zA-Z\\s]*$") && (String.valueOf(Pps.get(k)).equals(null)||String.valueOf(Pps.get(k)).equals("")||String.valueOf(Pps.get(k)).equals(" ")||String.valueOf(Pps.get(k)).isEmpty()||String.valueOf(Pps.get(k)).length()==0||String.valueOf(Pps.get(k)).trim().isEmpty()||Pps.get(k)==null||String.valueOf(Pps.get(k)).isEmpty()))) && 
                			 		((String.valueOf(Fashion_or_replenishment.get(k)).equalsIgnoreCase("R"))))	
                			 	{
                			 		ErrorList.add("PPS required when Fashion_or_replenishment=R;");
                			 	}
            			 	
            			 		
            			 	else if(!(String.valueOf(Pps.get(k)).equalsIgnoreCase("Y")||String.valueOf(Pps.get(k)).equalsIgnoreCase("N")))
            			 	{
            			 		ErrorList.add("Accepted PPS values are Y and N");
            			 	}
            			 	if(!(String.valueOf(Ppk.get(k)).equals(null)||String.valueOf(Ppk.get(k)).equals("")||String.valueOf(Ppk.get(k)).equals(" ")||String.valueOf(Ppk.get(k)).isEmpty()||String.valueOf(Ppk.get(k)).length()==0||String.valueOf(Ppk.get(k)).trim().isEmpty()||Ppk.get(k)==null||String.valueOf(Ppk.get(k)).isEmpty()) && (String.valueOf(Ppk.get(k)).length()>10))
        					{
        						ErrorList.add("PPK value cannot exceed 10 characters;");
        					}
            			 	
            			 	
            			 	ErrorMap.put(k, ErrorList); 	
            	}
             
			ErrorMap.put(1, Headerlist);
			int errorCounterinList=0;
	           for(int s=1;s<rowTotal;s++)
	           {
	        	   ArrayList<String> lst= new ArrayList<String>();
	        	   lst=ErrorMap.get(s);
	        	  //System.out.println(s+ " size of list  " +lst.size());
	        	   if(!(lst.size()==0))
	        	   {
	        		   errorCounterinList=errorCounterinList+1;
	        	   }
	           }
	           int headerListSize=Headerlist.size();
	          //System.out.println(errorCounterinList);
	           if(errorCounterinList>0)
	           {
	        	   //System.out.println("i am here in if ");
	        	   flagFinal=false;
	        	   CreateErrorFileFDP cf= new CreateErrorFileFDP();
	        	   cf.createErrorFileFDP(path,ErrorFilePath, rowTotal, ErrorMap);
	        	   
	           }
	           else
	           {
	        	   //System.out.println("i am here in else");
	        	   flagFinal=true;
	        	   FileOutputStream outputStream = new FileOutputStream(path);
	   	       		myWorkBook.write(outputStream);
	            	outputStream.close();
	           }
			
		} 
		 
		catch(Exception e)  
		{  
			e.printStackTrace();
			
		}
		
		if(flagFinal)
			return true;
		else
			 return false;
	}
	
	
	
}