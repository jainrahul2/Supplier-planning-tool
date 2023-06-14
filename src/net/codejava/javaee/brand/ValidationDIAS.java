package net.codejava.javaee.brand;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.io.File;

import org.apache.poi.hssf.util.HSSFColor.YELLOW;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ValidationDIAS  
{  
	static String jdbcURL;
	static String jdbcUsername;
	static String jdbcPassword;
	static Connection jdbcConnection;
	static boolean flag1=true;
	static boolean flag2=true;
	static boolean flag3=true;
	static int rowcount=0;
	public static String REGEX = "(?:\\d+)((\\d{1,3})*([\\,\\ ]\\d{3})*)(\\.\\d+)?";
	//public static String REGEXForUnit = "^(?:\\d{1,3}(,\\d{3})*|\\d+|\\d{2}(?:,\\d{2})*,\\d{3})(?:\\.\\d+)?$";
	public static String REGEXForUnit = "^[0-9]+(?:-[0-9]+)?(,[0-9]+(?:-[0-9]+)?)*$";
	ArrayList<String> correctvalsupplier= new ArrayList<String>();
	static int headervaluecount=0;
	static boolean counter1,counter2,counter3,counter4,counter5,counter6,counter7,counter8,flagFinal,
	counter9,counter10,counter11,counter12,counter13,counter14,counter15,counter16,sublot,flagitemdesc,
	counter17,counter18,counter19,counter20,counter21,counter22,counter23,counter24,counter25,counter26,counter27,flag4;
	public ValidationDIAS(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
										jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	 static void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	 
//	 private void removeEmptyRows(XSSFSheet sheet) {
//		    Boolean isRowEmpty = Boolean.FALSE;
//		    for(int i = 0; i <= sheet.getLastRowNum(); i++){
//		      if(sheet.getRow(i)==null){
//		        isRowEmpty=true;
//		        sheet.shiftRows(i + 1, sheet.getLastRowNum()+1, -1);
//		        i--;
//		        continue;
//		      }
//		      for(int j =0; j<sheet.getRow(i).getLastCellNum();j++){
//		        if(sheet.getRow(i).getCell(j) == null || 
//		        sheet.getRow(i).getCell(j).toString().trim().equals("")){
//		          isRowEmpty=true;
//		        }else {
//		          isRowEmpty=false;
//		          break;
//		        }
//		      }
//		      if(isRowEmpty==true){
//		        sheet.shiftRows(i + 1, sheet.getLastRowNum()+1, -1);
//		        i--;
//		      }
//		    }
//		  }
	
	public  ArrayList<String> listCountry() throws SQLException {
		ArrayList<String> DIASFDPUpload = new ArrayList<String>();
		
		String sql = "SELECT DISTINCT country_name FROM  SA_ANALYTICS.spt.country_management_master ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//System.out.println("in validation A");
		while (resultSet.next()) {
			
			String country_name= resultSet.getString("country_name");
			//DIASUpload DIASFDPUpload1 =  new DIASUpload(country_name);
			DIASFDPUpload.add(country_name);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public  ArrayList<String> listRptBrand() throws SQLException {
		ArrayList<String> DIASFDPUploadrptBrand = new ArrayList<String>();
		
		String sql = "SELECT DISTINCT rpt_brand FROM  SA_ANALYTICS.spt.brand_master ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//System.out.println("In Vlaidation B");
		while (resultSet.next()) {
			
			
			String rpt_brand= resultSet.getString("rpt_brand");
			
			//DIASUploadBrand BRANDlist =  new DIASUploadBrand(rpt_brand);
			DIASFDPUploadrptBrand.add(rpt_brand);
			
		}
		
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUploadrptBrand;
	}
	public  List<String> listCountryin() throws SQLException {
		List<String> DIASFDPUpload = new ArrayList<>();
		
		String sql = "SELECT DISTINCT country_name FROM  SA_ANALYTICS.spt.country_management_master where status='inactive' ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//System.out.println("in validation A");
		while (resultSet.next()) {
			
			String country_name= resultSet.getString("country_name");
			//DIASUpload DIASFDPUpload1 =  new DIASUpload(country_name);
			DIASFDPUpload.add(country_name);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUpload;
	}
	public  List<String> listRptBrandin() throws SQLException {
		List<String> DIASFDPUploadrptBrand = new ArrayList<String>();
		
		String sql = "SELECT DISTINCT rpt_brand FROM  SA_ANALYTICS.spt.brand_master where status='inactive' ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//System.out.println("In Vlaidation B");
		while (resultSet.next()) {
			
			
			String rpt_brand= resultSet.getString("rpt_brand");
			
			//DIASUploadBrand BRANDlist =  new DIASUploadBrand(rpt_brand);
			DIASFDPUploadrptBrand.add(rpt_brand);
			
		}
		
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return DIASFDPUploadrptBrand;
	}
	public  ArrayList<String> getibo() throws SQLException {
		ArrayList<String> ibo = new ArrayList<String>();
		
		String sql = "select DISTINCT ibo from SA_ANALYTICS.spt.supplier_master ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//System.out.println("In Vlaidation B");
		while (resultSet.next()) {
			
			
			String ibo1= resultSet.getString("ibo");
			
			//DIASUploadBrand BRANDlist =  new DIASUploadBrand(rpt_brand);
			ibo.add(ibo1);
		}
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return ibo;
			
	}
		
		public  ArrayList<String> getsub() throws SQLException {
			ArrayList<String> sub = new ArrayList<String>();
			
			String sql = "select subdivison_number from SA_ANALYTICS.spt.mdse_master ";
			
			connect();
			
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			//System.out.println("In Vlaidation B");
			while (resultSet.next()) {
				
				
				String subdiv= resultSet.getString("subdivison_number");
				
				//DIASUploadBrand BRANDlist =  new DIASUploadBrand(rpt_brand);
				sub.add(subdiv);
				
			}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return sub;
	}
		public  ArrayList<String> getsupplernumber() throws SQLException {
			ArrayList<String> supp = new ArrayList<String>();
			
			String sql = "select supplier_number from SA_ANALYTICS.spt.supplier_master";
			
			connect();
			
			Statement statement = jdbcConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			//System.out.println("In Vlaidation B");
			while (resultSet.next()) {
				
				
				String supplnum= resultSet.getString("supplier_number");
				
				//DIASUploadBrand BRANDlist =  new DIASUploadBrand(rpt_brand);
				supp.add(supplnum);
				
			}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return supp;
	}
	public  List<String> listSupplierListin() throws SQLException {
		List<String> listSupplierList = new ArrayList<String>();
		
		String sql = "select DISTINCT  rpt_supplier from SA_ANALYTICS.spt.supplier_master where status='INACTIVE' ";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//System.out.println("in validation C");
		while (resultSet.next()) {
			
			
			String rpt_supplier= resultSet.getString("rpt_supplier");
			
			
			//DIASDUploadSupplier supplierList = new DIASDUploadSupplier(rpt_supplier);
			listSupplierList.add(rpt_supplier);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
//	public static boolean validateJavaDate(String d) 
//    { 
//		boolean flag=false;
//		String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$";
//		String regex1 = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{2}$";
//		String regex3="^(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)-(3[01]|[12][0-9]|0[1-9])-[0-9]{2}$";
//		String regex4="^(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)/(3[01]|[12][0-9]|0[1-9])/[0-9]{2}$";
//
//		Pattern pattern = Pattern.compile(regex);
//	    Pattern pattern1 = Pattern.compile(regex1);
//	    Pattern pattern3 = Pattern.compile(regex3);
//	    Pattern pattern4 = Pattern.compile(regex4);
//	    Matcher matcher = pattern.matcher((CharSequence) d);
//	    Matcher matcher1 = pattern1.matcher((CharSequence) d);
//	    Matcher matcher3 = pattern3.matcher((CharSequence) d);
//	    Matcher matcher4 = pattern4.matcher((CharSequence) d);
//	   if(matcher1.matches()||matcher.matches()||matcher3.matches()||matcher4.matches())
//	   {
//		   flag=true;
//		
//	   }
//	   else
//	   {
//		   flag=false;
//		   
//	   }
//	   return flag;
//    } 
//	public static boolean validatvaDate(String strDate)
//	   {
//		/* Check if date is 'null' */
//		if (strDate.trim().equals(""))
//		{
//		    return true;
//		}
//		/* Date is not 'null' */
//		else
//		{
//		    /*
//		     * Set preferred date format,
//		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
//		    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
//		    sdfrmt.setLenient(false);
//		    /* Create Date object
//		     * parse the string into date 
//	             */
//		    try
//		    {
//		        Date javaDate = sdfrmt.parse(strDate); 
//		        System.out.println(strDate+" is valid date format");
//		    }
//		    /* Date format is invalid */
//		    catch (ParseException e)
//		    {
//		        System.out.println(strDate+" is Invalid Date format");
//		        return false;
//		    }
//		    /* Return true if date format is valid */
//		    return true;
//		}
//	   }
//	public boolean getdigitCheck(String str)
//	{
//		boolean flag=true;
//		 if(str.matches("[1-8]+")) {
//	        flag=true;
//	      }
//		 else
//			 flag=false;
//		 return flag;
//	}
	public  ArrayList<String> listSupplierList() throws SQLException {
		ArrayList<String> listSupplierList = new ArrayList<String>();
		
		String sql = "select DISTINCT  rpt_supplier from SA_ANALYTICS.spt.supplier_master";
		
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		//System.out.println("in validation C");
		while (resultSet.next()) {
			
			
			String rpt_supplier= resultSet.getString("rpt_supplier");
			
			
			//DIASDUploadSupplier supplierList = new DIASDUploadSupplier(rpt_supplier);
			listSupplierList.add(rpt_supplier);
			
		}
		
		resultSet.close();
		statement.close();
		
		disconnect();
		
		return listSupplierList;
	}
	public TreeMap getDataForValidation() throws SQLException
	{
		ArrayList iboFromRptSupplier= new ArrayList();
		ArrayList supplierNumberFromrptSupplier= new ArrayList();
		ArrayList CountryFromrptSupplier= new ArrayList();
		ArrayList rptsupplier= new ArrayList();
		TreeMap<Integer,ArrayList> list = new TreeMap<Integer,ArrayList>();
		//List<DIASDUploadSupplier> supplierlst= listSupplierList();
		connect();
		
		Statement statement = jdbcConnection.createStatement();
		
		
			String sql = "select rpt_supplier, supplier_number, country, ibo from SA_ANALYTICS.spt.supplier_master ";
		
			
			//System.out.println("in validation C");
				ResultSet resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
			
			
				String sup_number= resultSet.getString("supplier_number");
				String country=resultSet.getString("country");
				String ibo= resultSet.getString("ibo");
				String rptsupp=resultSet.getString("rpt_supplier");
			
				supplierNumberFromrptSupplier.add(sup_number);
				iboFromRptSupplier.add(ibo);
				CountryFromrptSupplier.add(country);
				rptsupplier.add(rptsupp);
				}
				
		
		list.put(0, supplierNumberFromrptSupplier);
		list.put(1, iboFromRptSupplier);
		list.put(2, CountryFromrptSupplier);
		list.put(3,rptsupplier);
		
		return list;
		
	}
//	public TreeMap getsuppLink() throws SQLException
//	{
//		ArrayList<String> lst = new ArrayList<String>();
//		TreeMap<Integer,ArrayList> list = new TreeMap<Integer,ArrayList>();
//		//List<DIASDUploadSupplier> supplierlst= listSupplierList();
//		connect();
//		
//		Statement statement = jdbcConnection.createStatement();
//		
//		
//			String sql = "select rpt_supplier, supplier_number, country, ibo from SA_ANALYTICS.spt.supplier_master where  status='active' ";
//		
//			int count=0;
//			//System.out.println("in validation C");
//				ResultSet resultSet = statement.executeQuery(sql);
//				while (resultSet.next()) {
//			
//				count=count+1;
//				String sup_number= resultSet.getString("supplier_number");
//				String country=resultSet.getString("country");
//				String ibo= resultSet.getString("ibo");
//				String rptsupp=resultSet.getString("rpt_supplier");
//			
//				lst.add(sup_number);
//				lst.add(ibo);
//				lst.add(country);
//				lst.add(rptsupp);
//				
//				list.put(count, lst);
//				
//				}
//				
//		
//		
//		
//		return list;
//		
//	}
//	public TreeMap getDataForValidationForInactive() throws SQLException
//	{
//		ArrayList iboFromRptSupplierin= new ArrayList();
//		ArrayList supplierNumberFromrptSupplierin= new ArrayList();
//		ArrayList CountryFromrptSupplierin= new ArrayList();
//		ArrayList rptsupplierin= new ArrayList();
//		TreeMap<Integer,ArrayList> list = new TreeMap<Integer,ArrayList>();
//		//List<DIASDUploadSupplier> supplierlst= listSupplierList();
//		connect();
//		
//		Statement statement = jdbcConnection.createStatement();
//		
//		
//			String sql = "select rpt_supplier, supplier_number, country, ibo from SA_ANALYTICS.spt.supplier_master where  status='inactive' ";
//		
//			
//			//System.out.println("in validation C");
//				ResultSet resultSet = statement.executeQuery(sql);
//				while (resultSet.next()) {
//			
//			
//				String sup_number= resultSet.getString("supplier_number");
//				String country=resultSet.getString("country");
//				String ibo= resultSet.getString("ibo");
//				String rptsupp=resultSet.getString("rpt_supplier");
//			
//				supplierNumberFromrptSupplierin.add(sup_number);
//				iboFromRptSupplierin.add(ibo);
//				CountryFromrptSupplierin.add(country);
//				rptsupplierin.add(rptsupp);
//				}
//				
//		
//		list.put(0, supplierNumberFromrptSupplierin);
//		list.put(1, iboFromRptSupplierin);
//		list.put(2, CountryFromrptSupplierin);
//		list.put(3,rptsupplierin);
//		
//		return list;
//		
//	}
//	
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
	public  ArrayList<String> removeDuplicatesin(ArrayList list) 
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
//	public boolean isDigit(String input )
//	{
//		boolean numeric = true;		
//		try {
//            Double num = Double.parseDouble(input);
//        } catch (NumberFormatException e) {
//        	numeric = false;
//        }
//
//        if(numeric)
//            return true;
//        else
//            return false;
//    }
		
	public boolean datevalidation(String date)
	{
		boolean flag=false;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try{
            sdf.parse(date);
            flag=true;
        }
        catch(Exception e)
        {
        	//ErrorList.add("ETA Date format should be MM-DD-YYYY");
        	flag=false;
			//counter9=false;
        }
		return flag;
	}
	
	int headercount=0;
	

	public boolean ValidateExcelFiledias(String path,String ErrorFilePath)
	{
		
		try  
		{  
			TreeMap<Integer,ArrayList> MapFromValidation=new TreeMap<Integer,ArrayList>();
			
			MapFromValidation=getDataForValidation();
			ArrayList<String> countryFromValidation = new ArrayList<String>();
			ArrayList<String> iboFromValidation = new ArrayList<String>();
			ArrayList<String> supplierFromValidation = new ArrayList<String>();
			ArrayList<String> countrytotest = new ArrayList<String>();
			ArrayList<String> getibo = new ArrayList<String>();
			ArrayList<String> subdiv = new ArrayList<String>();
			ArrayList<String> reptsupp= new ArrayList<String>();
			getibo=getibo();
			subdiv=getsub();
			supplierFromValidation=MapFromValidation.get(0);
			iboFromValidation=MapFromValidation.get(1);
			countryFromValidation=MapFromValidation.get(2);
			supplierFromValidation=removeDuplicates(supplierFromValidation);
			iboFromValidation=removeDuplicates(iboFromValidation);
			countrytotest=removeDuplicates(countryFromValidation);
			
			
			
			//For inactive
//			TreeMap<Integer,ArrayList> MapFromValidationin=new TreeMap<Integer,ArrayList>();
//			
//			MapFromValidationin=getDataForValidationForInactive();
//			ArrayList<String> countryFromValidationin = new ArrayList<String>();
//			ArrayList<String> iboFromValidationin = new ArrayList<String>();
//			ArrayList<String> supplierFromValidationin = new ArrayList<String>();
//			ArrayList<String> countrytotestin = new ArrayList<String>();
//			supplierFromValidationin=MapFromValidationin.get(0);
//			iboFromValidationin=MapFromValidationin.get(1);
//			countryFromValidationin=MapFromValidationin.get(2);
//			supplierFromValidationin=removeDuplicates(supplierFromValidationin);
//			iboFromValidationin=removeDuplicates(iboFromValidationin);
//			countrytotestin=removeDuplicates(countryFromValidationin);
			
			
			
			//System.out.println(countrytotest);
			
//			ArrayList suppliernumberafterfiler= new ArrayList();
//			for(int k=0;k<supplierFromValidation.size();k++)
//			{
//				if(String.valueOf(supplierFromValidation.get(k)).equalsIgnoreCase(null)||String.valueOf(supplierFromValidation.get(k)).equalsIgnoreCase("")||String.valueOf(supplierFromValidation.get(k)).equalsIgnoreCase(" "))
//					suppliernumberafterfiler.add(" ");
//				else
//				{
//					
//					suppliernumberafterfiler.add(((supplierFromValidation.get(k)).replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", "")));
//					
//					
//				}
//				
//			}
			
			ArrayList<String> supplierNumberActive= new ArrayList<String>();
			ArrayList<String> supplierNumberActiveAfterValidation= new ArrayList<String>();
			supplierNumberActive=getsupplernumber();
			for(int k=0;k<supplierNumberActive.size();k++)
			{
				if(String.valueOf(supplierNumberActive.get(k)).equalsIgnoreCase(null)||String.valueOf(supplierNumberActive.get(k)).equalsIgnoreCase("")||String.valueOf(supplierNumberActive.get(k)).equalsIgnoreCase(" "))
					supplierNumberActiveAfterValidation.add(" ");
				else
				{
					
					supplierNumberActiveAfterValidation.add(((supplierNumberActive.get(k)).replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", "")));
					
					
				}
				
			}
			//System.out.println("list to compare "+suppliernumberafterfiler);
			
			//System.out.println("hello"+suppliernumberafterfiler);
//			for(int i=0;i<supplierFromValidation.size();i++)
//			{
//				String suppval=supplierFromValidation.get(i);
//				if((suppval.equalsIgnoreCase(null)||suppval.equalsIgnoreCase("")||suppval.equalsIgnoreCase(" "))) {
//					supplierFromValidation.add("");
//				
//				}
//				else
//					{
//						String suppval1[]=suppval.split(".");
//						System.out.println(suppval1[0]+" value "+ suppval1[1]);
//						supplierFromValidation.add(suppval1[0]);
//					}
//			}
			
			
			
			//System.out.println(supplierFromValidation.size());
			//System.out.println(supplierFromValidation);
			//PrintStream o = new PrintStream(new File("C:\\Users\\rjain6\\Desktop\\jcpenney\\logs.txt"));
			//PrintStream o = new PrintStream(new File("D:\\SPT Application Log\\DIASlogs.txt"));
	        // Store current System.out before assigning a new value 
	        //PrintStream console = System.out; 
	        TreeMap<Integer,ArrayList> ErrorMap=new TreeMap<Integer,ArrayList>();
	        //Multimap<String, String> multiMap = ArrayListMultimap.create();

	        // Assign o to output stream 
	        //System.setOut(o); 
	        
	       
			//ValidationDIAS dias= new ValidationDIAS("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
			ArrayList<String> ctry= listCountry();
			ArrayList<String> DIASFDPUploadrptBrand= listRptBrand();
			ArrayList<String> supplierlst= listSupplierList();
			
			//Inactive
			
			List<String> ctryin= listCountryin();
			List<String> DIASFDPUploadrptBrandin=listRptBrandin();
			List<String> supplierlstin= listSupplierListin();
			
			
			
			ArrayList countryList = new ArrayList();
			ArrayList<String> SupplierName= new ArrayList<String>();
			ArrayList<String> category= new ArrayList<String>();
			ArrayList<String> sorucingsub= new ArrayList<String>();
			ArrayList<String> classification= new ArrayList<String>();
			ArrayList<String> itemdesc= new ArrayList<String>();
			ArrayList<String> merchid= new ArrayList<String>();
			ArrayList rpt_brand=new ArrayList();
			ArrayList ppm = new ArrayList();
			ArrayList factoryName= new ArrayList();
			ArrayList factoryID= new ArrayList();
			ArrayList SourcingDirector = new ArrayList();
			ArrayList SupplierNumber = new ArrayList();
			ArrayList OrderNumber = new ArrayList();
			ArrayList ContractNumber = new ArrayList();
			ArrayList Channel = new ArrayList();
			ArrayList PPK = new ArrayList();
			ArrayList<String> supplier=new ArrayList<String>();
			ArrayList elc =new ArrayList();
			ArrayList dcd=new ArrayList();
			ArrayList eta =new ArrayList();
			ArrayList sub =new ArrayList();
			ArrayList unit =new ArrayList();
			ArrayList dol =new ArrayList();
			ArrayList item =new ArrayList();
			ArrayList ibo =new ArrayList();
	
			 //Workbook workbook = new XSSFWorkbook(inputStream);
			 File myFile = new File(path);
	         FileInputStream fis = new FileInputStream(myFile);

	            // Finds the workbook instance for XLSX file
	         XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
	         //CellStyle style = myWorkBook.createCellStyle();
			//XSSFWorkbook workBook = new XSSFWorkbook();
			Sheet sheet = myWorkBook.getSheetAt(0);
//			style = myWorkBook.createCellStyle();
//			style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
//		    style.setFillPattern(CellStyle.BRICKS);
			//creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			DataFormatter formatter = new DataFormatter();
			DataFormatter formatter2 = new DataFormatter();
			
			DateFormat df = new SimpleDateFormat("mm/dd/yy");
			while (itr.hasNext())                 
			{  
				Row row = itr.next();
            	  
				
				//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
				Cell ContractNumberEx=row.getCell(0);
				Cell OrderNumberEx= row.getCell(1);
				 String SupplierEx=String.valueOf(row.getCell(2)).toString();
				 String SupplierNameEx= String.valueOf(row.getCell(3)).toString();
				 Cell SupplierNumberEx= row.getCell(4);
				 
				String factoridEx= String.valueOf(row.getCell(5)).toString();
				String factoryNameEx= String.valueOf(row.getCell(6)).toString();
				 Cell subEx=row.getCell(7);
				 Cell itemEx =row.getCell(8);
				 Cell PPKEx= row.getCell(9);
				Cell itemDescEx=row.getCell(10);
				 Cell ppmEx= row.getCell(11);
				 String rpt_brandEx=String.valueOf(row.getCell(12)).toString();
				 Cell ChannelEx= row.getCell(13);
				 String c=String.valueOf(row.getCell(14)).toString();
				 Cell IboEx= row.getCell(15);
				String merchidEx= String.valueOf(row.getCell(16)).toString();
				 Cell SourcingDirectorEx= row.getCell(17);
				 String categoryEx = String.valueOf(row.getCell(18));
				 String sourcingSubEx= String.valueOf(row.getCell(19));
				 String classificationEx= String.valueOf(row.getCell(20));
				 
				 //String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
				 
				 Cell DCDEx=row.getCell(21);

				
				 Cell ETAEx=row.getCell(22);
				
				 //String outputText = outputFormat.format(date);
				 Cell unitEx= row.getCell(23);
				 Cell DolEx= row.getCell(24);
				 Cell ElcEx=row.getCell(25);
				 
				 
				dol.add(DolEx);
				countryList.add(c);
				elc.add(ElcEx);
				SupplierName.add(SupplierNameEx);
				category.add(categoryEx);
				sorucingsub.add(sourcingSubEx);
				classification.add(classificationEx);
				itemdesc.add(formatter.formatCellValue(itemDescEx));
				factoryID.add(factoridEx);
				factoryName.add(factoryNameEx);
				merchid.add(merchidEx);
				unit.add(unitEx);
				sub.add(formatter.formatCellValue(subEx));
				ppm.add(ppmEx);
				rpt_brand.add(rpt_brandEx);
				supplier.add(SupplierEx);
				SourcingDirector.add(formatter.formatCellValue(SourcingDirectorEx));
				SupplierNumber.add(formatter.formatCellValue(SupplierNumberEx));
				OrderNumber.add(formatter.formatCellValue(OrderNumberEx));
				dcd.add(formatter.formatCellValue(DCDEx));
				eta.add(formatter.formatCellValue(ETAEx));
				
				ContractNumber.add(formatter.formatCellValue(ContractNumberEx));
				item.add(formatter.formatCellValue(itemEx));
				Channel.add(formatter.formatCellValue(ChannelEx));
				PPK.add(formatter.formatCellValue(PPKEx));
				ibo.add(formatter.formatCellValue(IboEx));
			}
			
		
			//System.out.println("sublot values "+sublot);
			
			ArrayList<String> newList = removeDuplicates(countryList);
			ArrayList<String> newSupplierList=removeDuplicates(supplier);
			
			ArrayList<String> newBrandList=removeDuplicates(rpt_brand);
			
			//System.out.println(newList + "  " +newSupplierList + " " + "  "+newBrandList);
			//System.out.println(Suppliernumberval1);
        // Print the ArrayList with duplicates removed 
			
//			for (String item : countryList) {
//			    if (Collections.frequency(countryList, item) == 1) {
//			        System.out.println(item);
//			    }
//			}

			//ArrayList countrylistfinal=new ArrayList();
			//int counter=0;
			
//			for(int i=2;i<newList.size();i++){
//
//                for(int j=0;j<ctry.size();j++){
//                if(newList.contains(ctry.get(j).getCountry_name())){
//                    System.out.println("Exist : "+ctry.get(j).getCountry_name());
//                }else{
//                    System.out.println("Not Exist : "+ctry.get(j).getCountry_name());
//                }
//                break;
//            }
//            }
			
					
			//System.out.println(countrylistfinal);
			
			        //Constructing listWithoutDuplicateElements using set
			
		        //ArrayList<String> listWithoutDuplicateElements = new ArrayList<String>(set);
		        //System.out.println(listWithoutDuplicateElements);
//			HashSet<String> hSetNumbers = new HashSet(countryList);
//			 for(String strNumber : hSetNumbers)
//		            System.out.println(strNumber);
			//Cell ErrorMessage1;
			//ErrorMessage1=sheet.getRow(rowcount).createCell(0);
			
			//ErrorMessage1.setCellValue("Error Messages");
			
			
			ArrayList Headerlist= new ArrayList();
			Cell CONTRACT=sheet.getRow(0).getCell(0);
			Cell Order	=sheet.getRow(0).getCell(1);
			Cell Reporting_Supplier_Name =sheet.getRow(0).getCell(2);
			Cell Supplier_Name	=sheet.getRow(0).getCell(3);
			Cell SUPPLIER	=sheet.getRow(0).getCell(4);
			Cell Factory_ID	=sheet.getRow(0).getCell(5);
			Cell Factory_Name	=sheet.getRow(0).getCell(6);
			Cell Sub	=sheet.getRow(0).getCell(7);
			Cell Item	=sheet.getRow(0).getCell(8);
			Cell PPK1	=sheet.getRow(0).getCell(9);
			Cell ITEM_DESC	=sheet.getRow(0).getCell(10);
			Cell PPM=sheet.getRow(0).getCell(11);
			Cell Brand_Name1	=sheet.getRow(0).getCell(12);
			Cell Channel_Indicator	=sheet.getRow(0).getCell(13);
			Cell Country_of_Origin	=sheet.getRow(0).getCell(14);
			Cell Reporting_IBO	=sheet.getRow(0).getCell(15);
			Cell Merch_ID	=sheet.getRow(0).getCell(16);
			Cell Sourcing_Director	=sheet.getRow(0).getCell(17);
			Cell CATEGORY	=sheet.getRow(0).getCell(18);
			Cell Sourcing_Sub_Cat	=sheet.getRow(0).getCell(19);
			Cell Classification	=sheet.getRow(0).getCell(20);
			Cell DCD_Date	=sheet.getRow(0).getCell(21);
			Cell ETA	 =sheet.getRow(0).getCell(22);
			Cell Sum_of_Quantity 	=sheet.getRow(0).getCell(23); 
			Cell Sum_of_FOB 	 =sheet.getRow(0).getCell(24);
			Cell Sum_of_ELC_COST =sheet.getRow(0).getCell(25);
			if(((String.valueOf(CONTRACT)).equalsIgnoreCase("CONTRACT#")) && ((String.valueOf(Order)).equalsIgnoreCase("Order#")) && ((String.valueOf(Reporting_Supplier_Name)).equalsIgnoreCase("Reporting Supplier Name"))&& 
			((String.valueOf(Supplier_Name)).equalsIgnoreCase("Supplier Name"))&& ((String.valueOf(SUPPLIER)).equalsIgnoreCase("SUPPLIER#"))&& 
			((String.valueOf(Factory_ID)).equalsIgnoreCase("Factory ID"))&& ((String.valueOf(Factory_Name)).equalsIgnoreCase("Factory Name"))&& 
			((String.valueOf(Sub)).equalsIgnoreCase("Sub"))&& ((String.valueOf(Item)).equalsIgnoreCase("Item#"))&& 
			((String.valueOf(PPK1)).equalsIgnoreCase("PPK#"))&& ((String.valueOf(ITEM_DESC)).equalsIgnoreCase("ITEM DESC"))&& 
			((String.valueOf(PPM)).equalsIgnoreCase("PPM"))&& ((String.valueOf(Brand_Name1)).equalsIgnoreCase("REPORTING Brand Name"))&& 
			((String.valueOf(Channel_Indicator)).equalsIgnoreCase("Channel Indicator"))&& ((String.valueOf(Country_of_Origin)).equalsIgnoreCase("Country_of_Origin"))&& 
			((String.valueOf(Reporting_IBO)).equalsIgnoreCase("Reporting IBO"))&& ((String.valueOf(Merch_ID)).equalsIgnoreCase("Merch ID"))&& 
			((String.valueOf(Sourcing_Director)).equalsIgnoreCase("Sourcing Director"))&& ((String.valueOf(CATEGORY)).equalsIgnoreCase("CATEGORY"))&& 
			((String.valueOf(Sourcing_Sub_Cat)).equalsIgnoreCase("Sourcing Sub-Cat"))&& ((String.valueOf(Classification)).equalsIgnoreCase("Classification"))&& 
			((String.valueOf(DCD_Date)).equalsIgnoreCase("DCD Date"))&& ((String.valueOf(ETA)).equalsIgnoreCase("ETA"))&& 
			((String.valueOf(Sum_of_Quantity)).equalsIgnoreCase("Sum of Quantity"))&& ((String.valueOf(Sum_of_FOB)).equalsIgnoreCase("Sum of FOB($)"))&& 
			((String.valueOf(Sum_of_ELC_COST)).equalsIgnoreCase("Sum of ELC COST")))
			{
				flag4=true;
				//Headerlist.add("Error Description");
			}
			else
			{
				//Cell cell = null; 
				
				//cell = sheet.getRow(0).getCell(0);
				
				
				 headercount=headercount+1;
				 headervaluecount=headervaluecount+1;
				
				 flag4=false;
				
			}
			
			if(headervaluecount>0)
			{
				
				 Headerlist.add("Error Description;Column header does not match required template");
			}
			else
			{
				
				 Headerlist.add("Error Description");
			}
				
			 ArrayList countryList1=new ArrayList();
			 ArrayList brandlist1=new ArrayList();
			 ArrayList supplierlist1=new ArrayList();
			 ArrayList supplierlist2=new ArrayList();
			 int rowTotal = sheet.getLastRowNum();

			 if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
			     rowTotal++;
			 }
			 
//	            Iterator<Row> itr1 = sheet.iterator();    //iterating over excel file  
//				//int counter=0;
				for (int i=0;i<rowTotal;i++)
				{  
					
					Row row=sheet.getRow(i);
					//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
					Cell supplier1 = row.getCell(2);
					Cell brand1 = row.getCell(12);
					Cell country = row.getCell(14);
					//String supp= String.valueOf(row.getCell(3))
					
					
//					if(country.toString())
	//				{
					//counter++;
					 
						countryList1.add(formatter.formatCellValue(country));
						brandlist1.add(formatter.formatCellValue(brand1));
						supplierlist1.add(formatter.formatCellValue(supplier1));
		}
				
//					try{
//			            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//				        
//			            Connection con = DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
//			            Statement stmt= con.createStatement();
//			            String sql = "INSERT INTO SA_ANALYTICS.spt.supplier_number_temp(id,rpt_supplier,supplier_number)	VALUES(?,?,?)";
//			            	//System.out.println("SQL Statement "+sql);
//			            PreparedStatement pstm = con.prepareStatement(sql);
//			            con.setAutoCommit(false);
//			            for(int i=0;i<rowTotal;i++) {
//			            	
//			            	
//			            }
//					}
//					catch(Exception e)
//					{
//						System.out.println(e);
//					}
				
				
//				ArrayList<String> iboFromRptSupplier1= new ArrayList<String> ();
//				ArrayList<String>  supplierNumberFromrptSupplier1= new ArrayList<String> ();
//				ArrayList<String>  CountryFromrptSupplier1= new ArrayList<String> ();
//				//ArrayList rptsupplier= new ArrayList();
//				//TreeMap<Integer,ArrayList> list = new TreeMap<Integer,ArrayList>();
//				//List<DIASDUploadSupplier> supplierlst= listSupplierList();
//				connect();
//				
//				
//				
//				String sql=  "select  supplier_number, country, ibo from SA_ANALYTICS.spt.supplier_master where rpt_supplier=?";
//				PreparedStatement preparedStatement =
//				        jdbcConnection.prepareStatement(sql);
//				for(int i=0;i<rowTotal;i++)
//				{
//				
//					
//					
//					preparedStatement.setString(1,String.valueOf(supplierlst.get(i)));
//						ResultSet resultSet = preparedStatement.executeQuery();
//						while (resultSet.next()) {
//					
//					
//						String sup_number= resultSet.getString("supplier_number");
//						String country=resultSet.getString("country");
//						String ibo1= resultSet.getString("ibo");
//						//String rptsupp=resultSet.getString("rpt_supplier");
//					
//						supplierNumberFromrptSupplier1.add(sup_number);
//						iboFromRptSupplier1.add(ibo1);
//						CountryFromrptSupplier1.add(country);
//						//rptsupplier.add(rptsupp);
//						}
//				
//					
//				}
				
//				
//				ArrayList<String> suppnumerLinking=  new ArrayList<String>();
//				for(int k=0;k<supplierNumberFromrptSupplier1.size();k++)
//				{
//					if(String.valueOf(supplierNumberFromrptSupplier1.get(k)).equalsIgnoreCase(null)||String.valueOf(supplierNumberFromrptSupplier1.get(k)).equalsIgnoreCase("")||String.valueOf(supplierNumberFromrptSupplier1.get(k)).equalsIgnoreCase(" "))
//						suppnumerLinking.add("");
//					else
//					{
//						
//						suppnumerLinking.add(((supplierNumberFromrptSupplier1.get(k)).replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", "")));
//						
//						
//					}
//					
//				}
//				suppnumerLinking=removeDuplicates(suppnumerLinking);
				//iboFromRptSupplier1= removeDuplicates(iboFromRptSupplier1);
				//CountryFromrptSupplier1=removeDuplicates(CountryFromrptSupplier1);
				//System.out.println(suppnumerLinking);
				//System.out.println(iboFromRptSupplier1);
				//System.out.println(CountryFromrptSupplier1);
//			ArrayList<String> correctvalbrand= new ArrayList<String>();
//			for(int k=1;k<newBrandList.size();k++)
//			{
//				for(int s=0;s<DIASFDPUploadrptBrand.size();s++)
//				{
//					
//						if((String.valueOf(newBrandList.get(k)).toString()).equalsIgnoreCase(DIASFDPUploadrptBrand.get(s).getRpt_brand().toString()))
//						{
//							
//							correctvalbrand.add(newBrandList.get(k));
//							//System.out.println("successfully validated country column  J" +k);
//						}
//					
//				}
//				
//			}
//			newBrandList.removeAll(correctvalbrand);
//			newBrandList.subList(0, 1).clear();
			//newBrandList.subList(newBrandList.size()-1, newBrandList.size()).clear();
			
//			//boolean var =true;
			
//			for(int k=1;k<newSupplierList.size();k++)
//			{	
//				
//				for(int s=0;s<supplierlst.size();s++)
//				{
//						
//						if((String.valueOf(newSupplierList.get(k))).equalsIgnoreCase(supplierlst.get(s).getRpt_supplier()))
//						{
//							//System.out.println( newSupplierList.get(k).toString()+ " " + supplierlst.get(s).getRpt_supplier().toString());
//							correctvalsupplier.add(newSupplierList.get(k));
//							//System.out.println("successfully validated country column  J" +k);
//						}
//						
//					
//				}
//				
//			}
//				
//				//System.out.println("coorect val data "+correctvalsupplier);
//				//System.out.println("coorect val new supplier list data "+newSupplierList);
//			
//			
//			newSupplierList.removeAll(correctvalsupplier);
//			newSupplierList.subList(0, 1).clear();
			//newSupplierList.subList(newSupplierList.size()-1, newSupplierList.size()).clear();
			//System.out.print(" list of supplier "+newSupplierList);
			
//			ArrayList<String> correctvalctry= new ArrayList<String>();
//			for(int k=1;k<newList.size();k++)
//			{
//					for(int z=0;z<ctry.size();z++)
//					{
//						if((String.valueOf(newList.get(k)).equalsIgnoreCase(ctry.get(z).getCountry_name())))
//						{
//							correctvalctry.add(newList.get(k));
//							//System.out.println("successfully validated country column  J" +k);
//						}
//					}
//			}
//			
//			newList.removeAll(correctvalctry);
//			newList.subList(0, 1).clear();
			
			//newList.subList(newList.size()-1, newList.size()).clear();
			
			
			//System.out.println(" 1 "+ContractNumber);
			//FileOutputStream outputStream = new FileOutputStream(ErrorFilePath);
           // myWorkBook.write(outputStream);
			//System.out.println(supplierlist1);
//				ArrayList<String> rptSupplierCont= new ArrayList<String>();
//				ArrayList<String> countryFromRpt_supplier= new ArrayList<String>();
//				
//				ArrayList<String> rptSupplierIBO= new ArrayList<String>();
//				ArrayList<String> IBOFromRpt_supplier= new ArrayList<String>();
//				
//				ArrayList<String> rptSupplierSuppNum= new ArrayList<String>();
//				ArrayList<String> SuppNumFromRpt_supplier1= new ArrayList<String>();
				
				
				
					
					
				
			for(int k=1;k<rowTotal;k++)
			{
				int counterr=0,counterr2=0,counterr3=0;
				ArrayList<String> ErrorList = new ArrayList<String>();
				
					//System.out.println(SupplierNumber.get(k));
					if(String.valueOf(supplierlist1.get(k)).equals(null)||String.valueOf(supplierlist1.get(k)).equals("")||String.valueOf(supplierlist1.get(k)).equals(" ")||String.valueOf(supplierlist1.get(k)).isEmpty()||String.valueOf(supplierlist1.get(k)).length()==0||String.valueOf(supplierlist1.get(k)).trim().isEmpty()||supplierlist1.get(k)==null)
					{
						ErrorList.add("Rpt. Supplier required;");
						counter21=false;
					}
						
					else if((!(supplierlst.contains(supplierlist1.get(k))))||(String.valueOf(supplierlist1.get(k)).matches("[0-9]+")))
					{
							ErrorList.add("Rpt. Supplier does not exist in SPT;");
							
					}
					else if(supplierlstin.contains(String.valueOf(supplierlist1.get(k)).toUpperCase()))
					{
							ErrorList.add("Rpt. Supplier status is inactive;");
					}
					
					
					if(String.valueOf(countryList1.get(k)).equals(null)||String.valueOf(countryList1.get(k)).equals("")||String.valueOf(countryList1.get(k)).equals(" ")||String.valueOf(countryList1.get(k)).isEmpty()||String.valueOf(countryList1.get(k)).length()==0||String.valueOf(countryList1.get(k)).trim().isEmpty()||countryList1.get(k)==null)
					{
						//counter22=false;
						ErrorList.add("Country Required;");
						
					}
					else if((!(ctry.contains(String.valueOf(countryList1.get(k)).toUpperCase())))||((String.valueOf(countryList1.get(k)).matches("[0-9]+"))))
								{
									ErrorList.add("Country does not exist in SPT;");
								
									
								}
					else if(ctryin.contains(String.valueOf(countryList1.get(k)).toUpperCase()))
								{
										ErrorList.add("Country status is inactive;");
								}		
					
					else 
					{
						connect();
						
						PreparedStatement preparedStatement1 =jdbcConnection.prepareStatement("select * from SA_ANALYTICS.spt.supplier_master where country like ? and rpt_supplier in (?)");
						connect();
						preparedStatement1.setString(1,"%" + String.valueOf(countryList1.get(k)) + "%");
						preparedStatement1.setString(2,String.valueOf(supplierlist1.get(k)));
						ResultSet resultSet1 = preparedStatement1.executeQuery();
						while (resultSet1.next()) {
							if(resultSet1==null)
							ErrorList.add("Country is not linked with Rpt. Supplier;");
						}
						
					}
								
					
					
	
						
						
					
				
				
					
					if(String.valueOf(brandlist1.get(k)).equals(null)||String.valueOf(brandlist1.get(k)).equals("")||String.valueOf(brandlist1.get(k)).equals(" ")||String.valueOf(brandlist1.get(k)).isEmpty()||String.valueOf(brandlist1.get(k)).length()==0||String.valueOf(brandlist1.get(k)).trim().isEmpty()||brandlist1.get(k)==null)
					{
						counter23=false;
						ErrorList.add("Reporting Brand Required;");
					}
					
					
					else if((!(DIASFDPUploadrptBrand.contains(brandlist1.get(k))))||((String.valueOf(brandlist1.get(k)).matches("[0-9]+"))))
							{
								ErrorList.add("Rpt. Brand does not exist in SPT;");
								
								flag1=false;
								counter23=false;
							}
							
							else if(DIASFDPUploadrptBrandin.contains(String.valueOf(brandlist1.get(k)).toUpperCase()))
							{
									 ErrorList.add("Rpt. Brand status is inactive;");
							}
								 	
							
							else
							{
								flag1=true;
								counter23=true;
							}
							
							
							
						
					
				
				if(String.valueOf(ibo.get(k)).equals(null)||String.valueOf(ibo.get(k)).equals("")||String.valueOf(ibo.get(k)).equals(" ")||String.valueOf(ibo.get(k)).isEmpty()||String.valueOf(ibo.get(k)).length()==0||String.valueOf(ibo.get(k)).trim().isEmpty()||ibo.get(k)==null)
				{
					ErrorList.add("IBO required;");
					counter24=false;
					
				}
				
				else if((!(iboFromValidation.contains(String.valueOf(ibo.get(k)).toUpperCase())))||((String.valueOf(ibo.get(k)).matches("[0-9]+"))))
				{
						ErrorList.add("IBO does not exist in SPT;");
				}
				
				else 
				{
					connect();
					PreparedStatement preparedStatement2 =jdbcConnection.prepareStatement("select *  from SA_ANALYTICS.spt.supplier_master where ibo like ? and rpt_supplier in (?)");
					connect();
					preparedStatement2.setString(1,"%" + String.valueOf(ibo.get(k)) + "%");
					preparedStatement2.setString(2,String.valueOf(supplierlist1.get(k)));
					ResultSet resultSet2 = preparedStatement2.executeQuery();
					while (resultSet2.next()) {
						if(resultSet2==null)
						{
							ErrorList.add("IBO is not linked with Rpt. Supplier;");
						}
						
							
					}
					
				}
				
				
				if(String.valueOf(SourcingDirector.get(k)).equals(null)||String.valueOf(SourcingDirector.get(k)).equals("")||String.valueOf(SourcingDirector.get(k)).equals(" ")||String.valueOf(SourcingDirector.get(k)).isEmpty()||String.valueOf(SourcingDirector.get(k)).length()==0||String.valueOf(SourcingDirector.get(k)).trim().isEmpty()||SourcingDirector.get(k)==null)
				{
					ErrorList.add("Sourcing Director required;");
					counter2=false;
				}
				else if(!(String.valueOf(SourcingDirector.get(k)).matches("^[a-zA-Z\\s]*$")))
				{
					ErrorList.add("Sourcing Director is in invalid format;");
				}
				else
				{
					counter2=true;
				}
				if(String.valueOf(itemdesc.get(k)).equals(null)||String.valueOf(itemdesc.get(k)).equals("")||String.valueOf(itemdesc.get(k)).equals(" ")||String.valueOf(itemdesc.get(k)).isEmpty()||String.valueOf(itemdesc.get(k)).length()==0||String.valueOf(itemdesc.get(k)).trim().isEmpty()||itemdesc.get(k)==null)
				{
					ErrorList.add("Item Description required;");
					flagitemdesc=false;
				}
				else
				{
					flagitemdesc=true;
				}
				
				
				if(String.valueOf(SupplierNumber.get(k)).equalsIgnoreCase(null)||String.valueOf(SupplierNumber.get(k)).equalsIgnoreCase(" ")||String.valueOf(SupplierNumber.get(k)).equalsIgnoreCase(""))
				{
					
					  ErrorList.add("Supplier # required;");
					 
				}
				else if(!(String.valueOf(SupplierNumber.get(k)).matches("[0-9]+")))
				{
					ErrorList.add("Supplier # is in invalid format;");
				}
				else if(!(supplierNumberActiveAfterValidation.contains(SupplierNumber.get(k))))
				{
					ErrorList.add("Supplier # does not exist in SPT;");
				}
				
				
				else 
				{
					connect();
					PreparedStatement preparedStatement3 =jdbcConnection.prepareStatement("select *  from SA_ANALYTICS.spt.supplier_master where supplier_number in (?)  and rpt_supplier in (?)");
					connect();
					preparedStatement3.setString(1,((String.valueOf(SupplierNumber.get(k))).concat(".0")));
					preparedStatement3.setString(2,String.valueOf(supplierlist1.get(k)));
					ResultSet resultSet3 = preparedStatement3.executeQuery();
					while (resultSet3.next()) {
						if(resultSet3==null)
						ErrorList.add("Supplier # is not linked with Rpt. Supplier in SPT;");
					}
					
				}
					
					
				
//				if(String.valueOf(OrderNumber.get(k)).contentEquals(null)||String.valueOf(OrderNumber.get(k)).contentEquals("")||String.valueOf(OrderNumber.get(k)).contentEquals(" "))
//				{
//					 ErrorList.add("Order # required;");
//					 
//					
//					counter4=false;
//				}
//				else
//				{
//					counter4=true;
//				}
//				if(String.valueOf(ContractNumber.get(k)).contentEquals(null)||String.valueOf(ContractNumber.get(k)).contentEquals("")||String.valueOf(ContractNumber.get(k)).contentEquals(" "))
//				{
//					
//					ErrorList.add("Contract # required;");
//					counter5=false;
//					
//				}
//				else
//				{
//					counter5=true;
//				}
				
				if(String.valueOf(Channel.get(k)).equals(null)||String.valueOf(Channel.get(k)).equals("")||String.valueOf(Channel.get(k)).equals(" ")||String.valueOf(Channel.get(k)).isEmpty()||String.valueOf(Channel.get(k)).length()==0||String.valueOf(Channel.get(k)).trim().isEmpty()||Channel.get(k)==null)
				{
					ErrorList.add("Channel required;");
					 
					
					counter6=false;
				}
				else
				{
					if(!((String.valueOf(Channel.get(k)).equalsIgnoreCase("RT")||String.valueOf(Channel.get(k)).equalsIgnoreCase("C"))))
					{
						ErrorList.add("Accepted values for Channel are RT or C;");
						counter6=false;
					}
					else
					{
						counter6=true;
					}
					
				}
				
				if(String.valueOf(dcd.get(k).toString()).equalsIgnoreCase(null)||String.valueOf(dcd.get(k).toString()).equalsIgnoreCase("")||String.valueOf(dcd.get(k).toString()).equalsIgnoreCase(" "))
				{
					
					 ErrorList.add("DCD Date required;");
					 counter8=false;
				}
				else
				{
					if(datevalidation(dcd.get(k).toString())){
			            //sdf.parse(dcd.get(k).toString());
			            counter8=true;
			        }
					else
			        {
			        	ErrorList.add("DCD Date format should be MM-DD-YY;");
						counter8=false;
			        }
					
					
				}
				if(String.valueOf(eta.get(k).toString()).equalsIgnoreCase(null)||String.valueOf(eta.get(k).toString()).equalsIgnoreCase("")||String.valueOf(eta.get(k).toString()).equalsIgnoreCase(" "))
				{
					ErrorList.add("ETA date required;");
					counter9=false;
					
				}
				else
				{
					if(datevalidation(eta.get(k).toString())){
			            counter9=true;
			        }
					else
			        {
			        	ErrorList.add("ETA Date format should be MM-DD-YY;");
						counter9=false;
			        }
					
				}
				
				if(String.valueOf(elc.get(k)).equals(null)||String.valueOf(elc.get(k)).equals("")||String.valueOf(elc.get(k)).equals(" ")||String.valueOf(elc.get(k)).isEmpty()||String.valueOf(elc.get(k)).length()==0||String.valueOf(elc.get(k)).trim().isEmpty()||elc.get(k)==null||String.valueOf(elc.get(k)).isEmpty())
				{
					ErrorList.add("ELC required;");
					
				}
				
				else if(!(String.valueOf(elc.get(k)).trim().matches(REGEX)))
				{
					ErrorList.add("ELC must be positive integer");
					
				}
				else
				{
					counter10=true;
				}
				if(String.valueOf(dol.get(k)).equals(null)||String.valueOf(dol.get(k)).equals("")||String.valueOf(dol.get(k)).equals(" ")||String.valueOf(dol.get(k)).isEmpty()||String.valueOf(dol.get(k)).length()==0||String.valueOf(dol.get(k)).trim().isEmpty()||dol.get(k)==null||String.valueOf(dol.get(k)).isEmpty())
				{
					
					ErrorList.add("Dollar required;");
					counter13=false;
				}
				
				else if(!(String.valueOf(dol.get(k)).trim().matches(REGEX)))
					{
						
						ErrorList.add("Dollars should be a positive integer;");
						counter13=false;
					}
					else
					{
						
						counter13=true;
						
					}
					
				
				
				
				if(((item.get(k).toString().length()==0)||((sub.get(k).toString().length()==0))))
				{
					ErrorList.add("Sub-Lot required;");
					
				}
				else if(!((sub.get(k).toString()).matches("[0-9]+") && (item.get(k).toString()).matches("[0-9]+")))
				{
					ErrorList.add("Sub-Lot should be numeric;");
					
					
				}
				else if(sub.get(k).toString().length()>3 || item.get(k).toString().length()>4)
				{
					ErrorList.add("Length of sub-lot field must be equal to 7-digits;");
				}
				else if(sub.get(k).toString().concat(item.get(k).toString()).length()>7)
				{
					ErrorList.add("Length of sub-lot field must be equal to 7-digits;");
				}
				else if((sub.get(k).toString().length()!=0) && (sub.get(k).toString()).matches("[0-9]+"))
				{
					if((!(subdiv.contains(sub.get(k)))))
					{
						ErrorList.add("Sub does not exist in SPT;");
					}
					
				} 
				else if(sub.get(k).toString().length()<=3 || item.get(k).toString().length()<=4)
				{
					//System.out.println("in here");
					String prependZero = null;
					String prependZero1 = null;
					String subltitem;
					String subltSub;
					int count = item.get(k).toString().length();
					
					if(count==3)
						prependZero="0";
					else if(count==2)
						prependZero="00";
					else if(count==1)
						prependZero="000";
					else if(count>=4)
						prependZero="";
					
					int count1 = sub.get(k).toString().length();
					
					if(count1>=3)
						prependZero1="";
					else if(count1==2)
						prependZero1="0";
					else if(count1==1)
						prependZero1="00";
					
					//System.out.println(count+ "hhelo" +count1);
					
					
					subltitem=prependZero+item.get(k).toString();
					subltSub=prependZero1+sub.get(k).toString();
					
					
					//ErrorList.add("Sub Lot must be equal to 7 digit;");
				}
				
				if(String.valueOf(unit.get(k)).equals(null)||String.valueOf(unit.get(k)).equals("")||String.valueOf(unit.get(k)).equals(" ")||String.valueOf(unit.get(k)).isEmpty()||String.valueOf(unit.get(k)).length()==0||String.valueOf(unit.get(k)).trim().isEmpty()||unit.get(k)==null||String.valueOf(unit.get(k)).isEmpty())
				{
					ErrorList.add("Unit required;");
					counter14=false;
				}
				
				else if((!(unit.get(k).toString().replaceAll(" ","").replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", "").matches(REGEXForUnit)))||(unit.get(k).toString().replaceAll(" ","").replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", "").length()>8)||(unit.get(k).toString().replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", "").replaceAll(" ","").startsWith("0")))
					{
						//System.out.println(unit.get(k).toString().replaceAll(" ","").replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", ""));
						ErrorList.add("Units should be 1-8 digits and positive integer value;");
						counter14=false;
					}
					
//					if((!(String.valueOf(unit.get(k)).contains(","))))
//					{
//						counter14=true;
//					}
//					else
//					{
//						//ErrorList.add("Units should have no comma in value;");
//						  counter14=false;
//					}
					
				
				
//				if(((String.valueOf(unit.get(k)).contains(","))))
//				{
//					//Cell cell = null; 
//					
//					 
//					 
//					
//					 ErrorList.add("Units should have no comma in value");
//					counter15=false;
//				}
//				else
//				{
//					
//					counter15=true;
//			
//				}

				
//				if((String.valueOf(unit.get(k)).length()<9) && (!(String.valueOf(unit.get(k)).startsWith("0"))))
//				{
//					
//					counter26=true;
//				}
//					
//				else
//				{
//					 
//					
//					 
//					 
//					 ErrorList.add("Units should be 1-8 digits");
//					counter26=false;
//					
//				}
//				if(String.valueOf(unit.get(k)).contains("-"))
//				{
//					Cell cell = null; 
//					
//					cell =sheet.getRow(rowcount).getCell(23);   
//					 
//					 ErrorList.add("Units positive integer value");
//					counter17=false;
//					
//				}
//					
//				else
//				{
//					
//					counter17=true;
//				}
//				if(String.valueOf(dol.get(k)).contains("-"))
//				{
//					//Cell cell = null; 
//					
//					 
//					 
//					 ErrorList.add("Dollars should be a positive integer");
//					counter18=false;
//					
//					
//				}
//					
//				else
//				{
//					
//					counter18=true;
//				}
				
				
				
				
			ErrorMap.put(k, ErrorList);
				
			}
			ErrorMap.put(0, Headerlist);
		int errorCounterinList=0;
           for(int s=0;s<rowTotal;s++)
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
        	   CreateErrorFile cf= new CreateErrorFile();
        	   cf.createErrorFile(path,ErrorFilePath, rowTotal, ErrorMap);
        	   
           }
           else
           {
        	   //System.out.println("i am here in else");
        	   flagFinal=true;
        	   FileOutputStream outputStream = new FileOutputStream(path);
   	       		myWorkBook.write(outputStream);
            	outputStream.close();
           }
           
//           XSSFWorkbook workbook1 = new XSSFWorkbook();
//         	
//	         
//            XSSFSheet sheet1 = workbook1.createSheet("FileWithError");
            //CellStyle cs = workbook1.createCellStyle();
            //cs.setWrapText(true);
           
			// Write the output to a file
//		    FileOutputStream fileOut = new FileOutputStream(ErrorFilePath);
//		    myWorkBook.write(fileOut);
		    //fis.close();
			
			
	       
			//Row row1;
//		    Cell cell1=null;
//		    Row row3 = null;
//		    Row row;
//		    //DecimalFormat format = new DecimalFormat("#.0");
//		    //Cell cell2,cell3,cell4,cell5,cell6,cell7,cell8,cell9,cell10,cell11,cell12,cell13,cell14,cell15,cell16,cell17,cell18,cell19,cell20,cell21,cell22,cell23,cell24,cell25,cell26,cell27;
//			//System.out.println(" 2 "+ContractNumber);
////		    int looptotal;
////		    if(ErrorList.size()>rowTotal)
////		    	looptotal=ErrorList.size();
////		    else
////		    	looptotal=rowTotal;
//		    
////			for(int i=0;i<ErrorList.size();i++)
////	       	{
////				
////				//System.out.println("1-" + ErrorList.size() + "value of  " +i);
////	       		
////				row= sheet1.createRow(i);
////	       		//System.out.println("row "+row.getRowNum());
////	       		 //row = sheet1.createRow(i);
////	       		cell1=row.createCell(0);
////	       		
////	       		cell1.setCellValue(ErrorList.get(i));
////	       		//System.out.println("Cell Coulmn Index "+cell1.getColumnIndex() +" Row Index"+cell1.getRowIndex());
////	       	}
//		    
//		    for(int i=0;i<rowTotal;i++)
//	       	{
//		    	//System.out.println("1-" + rowTotal + "value of  " +i);
//		    	
//	       			//row = sheet1.createRow(i);
//	       			//System.out.println("Inside Data loop row num "+row.getRowNum());
//		    	//Row row1=sheet.createRow(0);
//		    	row= sheet1.createRow(i);
//			    ArrayList<String> listoferror= new ArrayList<String>();
//			    
//			    listoferror=ErrorMap.get(i);
//			    Cell cell91=row.createCell(0);
//			    if(listoferror.isEmpty())
//			    {
//			    	cell91.setCellValue(" ");
//			    }
//			    else
//			    	cell91.setCellValue(String.valueOf(listoferror));
//		    	
//	       		
//	       		//cell91.setCellStyle(cs);
//		    		
//		       		Cell cell2=row.createCell(1);
//		       		String contractnumber1=String.valueOf(ContractNumber.get(i));
//		       		//contractnumber1=new BigDecimal(contractnumber1).stripTrailingZeros().toPlainString();
//		       		//contractnumber1.replaceAll("()\\.0+$|(\\..+?)0+$", "$2");
//		       		cell2.setCellValue(contractnumber1);
//		       		
//		       		Cell cell3=row.createCell(2);
//		       		String order= String.valueOf(OrderNumber.get(i));
//		       		cell3.setCellValue(order);
//		       		
//		       		Cell cell4=row.createCell(3);
//		       		String supplier1= String.valueOf(supplierlist1.get(i)).toString();
//		       		cell4.setCellValue(supplier1);
//		       		
//		       		Cell cell5=row.createCell(4);
//		       		String suppliername= String.valueOf(SupplierName.get(i)).toString();
//		       		cell5.setCellValue(suppliername);
//		       		
//		       		Cell cell6=row.createCell(5);
//		       		String suppliernumber= String.valueOf(SupplierNumber.get(i)).toString();
//		       		cell6.setCellValue(suppliernumber);
//		       		
//		       		Cell cell7=row.createCell(6);
//		       		String factoryid= String.valueOf(factoryID.get(i)).toString();
//		       		cell7.setCellValue(factoryid);
//		       		
//		       		Cell cell8=row.createCell(7);
//		       		String factoryname= String.valueOf(factoryName.get(i)).toString();
//		       		cell8.setCellValue(factoryname);
//		       		
//		       		Cell cell9=row.createCell(8);
//		       		String sub1= String.valueOf(sub.get(i)).toString();
//		       		cell9.setCellValue(sub1);
//		       		
//		       		Cell cell10=row.createCell(9);
//		       		String item1= String.valueOf(item.get(i)).toString();
//		       		cell10.setCellValue(item1);
//		       		
//		       		Cell cell11=row.createCell(10);
//		       		String ppk1= String.valueOf(PPK.get(i)).toString();
//		       		cell11.setCellValue(ppk1);
//		       		
//		       		Cell cell12=row.createCell(11);
//		       		String itemd= String.valueOf(itemdesc.get(i)).toString();
//		       		cell12.setCellValue(itemd);
//		       		
//		       		Cell cell13=row.createCell(12);
//		       		String ppm1= String.valueOf(ppm.get(i)).toString();
//		       		cell13.setCellValue(ppm1);
//		       		
//		       		Cell cell14=row.createCell(13);
//		       		String rptbrnd= String.valueOf(brandlist1.get(i)).toString();
//		       		cell14.setCellValue(rptbrnd);
//		       		
//		       		Cell cell15=row.createCell(14);
//		       		String chhnl= String.valueOf(Channel.get(i)).toString();
//		       		cell15.setCellValue(chhnl);
//		       		
//		       		Cell cell16=row.createCell(15);
//		       		String c= String.valueOf(countryList1.get(i)).toString();
//		       		cell16.setCellValue(c);
//		       		
//		       		Cell cell17=row.createCell(16);
//		       		String ibo1= String.valueOf(ibo.get(i)).toString();
//		       		cell17.setCellValue(ibo1);
//		       		
//		       		Cell cell18=row.createCell(17);
//		       		String merchid1= String.valueOf(merchid.get(i)).toString();
//		       		cell18.setCellValue(merchid1);
//		       		
//		       		Cell cell19=row.createCell(18);
//		       		String sd= String.valueOf(SourcingDirector.get(i)).toString();
//		       		cell19.setCellValue(sd);
//		       		
//		       		Cell cell20=row.createCell(19);
//		       		String cat= String.valueOf(category.get(i)).toString();
//		       		cell20.setCellValue(cat);
//		       		
//		       		Cell cell21=row.createCell(20);
//		       		String sourcingsub= String.valueOf(sorucingsub.get(i)).toString();
//		       		cell21.setCellValue(sourcingsub);
//		       		
//		       		Cell cell22=row.createCell(21);
//		       		String class1= String.valueOf(classification.get(i)).toString();
//		       		if(class1==null)
//		       			class1="";
//		       		cell22.setCellValue(class1);
//		       		
//		       		Cell cell23=row.createCell(22);
//		       		String dcd1= String.valueOf(dcd.get(i));
//		       		cell23.setCellValue(dcd1);
//		       		
//		       		Cell cell24=row.createCell(23);
//		       		String eta1= String.valueOf(eta.get(i));
//		       		cell24.setCellValue(eta1);
//		       		
//		       		Cell cell25=row.createCell(24);
//		       		if(i>0)
//		       		{
//		       		String quant= String.valueOf(unit.get(i)).toString();
//		       		cell25.setCellValue(quant.substring(1));
//		       		}
//		       		else
//		       		{
//		       			String quant= String.valueOf(unit.get(i)).toString();
//			       		cell25.setCellValue(quant);
//		       		}
//		       		
//		       		
//		       		Cell cell26=row.createCell(25);
//		       		if(i>0)
//		       		{
//		       		String fob1= (String.valueOf(dol.get(i)).toString());
//		       		cell26.setCellValue(fob1.substring(1));
//		       		}
//		       		else
//		       		{
//		       			String fob1= (String.valueOf(dol.get(i)).toString());
//			       		cell26.setCellValue(fob1);
//		       		}
//		       		
//		       		
//		       		Cell cell27=row.createCell(26);
//		       		if(i>0)
//		       		{
//		       		String elc1= String.valueOf(elc.get(i)).toString();
//		       		cell27.setCellValue(elc1.substring(1));
//		       		}
//		       		else
//		       		{
//		       			String elc1= String.valueOf(elc.get(i)).toString();
//			       		cell27.setCellValue(elc1);
//		       		}
//		       		
//		    		
//	       	}
//		    
//	       	
//	    	
	       	
	       	
	        //myWorkBook = new XSSFWorkbook(new FileInputStream(ErrorFilePath));
           ///outputStream1.close();
      
	      
		} 
		  
		
		catch(Exception e)  
		{  
			e.printStackTrace();
			System.out.println("Unknown error occurred during import.");
			
		}
		
		
		if(flagFinal)
			return true;
		else
			 return false;
	}
	
	
	
}