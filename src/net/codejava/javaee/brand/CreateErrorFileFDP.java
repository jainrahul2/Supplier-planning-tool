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

public class CreateErrorFileFDP {
	
	@SuppressWarnings("unchecked")
	public void createErrorFileFDP(String filename,String Errorfilename,int rowcount,TreeMap<Integer, ArrayList<String>> errormap) throws IOException
	{
		//ValidationDIAS dias= new ValidationDIAS("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");

		
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
		ArrayList Units = new ArrayList();
		ArrayList Fob$=new ArrayList();
		//String Month= Month[q];            			 	
		ArrayList Avg_fob = new ArrayList();
		ArrayList Commment = new ArrayList();

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
		TreeMap<Integer,ArrayList> unitData=new TreeMap<Integer,ArrayList>();
		TreeMap<Integer,ArrayList> dollardata=new TreeMap<Integer,ArrayList>();
		TreeMap<Integer,ArrayList> fobdata=new TreeMap<Integer,ArrayList>();
		DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		String Month[]= {"feb", "mar","apr","may","jun","jul","aug","sept","oct","nov","dec","jan"};
		int rowTotal = sheet.getLastRowNum();

		 if ((rowTotal > 0) || (sheet.getPhysicalNumberOfRows() > 0)) {
		     rowTotal++;
		 }
		 
		for(int k=2;k<rowTotal;k++)
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
			 	for(int q=0;q<Month.length;q++)
	            {
			 		
    			 	
			 	Cell units = row.getCell(22+q);
			 	Cell fob$=row.getCell(35+q);
			 	Cell avg_fob = row.getCell(48+q);
			 
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
			 	Commment.add(commment);
		 }
		
		XSSFWorkbook workbook1 = new XSSFWorkbook(); 
        XSSFSheet sheet1 = workbook1.createSheet("FileWithError");
	    Cell cell1=null;
	    Row row3 = null;
	    Row row;

	    int countRowNumber=0;
	    //DataFormatter formatter = new DataFormatter();
	    Row row1= sheet1.createRow(0);
	    Cell cell= row1.createCell(0);
	    cell.setCellValue("2020");
	    for(int i=1;i<rowcount;i++)
       	{
	    	
	    	row= sheet1.createRow(i);
	    	//Row row1 = sheet.getRow(i);
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
		    	UploadServlet ds= new UploadServlet();
		    	ds.getcounterForRowStatus(countRowNumber);
		    }
		    Cell cell2= row.createCell(1);
		    String ppm = String.valueOf(Ppm.get(i));
		    cell2.setCellValue(ppm);

		    Cell cell3= row.createCell(2);
		    String sourcing_director = String.valueOf(Sourcing_director.get(i));
		    cell3.setCellValue(sourcing_director);

		    Cell cell4= row.createCell(3);
		    String sourcing_manager = String.valueOf(Sourcing_manager.get(i));
		    cell4.setCellValue(sourcing_manager);

		    Cell cell5= row.createCell(4);
		    String major_category = String.valueOf(Major_category.get(i));
		    cell5.setCellValue(major_category);

		    Cell cell6= row.createCell(5);
		    String sourcing_category = String.valueOf(Sourcing_category.get(i));
		    cell6.setCellValue(sourcing_category);

		    Cell cell7= row.createCell(6);
		    String sourcing_sub_cat = String.valueOf(Sourcing_sub_cat.get(i));
		    cell7.setCellValue(sourcing_sub_cat);

		    Cell cell8= row.createCell(7);
		    String classification = String.valueOf(Classification.get(i));
		    cell8.setCellValue(classification);

		    Cell cell9= row.createCell(8);
		    String rpt_supplier = String.valueOf(Rpt_supplier.get(i));
		    cell9.setCellValue(rpt_supplier);

		    Cell cell10= row.createCell(9);
		    String rpt_brand = String.valueOf(Rpt_brand.get(i));
		    cell10.setCellValue(rpt_brand);

		    Cell cell11= row.createCell(10);
		    String country = String.valueOf(Country.get(i));
		    cell11.setCellValue(country);

		    Cell cell12= row.createCell(11);
		    String plan_level = String.valueOf(Plan_level.get(i));
		    cell12.setCellValue(plan_level);

		    Cell cell13= row.createCell(12);
		    String plan_name = String.valueOf(Plan_name.get(i));
		    cell13.setCellValue(plan_name);

		    Cell cell14= row.createCell(13);
		    String channel = String.valueOf(Channel.get(i));
		    cell14.setCellValue(channel);

		    Cell cell15= row.createCell(14);
		    String fashion_or_replenishment = String.valueOf(Fashion_or_replenishment.get(i));
		    cell15.setCellValue(fashion_or_replenishment);

		    Cell cell16= row.createCell(15);
		    String pps = String.valueOf(Pps.get(i));
		    cell16.setCellValue(pps);

		    Cell cell17= row.createCell(16);
		    String flow_model = String.valueOf(Flow_model.get(i));;
		    cell17.setCellValue(flow_model);

		    Cell cell18= row.createCell(17);
		    String division = String.valueOf(Division.get(i));
		    cell18.setCellValue(division);

		    Cell cell19= row.createCell(18);
		    String sub = String.valueOf(Sub.get(i));
		    cell19.setCellValue(sub);

		    Cell cell20= row.createCell(19);
		    String lot = String.valueOf(Lot.get(i));
		    cell20.setCellValue(lot);

		    Cell cell21= row.createCell(20);
		    String ppk = String.valueOf(Ppk.get(i));
		    cell21.setCellValue(ppk);

		    Cell cell22= row.createCell(21);
		    String dir = String.valueOf(Dir.get(i));
		    cell22.setCellValue(dir);

		    Cell cell23= row.createCell(22);
		    String item_description = String.valueOf(Item_description.get(i));
		    cell23.setCellValue(item_description);
		    for(int q=0;q<Month.length;q++)
            {
		    	Cell units = row1.getCell(22+q);
			 	Cell fob$=row1.getCell(35+q);
			 	Cell avg_fob = row1.getCell(48+q);
			 	
		    	Cell unitFinal = row.createCell(22+q);
		    	String unit= String.valueOf(units);
		    	unitFinal.setCellValue(unit);
		    	
		    	Cell fob$Final=row.createCell(35+q);
		    	String fob= String.valueOf(fob$);
		    	fob$Final.setCellValue(fob);
		    	
		 		Cell avg_fobFinal = row.createCell(48+q);
		 		String avfob= String.valueOf(avg_fob);
		 		avg_fobFinal.setCellValue(avfob);
		 
            }
		    Cell cell61= row.createCell(60);
		    String comment = String.valueOf(Commment.get(i));
		    cell61.setCellValue(comment);
	    		
       	}
	    
	    FileOutputStream outputStream1 = new FileOutputStream(Errorfilename);
	    workbook1.write(outputStream1);
    	outputStream1.close();
    	
	}
}
