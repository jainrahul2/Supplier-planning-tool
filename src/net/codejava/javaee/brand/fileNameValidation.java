package net.codejava.javaee.brand;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class fileNameValidation {
	
	public String getFolderNameByMonth(String f)
	{
		String folderName=f;
		String folderByMonth="";
		try 
		{
			if(folderName.contains("Feb")||folderName.contains("Feburary")||folderName.contains("FEBURARY")||folderName.contains("feb")||folderName.contains("FEB")||folderName.contains("feburary"))
				folderByMonth="Feb";	
			else if(folderName.contains("Mar")||folderName.contains("March")||folderName.contains("MARCH")||folderName.contains("mar")||folderName.contains("MAR")||folderName.contains("march"))
				folderByMonth="Mar";
			else if(folderName.contains("Apr")||folderName.contains("April")||folderName.contains("APRIL")||folderName.contains("apr")||folderName.contains("APR")||folderName.contains("april"))
				folderByMonth="Apr";
			else if(folderName.contains("May")||folderName.contains("May")||folderName.contains("MAY")||folderName.contains("MAY")||folderName.contains("MAY")||folderName.contains("may"))
				folderByMonth="May";
			else if(folderName.contains("Jun")||folderName.contains("June")||folderName.contains("JUNE")||folderName.contains("jun")||folderName.contains("JUN")||folderName.contains("june"))
				folderByMonth="Jun";
			else if(folderName.contains("Jul")||folderName.contains("July")||folderName.contains("JULY")||folderName.contains("jul")||folderName.contains("JUL")||folderName.contains("july"))
				folderByMonth="Jul";
			else if(folderName.contains("Aug")||folderName.contains("August")||folderName.contains("AUGUST")||folderName.contains("aug")||folderName.contains("AUG")||folderName.contains("august"))
				folderByMonth="Aug";
			else if(folderName.contains("Sept")||folderName.contains("September")||folderName.contains("SEPTEMBER")||folderName.contains("sept")||folderName.contains("SEP")||folderName.contains("september"))
				folderByMonth="Sept";
			else if(folderName.contains("Oct")||folderName.contains("October")||folderName.contains("OCTOBER")||folderName.contains("oct")||folderName.contains("OCT")||folderName.contains("october"))
				folderByMonth="Oct";
			else if(folderName.contains("Nov")||folderName.contains("November")||folderName.contains("NOVEMBER")||folderName.contains("nov")||folderName.contains("NOV")||folderName.contains("november"))
				folderByMonth="Nov";
			else if(folderName.contains("Dec")||folderName.contains("December")||folderName.contains("DECEMBER")||folderName.contains("dec")||folderName.contains("DEC")||folderName.contains("december"))
				folderByMonth="Dec";
			else if(folderName.contains("Jan")||folderName.contains("January")||folderName.contains("JANUARY")||folderName.contains("jan")||folderName.contains("JAN")||folderName.contains("january"))
				folderByMonth="Jan";
			else 
				folderByMonth=null;
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return folderByMonth;

		
	}
	public Boolean getValidatedCurrentMonth(String folderByMonth)
	{
		boolean isCurrentMonth=false;
		String Month="";
		
		//String folderName="resourcesDIAS\\";
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("MM");
		//DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy");
		LocalDateTime now = LocalDateTime.now();
	 
		//String year=dtf3.format(now);
		switch (dtf2.format(now)) {
		case "01":
			Month="Jan";
			break; 
		case "02":
			Month="Feb";
			break;
		case "03":
			Month="Mar";
			break;
		case "04":
			Month="Apr";
			break;
		case "05":
			Month="May";
			break;
		case "06":
			Month="Jun";
			break;
		case "07":
			Month="Jul";
			break;
		case "08":
			Month="Aug";
			break;
		case "09":
			Month="Sept";
			break;
		case "10":
			Month="Oct";
			break;
		case "11":
			Month="Nov";
			break;
		case "12":
			Month="Dec";
			break;
		default :
			Month="Feb";
			break;
		}
		if(Month.equals(folderByMonth))
		{
			isCurrentMonth=true;
			//System.out.println(" isCurrentMonth " +isCurrentMonth +" "+Month);
		}
		else
		{
			isCurrentMonth=false;
			//System.out.println(" isCurrentMonth in else " +isCurrentMonth+""+Month);
		}
		return isCurrentMonth;
	}
}