package net.codejava.javaee.brand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestNormalFunctionFDP {

	public void testfunct()
	{
		try {
			File myFile = new File("C:\\Users\\rjain6\\Downloads\\2016_Jan_Dixon_Lisa Miller_Womens Woven Tops-Related Separates.xlsx");
	        FileInputStream fis = new FileInputStream(myFile);

	        // Finds the workbook instance for XLSX file
	        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
			
			//XSSFWorkbook workBook = new XSSFWorkbook();
			Sheet sheet = myWorkBook.getSheetAt(0);
			ArrayList dol = new ArrayList();
			//creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			Row row = sheet.getRow(1);
			while (itr.hasNext())                 
			{  
				
				//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
				
				Cell Dollar= row.getCell(42);
				dol.add(Dollar);
			}
			
			System.out.println("hello"+ dol);
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public static void main(String args[]) throws Throwable
	{
			TestNormalFunctionFDP fdp= new TestNormalFunctionFDP();
			fdp.testfunct();
			//fdp.finalize();
	
	}
}
