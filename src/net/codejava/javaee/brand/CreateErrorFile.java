package net.codejava.javaee.brand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateErrorFile {
	
	@SuppressWarnings("unchecked")
	public void createErrorFile(String filename,String Errorfilename,int rowcount,TreeMap<Integer, ArrayList> errormap) throws IOException
	{
		//ValidationDIAS dias= new ValidationDIAS("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");

		
		ArrayList countryList = new ArrayList();
		ArrayList<String> SupplierName= new ArrayList<String>();
		ArrayList category= new ArrayList();
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
		ArrayList supplier=new ArrayList();
		ArrayList elc =new ArrayList();
		ArrayList dcd=new ArrayList();
		ArrayList eta =new ArrayList();
		ArrayList sub =new ArrayList();
		ArrayList unit =new ArrayList();
		ArrayList dol =new ArrayList();
		ArrayList item =new ArrayList();
		ArrayList ibo =new ArrayList();

		 //Workbook workbook = new XSSFWorkbook(inputStream);
		 File myFile = new File(filename);
         FileInputStream fis = new FileInputStream(myFile);

            // Finds the workbook instance for XLSX file
         XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
         //CellStyle style = myWorkBook.createCellStyle();
		//XSSFWorkbook workBook = new XSSFWorkbook();
		Sheet sheet = myWorkBook.getSheetAt(0);
//		style = myWorkBook.createCellStyle();
//		style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
//	    style.setFillPattern(CellStyle.BRICKS);
		//creating a Sheet object to retrieve object  
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		DataFormatter formatter = new DataFormatter();
		DataFormatter formatter2 = new DataFormatter();
		
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		while (itr.hasNext())                 
		{  
			Row row = itr.next();
        	  
			
			//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
			Cell ContractNumberEx=row.getCell(0);
			Cell OrderNumberEx= row.getCell(1);
			 Cell SupplierEx=row.getCell(2);
			 Cell SupplierNameEx= row.getCell(3);
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
			 Cell categoryEx = row.getCell(18);
			 String sourcingSubEx= String.valueOf(row.getCell(19));
			 Cell classificationEx= row.getCell(20);
			 
			 //String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
			 
			 Cell DCDEx=row.getCell(21);

			
			 Cell ETAEx=row.getCell(22);
			
			 //String outputText = outputFormat.format(date);
			Cell unitEx= row.getCell(23);
			 Cell DolEx= row.getCell(24);
			 Cell ElcEx=row.getCell(25);
			 
			 
			dol.add(formatter.formatCellValue(DolEx));
			countryList.add(c);
			elc.add(formatter.formatCellValue(ElcEx));
			SupplierName.add(formatter.formatCellValue(SupplierNameEx));
			category.add(formatter.formatCellValue(categoryEx));
			sorucingsub.add(sourcingSubEx);
			classification.add(formatter.formatCellValue(classificationEx));
			itemdesc.add(formatter.formatCellValue(itemDescEx));
			factoryID.add(factoridEx);
			factoryName.add(factoryNameEx);
			merchid.add(merchidEx);
			unit.add(formatter.formatCellValue(unitEx));
			sub.add(formatter.formatCellValue(subEx));
			ppm.add(formatter.formatCellValue(ppmEx));
			rpt_brand.add(rpt_brandEx);
			supplier.add(formatter.formatCellValue(SupplierEx));
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
		ArrayList countryList1=new ArrayList();
		 ArrayList brandlist1=new ArrayList();
		 ArrayList supplierlist1=new ArrayList();
		 for (int i=0;i<rowcount;i++)
			{  
				
				Row row=sheet.getRow(i);
				//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
				Cell country = row.getCell(14);
				Cell brand1= row.getCell(12);
				Cell supplier1=row.getCell(2);
				
//				if(country.toString())
//				{
				//counter++;
				 
					countryList1.add(formatter.formatCellValue(country));
					brandlist1.add(formatter.formatCellValue(brand1));
					supplierlist1.add(formatter.formatCellValue(supplier1));
	}
		XSSFWorkbook workbook1 = new XSSFWorkbook(); 
        XSSFSheet sheet1 = workbook1.createSheet("FileWithError");
	    Cell cell1=null;
	    Row row3 = null;
	    Row row;

	    int countRowNumber=0;
	    //DataFormatter formatter = new DataFormatter();
	    for(int i=0;i<rowcount;i++)
       	{
	    	
	    	row= sheet1.createRow(i);
		    ArrayList<String> listoferror= new ArrayList<String>();
		    listoferror=errormap.get(i);
		    Cell cell91=row.createCell(0);
		    
		    if(listoferror.size()==0)
		    {
		    	cell91.setCellValue(" ");
		    }
		    else
		    {
		    	cell91.setCellValue(String.valueOf(listoferror));
		    	countRowNumber=countRowNumber+1;
		    	//System.out.println(countRowNumber);
		    	UploadServletDIAS ds= new UploadServletDIAS();
		    	ds.getcounterForRowStatus(countRowNumber);
		    }
	    		
	       		Cell cell2=row.createCell(1);
	       		String contractnumber1=String.valueOf(ContractNumber.get(i));
	       		cell2.setCellValue(contractnumber1.replaceFirst("\\.0+$", ""));
	       		
	       		Cell cell3=row.createCell(2);
	       		String order= String.valueOf(OrderNumber.get(i));
	       		cell3.setCellValue(order);
	       		
	       		Cell cell4=row.createCell(3);
	       		String supplier1= String.valueOf(supplierlist1.get(i)).toString();
	       		cell4.setCellValue(supplier1.trim());
	       		
	       		Cell cell5=row.createCell(4);
	       		String suppliername= String.valueOf(SupplierName.get(i)).toString();
	       		cell5.setCellValue(suppliername.trim());
	       		
	       		Cell cell6=row.createCell(5);
	       		String suppliernumber= String.valueOf(SupplierNumber.get(i)).toString();
	       		cell6.setCellValue(suppliernumber.replaceFirst("\\.0+$", ""));
	       		
	       		Cell cell7=row.createCell(6);
	       		String factoryid= String.valueOf(factoryID.get(i)).toString();
	       		cell7.setCellValue(factoryid);
	       		
	       		Cell cell8=row.createCell(7);
	       		String factoryname= String.valueOf(factoryName.get(i)).toString();
	       		cell8.setCellValue(factoryname);
	       		
	       		Cell cell9=row.createCell(8);
	       		String sub1= String.valueOf(sub.get(i)).toString();
	       		cell9.setCellValue(sub1);
	       		
	       		Cell cell10=row.createCell(9);
	       		String item1= String.valueOf(item.get(i)).toString();
	       		cell10.setCellValue(item1.replaceFirst("\\.0+$", ""));
	       		
	       		Cell cell11=row.createCell(10);
	       		String ppk1= String.valueOf(PPK.get(i)).toString();
	       		cell11.setCellValue(ppk1.replaceFirst("\\.0+$", ""));
	       		
	       		Cell cell12=row.createCell(11);
	       		String itemd= String.valueOf(itemdesc.get(i)).toString();
	       		cell12.setCellValue(itemd.trim());
	       		
	       		Cell cell13=row.createCell(12);
	       		String ppm1= String.valueOf(ppm.get(i)).toString();
	       		cell13.setCellValue(ppm1.trim());
	       		
	       		Cell cell14=row.createCell(13);
	       		String rptbrnd= String.valueOf(brandlist1.get(i)).toString();
	       		cell14.setCellValue(rptbrnd.trim());
	       		
	       		Cell cell15=row.createCell(14);
	       		String chhnl= String.valueOf(Channel.get(i)).toString();
	       		cell15.setCellValue(chhnl.trim());
	       		
	       		Cell cell16=row.createCell(15);
	       		String c= String.valueOf(countryList1.get(i)).toString();
	       		cell16.setCellValue(c.trim());
	       		
	       		Cell cell17=row.createCell(16);
	       		String ibo1= String.valueOf(ibo.get(i)).toString();
	       		cell17.setCellValue(ibo1.trim());
	       		
	       		Cell cell18=row.createCell(17);
	       		String merchid1= String.valueOf(merchid.get(i)).toString();
	       		cell18.setCellValue(merchid1);
	       		
	       		Cell cell19=row.createCell(18);
	       		String sd= String.valueOf(SourcingDirector.get(i)).toString();
	       		cell19.setCellValue(sd.trim());
	       		
	       		Cell cell20=row.createCell(19);
	       		String cat= String.valueOf(category.get(i)).toString();
	       			
	       			cell20.setCellValue(cat.trim());
	       		
	       		Cell cell21=row.createCell(20);
	       		String sourcingsub= String.valueOf(sorucingsub.get(i)).toString();
	       		cell21.setCellValue(sourcingsub);
	       		
	       		Cell cell22=row.createCell(21);
	       		String class1= String.valueOf(classification.get(i)).toString();
	       		
	       		cell22.setCellValue(class1.trim());
	       		
	       		Cell cell23=row.createCell(22);
	       		String dcd1= String.valueOf(dcd.get(i));
	       		cell23.setCellValue(dcd1);
	       		
	       		Cell cell24=row.createCell(23);
	       		String eta1= String.valueOf(eta.get(i));
	       		cell24.setCellValue(eta1);
	       		
	       		Cell cell25=row.createCell(24);
	       		
	       		//String quant= String.valueOf(unit.get(i));
	       		if(i>0)
	       		{
	       		String quant= String.valueOf(unit.get(i)).toString();
	       		if(quant.equalsIgnoreCase(null)||quant.equalsIgnoreCase("")||quant.equalsIgnoreCase(" "))
	       			cell25.setCellValue(quant);
	       		else
	       		cell25.setCellValue(quant.substring(1));
	       		}
	       		else
	       		{
	       			String quant= String.valueOf(unit.get(i)).toString();
	       			if(quant.equalsIgnoreCase(null)||quant.equalsIgnoreCase("")||quant.equalsIgnoreCase(" "))
		       			cell25.setCellValue(quant);
		       		else
		       		cell25.setCellValue(quant.substring(1));
		       		
	       		}
	       		
	       		Cell cell26=row.createCell(25);
	       		if(i>0)
	       		{
	       		String dol1= String.valueOf(dol.get(i)).toString();
	       		if(dol1.equalsIgnoreCase(null)||dol1.equalsIgnoreCase("")||dol1.equalsIgnoreCase(" "))
	       			cell26.setCellValue(dol1);
	       		else
	       			cell26.setCellValue(dol1.substring(1));
	       		}
	       		else
	       		{
	       			String dol1= String.valueOf(dol.get(i)).toString();
	       			if(dol1.equalsIgnoreCase(null)||dol1.equalsIgnoreCase("")||dol1.equalsIgnoreCase(" "))
	       				cell26.setCellValue(dol1);
		       		else
		       			cell26.setCellValue(dol1.substring(1));
		       		
	       		}
	       		
	       		
	       		
	       		Cell cell27=row.createCell(26);
	       		
	       		if(i>0)
	       		{
	       		String elc1= String.valueOf(elc.get(i)).toString();
	       		if(elc1.equalsIgnoreCase(null)||elc1.equalsIgnoreCase("")||elc1.equalsIgnoreCase(" "))
	       			cell27.setCellValue(elc1);
	       		else
	       			cell27.setCellValue(elc1.substring(1));
	       		}
	       		else
	       		{
	       			String elc1= String.valueOf(elc.get(i)).toString();
	       			if(elc1.equalsIgnoreCase(null)||elc1.equalsIgnoreCase("")||elc1.equalsIgnoreCase(" "))
	       				cell27.setCellValue(elc1);
		       		else
		       			cell27.setCellValue(elc1.substring(1));
		       		
	       		}
	       		
	       		
	    		
       	}
	    
	    FileOutputStream outputStream1 = new FileOutputStream(Errorfilename);
	    workbook1.write(outputStream1);
    	outputStream1.close();
    	
	}
}
