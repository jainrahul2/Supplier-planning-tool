package net.codejava.javaee.brand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import antlr.collections.List;

public class testNormalFunction {
	
	public static boolean isValidDate(String d) 
    { 
		boolean flag=false;
		//String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		//String regex1 = "^(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
		//String regex3="^(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)-(3[01]|[12][0-9]|0[1-9])-[0-9]{4}$";
		//String regex4="^(Jan(uary)?|Feb(ruary)?|Mar(ch)?|Apr(il)?|May|Jun(e)?|Jul(y)?|Aug(ust)?|Sep(tember)?|Oct(ober)?|Nov(ember)?|Dec(ember)?)/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
		String regex = "^(0[1-9]|1[0-2])/(0[1-9]|1|d|2|d|3[01])/(19|20)|d{2}$" ;
		Pattern pattern = Pattern.compile(regex);
	    //Pattern pattern1 = Pattern.compile(regex1);
	    //Pattern pattern3 = Pattern.compile(regex3);
	    //Pattern pattern4 = Pattern.compile(regex4);
	    Matcher matcher = pattern.matcher((CharSequence) d);
	    //Matcher matcher1 = pattern1.matcher((CharSequence) d);
	    //Matcher matcher3 = pattern3.matcher((CharSequence) d);
	    //Matcher matcher4 = pattern4.matcher((CharSequence) d);
	   if(matcher.matches())
	   {
		   flag=true;
		
	   }
	   else
	   {
		   flag=false;
		   
	   }
	   return flag;
    }
	public static boolean getdigitCheck(String str)
	{
		boolean flag=true;
		 if(str.matches("[1-8]+")) {
	        flag=true;
	      }
		 else
			 flag=false;
		 return flag;
	}
//	public static boolean validateJavaDate(String strDate)
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
	public static  void main(String args[]) throws IOException
	{
//		Pattern p = Pattern.compile("([1-8])");
//		Matcher m = p.matcher("198794993");
//
//		if(m.find()){
//		    System.out.println("Hello "+m.find());
	
//		}
//		String str = "44349";
//	      if(str.matches("[1-8]+")) {
//	         System.out.println("String contains only digits!");
//	      }
//	      else
//	    	  System.out.println("wrong");
		//validateJavaDate("29/03/2016");
		//File myFile = new File(path);
//        FileInputStream fis = new FileInputStream("C:\\Users\\rjain6\\Downloads\\CLEANSE DIAS SPT DATA - APRIL .xlsx");
//
//           // Finds the workbook instance for XLSX file
//        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
//		
//		//XSSFWorkbook workBook = new XSSFWorkbook();
//		Sheet sheet = myWorkBook.getSheetAt(0);
//		//FileInputStream fis = new FileInputStream();
//	       //XSSFWorkbook workbook = new XSSFWorkbook(fis);
//	      // XSSFSheet sheet = myWorkBook.getSheet("Sheet");
//	       Row row = sheet.getRow(0);
//	       int colNum = row.getLastCellNum();
//	       System.out.println("Total Number of Columns in the excel is : "+colNum);
//	       int rowNum = sheet.getLastRowNum()+1;
//	       System.out.println("Total Number of Rows in the excel is : "+rowNum);
//	       System.out.println(row.getPhysicalNumberOfCells());
//	       System.out.println(sheet.getPhysicalNumberOfRows());
		//System.out.println(isValidDate("1/29/2016")); 
        //System.out.println(isValidDate("12/12/2020"));
        //System.out.println(isValidDate("12-12-2020"));
//        System.out.println(isValidDate("21/3/20"));
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//        sdf.setLenient(false);
//        //System.out.println("Please enter a date (mm/dd/yyyy)");
//        String uDate ="31/03/2020";
//        try{
//            sdf.parse(uDate);
//            System.out.println(uDate+" is a valid Date");
//        }
//        catch(Exception e)
//        {
//            System.out.println(uDate+" is not a valid Date");
//        }
//		String s="756007.0";
//		
//		System.out.println("hello"+s.replaceAll("[0]+$", "").replaceAll("(\\.)(?!.*?[1-9]+)", ""));
//		if(s.contains("."))
//		{
//		String[] m=s.split(".");
//		System.out.println(m[0]+" "+m[1]);
//		String z=m[0].concat(m[1]);
//		System.out.println(z);
//		}
//		else
//		{
//			Double k=Double.parseDouble(s);
//			System.out.println(k.toString());
//		}
        //System.out.println(isValidDate("January/31/2020"));
//	       System.out.println(getdigitCheck("816"));
//	       System.out.println(getdigitCheck("9324"));
//	       System.out.println(getdigitCheck("24924"));
		 // Create the list with null values 
//      ArrayList list= new ArrayList();
//      list.add(null);
//      list.add("hello");
//      list.add(null);
//      list.add("hello1");
//      System.out.println(list);
//      list.removeAll(Collections.singleton(null));
//      System.out.println(list);
//		HashMap<Integer, String> s = new HashMap<Integer, String>();
//		s.put(null, "s");
//		s.put(1, null);
//		s.put(2, "b");
//		s.put(2, "c");
//		s.put(2, "d");
//		s.put(3, "e");
//		System.out.println(s.get(null));
//		for(int i=1;i<s.size();i++)
//		{
//			System.out.println(s);
//		}

//		String input = " Destination à gauche";
//		String output = input.replaceAll("\\s+","");
//		System.out.println("output is \""+output+"\"");
		String s="$268,569  ";
				
		System.out.println(s.trim().replaceAll(",", "").replace("$", ""));
		
		//String regex="replaceAll(\"[.0]+$\", \"\");";
		//System.out.println(s.replaceAll("[.0]+$", ""));
		
	}
}
