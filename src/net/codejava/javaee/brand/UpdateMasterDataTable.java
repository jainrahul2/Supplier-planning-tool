package net.codejava.javaee.brand;

import java.sql.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class UpdateMasterDataTable {

	public void getdeletemaster() throws ClassNotFoundException 
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        //diasUploadDAO up= new diasUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
	        Connection con = (Connection) DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
	       
	        //String dias_id=up.getLastID(filename);
	        //int dias_id1=Integer.valueOf(dias_id);
//          dias_id1=dias_id1-1;
//          dias_id=String.valueOf(dias_id1);
	        Statement statement = con.createStatement();
	        String sql = "delete from SA_ANALYTICS.SPT.master_data";
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
	
	public void getinsertMaster() throws IOException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        //FDPUploadDAO up= new FDPUploadDAO("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433", "sqladmin", "sqladmin2017");
	        //String fdp_id=up.getLastID(filename);
	       
//	           int fdp_id1=Integer.valueOf(fdp_id);
//	           fdp_id1=fdp_id1+1;
//	           fdp_id=String.valueOf(fdp_id1);
	        //int fdp_id1=Integer.valueOf(fdp_id);
            Connection con = DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
            Statement stmt= con.createStatement();
            String sql = "INSERT INTO SA_ANALYTICS.SPT.master_data(yr,ppm,dsd,sourcing_director,sourcing_manager,major_category,sourcing_category,sourcing_sub_cat,classification,rpt_supplier,rpt_brand,country,plan_level,plan_name,channel,fashion_or_replenishment,pps,flow_model,division,sub,lot,ppk,dir,item_description,year,month,units,fob$,avg_fob,elc_dol,avg_elc_dol,af_ind,spt_date) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            	//System.out.println("SQL Statement "+sql);
            PreparedStatement pstm = con.prepareStatement(sql);
            con.setAutoCommit(false);
//            String fdp_id=up.getLastID();
//			 int fdp_id1=Integer.valueOf(fdp_id);
//		     fdp_id1=fdp_id1+1;
//	        fdp_id=String.valueOf(fdp_id1);
//	        
//            String Path=path;
//            String year="";
//            File myFile = new File(Path);
//	        FileInputStream fis = new FileInputStream(myFile);
//	        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
//	        Pattern pattern = Pattern.compile("(\\d{4})");
//
//			 Matcher matcher = pattern.matcher(filename);
//			   
//			    if (matcher.find()) {
//			        //System.out.println(matcher.group(1));
//			    	year=matcher.group(1);
//			        //val = matcher.group(1);
//			    }
			    //Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
				
	            
	        //ArrayList<Cell> planname= new ArrayList<Cell>();
	        //ArrayList<Cell> fobdol= new ArrayList<Cell>();
            //Sheet sheet = myWorkBook.getSheetAt(0);
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
            //System.out.println(sheet.getPhysicalNumberOfRows()+"   "+sheet.getLastRowNum());
           // ArrayList<Cell> countryList=new ArrayList<Cell>();
            //Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
//			int counter=0;
//			while (itr.hasNext())                 
//			{  
//				
//				Row row = itr.next();
//				//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
//				Cell country = row.getCell(0);
//				if(country!=null&&country.getCellType() != Cell.CELL_TYPE_BLANK)
//				{
//				counter++;
//				 
//				countryList.add(country);
//				
//				}
//				
//				
//			}
//			countryList.subList(0, 2).clear();
//			System.out.print(countryList+ " " +counter);
			
			//System.out.println(sheet.getPhysicalNumberOfRows()-countryList.size());
            String sqlfdpmaster = "select * from  SA_ANALYTICS.SPT.fdp_master";
            ResultSet resultSet = stmt.executeQuery(sqlfdpmaster);
            String yr="";
            String year="2020";
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy");
 		   	LocalDateTime now = LocalDateTime.now();
 		 
 			String curryear=dtf3.format(now);
 			if(!(curryear.equalsIgnoreCase(year)))
 			{
 				
 				year=String.valueOf((Double.valueOf(curryear))+1).toString();
 			}
 			else 
 			{
 				year=curryear;
 			}
            while (resultSet.next()) {
				
                			//System.out.println;
            			 	int m =0;
            			 	if(resultSet.getString("month").equalsIgnoreCase("feb"))
            			 		yr= "QP1"+year+resultSet.getString("month")+"ACT/FCST";
            			 	if(resultSet.getString("month").equalsIgnoreCase("mar"))
            			 		yr= year+resultSet.getString("month")+"ACT/FCST";
            			 	if(resultSet.getString("month").equalsIgnoreCase("apr"))
            			 		yr= year+resultSet.getString("month")+"ACT/FCST";
            			 	if(resultSet.getString("month").equalsIgnoreCase("may"))		
            			 		yr= "QP2"+year+resultSet.getString("month")+"ACT/FCST";
                			if(resultSet.getString("month").equalsIgnoreCase("jun"))		
                				yr= year+resultSet.getString("month")+"ACT/FCST";
                    	 	if(resultSet.getString("month").equalsIgnoreCase("jul"))		
                    	 		yr= year+resultSet.getString("month")+"ACT/FCST";
              			 	if(resultSet.getString("month").equalsIgnoreCase("aug"))	
              			 		yr= "QP3"+year+resultSet.getString("month")+"ACT/FCST";
              			    if(resultSet.getString("month").equalsIgnoreCase("sept"))
              			    	yr= year+resultSet.getString("month")+"ACT/FCST";
              			    if(resultSet.getString("month").equalsIgnoreCase("oct"))	
              			    	yr= year+resultSet.getString("month")+"ACT/FCST";
              			    if(resultSet.getString("month").equalsIgnoreCase("nov"))
              			    	yr= "QP4"+year+resultSet.getString("month")+"ACT/FCST";
              			    if(resultSet.getString("month").equalsIgnoreCase("dec"))	
              			    	yr= year+resultSet.getString("month")+"ACT/FCST";
              			    if(resultSet.getString("month").equalsIgnoreCase("jan")) 
              			    	yr= year+resultSet.getString("month")+"ACT/FCST";
              			     pstm.setString(++m, String.valueOf(yr));
                             pstm.setString(++m, String.valueOf(resultSet.getString("ppm")));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("sourcing_director")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("sourcing_manager")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("major_category")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("sourcing_category")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("sourcing_sub_cat")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("classification")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("rpt_supplier")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("rpt_brand")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("country")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("plan_level")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("plan_name")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("channel")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("fashion_or_replenishment")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("pps")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("flow_model")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("division")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("sub")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("lot")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("ppk")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("dir")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("item_description")));
                             pstm.setString(++m, String.valueOf(year));
                             pstm.setString(++m, String.valueOf(resultSet.getString("month")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("units")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("fob$")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("avg_fob")));
                             pstm.setString(++m, String.valueOf("0.0"));
                             pstm.setString(++m, String.valueOf("0.0"));
                             pstm.setString(++m, String.valueOf("ACT/FCS"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("added_date")));	
                        	
                             pstm.addBatch();
                             
                             if (m % 500 == 0) {
                              	
                                 pstm.executeBatch();
                                 
                              }
            			 	 
                            
            		 
                	 
                    
            		} 
                		 
                			
                		 
                		
                     
                
                
                
                
                
                
                
                //System.out.println("value initiated");
   

	 
	 
			
                  
            
                
            pstm.executeBatch();
            
           
            con.commit();
            
            con.close();
            
        //System.out.println("Success");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
    }
	
	public void getinsertMasterDiasData() throws IOException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        
            Connection con = DriverManager.getConnection("jdbc:sqlserver://supplychain-latest.ctp4kn24iwvj.us-east-1.rds.amazonaws.com:1433","sqladmin", "sqladmin2017");
            Statement stmt= con.createStatement();
            String sql = "INSERT INTO SA_ANALYTICS.SPT.master_data(yr,ppm,dsd,sourcing_director,sourcing_manager,major_category,sourcing_category,sourcing_sub_cat,classification,rpt_supplier,rpt_brand,country,plan_level,plan_name,channel,fashion_or_replenishment,pps,flow_model,division,sub,lot,ppk,dir,item_description,year,month,units,fob$,avg_fob,elc_dol,avg_elc_dol,af_ind,spt_date)	VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            	//System.out.println("SQL Statement "+sql);
            PreparedStatement pstm = con.prepareStatement(sql);
            con.setAutoCommit(false);
//            String fdp_id=up.getLastID();
//			 int fdp_id1=Integer.valueOf(fdp_id);
//		     fdp_id1=fdp_id1+1;
//	        fdp_id=String.valueOf(fdp_id1);
//	        
//            String Path=path;
//            String year="";
//            File myFile = new File(Path);
//	        FileInputStream fis = new FileInputStream(myFile);
//	        XSSFWorkbook myWorkBook = new XSSFWorkbook (fis);
//	        Pattern pattern = Pattern.compile("(\\d{4})");
//
//			 Matcher matcher = pattern.matcher(filename);
//			   
//			    if (matcher.find()) {
//			        //System.out.println(matcher.group(1));
//			    	year=matcher.group(1);
//			        //val = matcher.group(1);
//			    }
			    //Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
				
	            
	        //ArrayList<Cell> planname= new ArrayList<Cell>();
	        //ArrayList<Cell> fobdol= new ArrayList<Cell>();
            //Sheet sheet = myWorkBook.getSheetAt(0);
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
            //System.out.println(sheet.getPhysicalNumberOfRows()+"   "+sheet.getLastRowNum());
           // ArrayList<Cell> countryList=new ArrayList<Cell>();
            //Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
//			int counter=0;
//			while (itr.hasNext())                 
//			{  
//				
//				Row row = itr.next();
//				//Iterator<Cell> cellIterator = row.cellIterator();//iterating over each column
//				Cell country = row.getCell(0);
//				if(country!=null&&country.getCellType() != Cell.CELL_TYPE_BLANK)
//				{
//				counter++;
//				 
//				countryList.add(country);
//				
//				}
//				
//				
//			}
//			countryList.subList(0, 2).clear();
//			System.out.print(countryList+ " " +counter);
			
			//System.out.println(sheet.getPhysicalNumberOfRows()-countryList.size());
            String sqlfdpmaster = "select * from  SA_ANALYTICS.SPT.DIAS_MASTER";
            ResultSet resultSet = stmt.executeQuery(sqlfdpmaster);
            String yr="";
            String year="2020";
            String Units="0.0";
            String ELC="0.0";
            String FOB$="0.0";
            String avg_fob="0.0";
            String result="";
            String result1="";
            DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy");
 		   	LocalDateTime now = LocalDateTime.now();
 		 
 			String curryear=dtf3.format(now);
 			if(!(curryear.equalsIgnoreCase(year)))
 			{
 				
 				year=String.valueOf((Integer.getInteger(curryear))+1).toString();
 			}
 			else 
 			{
 				year=curryear;
 			}
            while (resultSet.next()) {
				
                	
            			 	int m =0;
            			 	if(resultSet.getString("month").equalsIgnoreCase("feb"))
            			 		yr= year+resultSet.getString("month")+"QP1"+"ACT";
            			 	if(resultSet.getString("month").equalsIgnoreCase("mar"))
            			 		yr= year+resultSet.getString("month")+"ACT";
            			 	if(resultSet.getString("month").equalsIgnoreCase("apr"))
            			 		yr= year+resultSet.getString("month")+"ACT";
            			 	if(resultSet.getString("month").equalsIgnoreCase("may"))		
            			 		yr= year+resultSet.getString("month")+"QP2"+"ACT";
                			if(resultSet.getString("month").equalsIgnoreCase("jun"))		
                				yr= year+resultSet.getString("month")+"ACT";
                    	 	if(resultSet.getString("month").equalsIgnoreCase("jul"))		
                    	 		yr= year+resultSet.getString("month")+"ACT";
              			 	if(resultSet.getString("month").equalsIgnoreCase("aug"))	
              			 		yr= year+resultSet.getString("month")+"QP3"+"ACT/FCST";
              			    if(resultSet.getString("month").equalsIgnoreCase("sept"))
              			    	yr= year+resultSet.getString("month")+"ACT";
              			    if(resultSet.getString("month").equalsIgnoreCase("oct"))	
              			    	yr= year+resultSet.getString("month")+"ACT";
              			    if(resultSet.getString("month").equalsIgnoreCase("nov"))
              			    	yr= year+resultSet.getString("month")+"QP4"+"ACT";
              			    if(resultSet.getString("month").equalsIgnoreCase("dec"))	
              			    	yr= year+resultSet.getString("month")+"ACT";
              			    if(resultSet.getString("month").equalsIgnoreCase("jan")) 
              			    	yr= year+resultSet.getString("month")+"ACT";
              			     pstm.setString(++m, String.valueOf(yr));
                             pstm.setString(++m, String.valueOf(resultSet.getString("PPM")));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Sourcing_Director")));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Sourcing_Category")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Sourcing_Sub_Cat")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Classification")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Rpt_Supplier")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Rpt_Brand")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Country")));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Channel")));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("SUB")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("LOT")));
                             pstm.setString(++m, String.valueOf(resultSet.getString("PPK")));
                             pstm.setString(++m, String.valueOf("null"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Item_Description")));
                             pstm.setString(++m, String.valueOf(year));
                             pstm.setString(++m, String.valueOf(resultSet.getString("Month")));
                             if(resultSet.getString("Units").equalsIgnoreCase("")||resultSet.getString("Units").equalsIgnoreCase(" ")||resultSet.getString("Units").equalsIgnoreCase(null))
                             
                            	 Units="0.0";
                             else
                            	 Units=resultSet.getString("Units");
                             
                             
                             pstm.setString(++m, String.valueOf(Units));
                             
                            
                             if(resultSet.getString("FOB$").equalsIgnoreCase("")||resultSet.getString("FOB$").equalsIgnoreCase(" ")||resultSet.getString("FOB$").equalsIgnoreCase(null))
                                 
                            	 FOB$="0.0";
                             else
                            	 FOB$=resultSet.getString("FOB$");
                             
                             pstm.setString(++m, String.valueOf(FOB$));
                             if(resultSet.getString("FOB$").equalsIgnoreCase("")||resultSet.getString("FOB$").equalsIgnoreCase(" ")||resultSet.getString("FOB$").equalsIgnoreCase(null)||resultSet.getString("Units").equalsIgnoreCase("")||resultSet.getString("Units").equalsIgnoreCase(" ")||resultSet.getString("Units").equalsIgnoreCase(null))
                                 result1="null";
                             else
                             {
                            	 //String[] fob=resultSet.getString("FOB$").split(",");
                            	 //String fobfinal=fob[0].concat(fob[1]);
                            	 String unitfinal="";
                            	 double units;
                            	 if(resultSet.getString("Units").contains(",")) {
                            	 String[] unt=resultSet.getString("Units").split(",");
                            	 unitfinal=unt[0].concat(unt[1]);
                            	 units=Double.parseDouble(unitfinal);
                            	 }
                            	 else {
                            		 units=(Double.parseDouble(resultSet.getString("Units")));
                            		 //unitfinal=String.valueOf(units);
                            	 }
                            	 
                            	 String fobfinal="";
                            	 double fobs;
                            	 if(resultSet.getString("FOB$").contains(",")) {
                            	 String[] fb=resultSet.getString("FOB$").split(",");
                            	 fobfinal=fb[0].concat(fb[1]);
                            	 fobs=Double.parseDouble(fobfinal);
                            	 }
                            	 else {
                            		 fobs=(Double.parseDouble(resultSet.getString("FOB$")));
                            		 //unitfinal=String.valueOf(units);
                            	 }
                            	 
                            	 
                            	 result1=String.valueOf(fobs/units);
                             }
                             pstm.setString(++m, String.valueOf(result1));
                             if(resultSet.getString("ELC").equalsIgnoreCase("")||resultSet.getString("ELC").equalsIgnoreCase(" ")||resultSet.getString("ELC").equalsIgnoreCase(null))
                                 
                            	 ELC="0.0";
                             else
                            	 ELC=resultSet.getString("ELC");
                             
                             pstm.setString(++m, String.valueOf(ELC));
                             if(resultSet.getString("ELC").equalsIgnoreCase("")||resultSet.getString("ELC").equalsIgnoreCase(" ")||resultSet.getString("ELC").equalsIgnoreCase(null)||resultSet.getString("Units").equalsIgnoreCase("")||resultSet.getString("Units").equalsIgnoreCase(" ")||resultSet.getString("Units").equalsIgnoreCase(null))
                                 result="null";
                             else
                             {
                            	 //String[] fob=resultSet.getString("ELC").split(",");
                            	 //String fobfinal=fob[0].concat(fob[1]);
                            	 String unitfinal="";
                            	 double units;
                            	 if(resultSet.getString("Units").contains(",")) {
                            	 String[] unt=resultSet.getString("Units").split(",");
                            	 unitfinal=unt[0].concat(unt[1]);

                            	 units=Double.parseDouble(unitfinal);
                            	 }
                            	 else {
                            		 units=(Double.parseDouble(resultSet.getString("Units")));
                            		 //unitfinal=String.valueOf(units);
                            	 }
                            	 
                            	 String fobfinal="";
                            	 double fobs;
                            	 if(resultSet.getString("ELC").contains(",")) {
                            	 String[] fb=resultSet.getString("ELC").split(",");
                            	 fobfinal=fb[0].concat(fb[1]);
                            	 fobs=Double.parseDouble(fobfinal);
                            	 }
                            	 else {
                            		 fobs=(Double.parseDouble(resultSet.getString("ELC")));
                            		 //unitfinal=String.valueOf(units);
                            	 }
                            	 
                            	 //result1=String.valueOf((Double.parseDouble(fobfinal))/(Double.parseDouble(unitfinal)));
                            	 result=String.valueOf(fobs/units);
                             }
                             pstm.setString(++m, String.valueOf(result));
                             pstm.setString(++m, String.valueOf("ACT"));
                             pstm.setString(++m, String.valueOf(resultSet.getString("added_date")));	
                        	
                             pstm.addBatch();
                             
                             if (m % 500 == 0) {
                              	
                                 pstm.executeBatch();
                                 
                              }
            			 	 
                            
            		 
                	 
                    
            		} 
                		 
                			
                		 
                		
                     
                
                
                
                
                
                
                
                //System.out.println("value initiated");
   

	 
	 
			
                  
            
                
            pstm.executeBatch();
            
           
            con.commit();
            
            con.close();
            
        //System.out.println("Success in dias");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
    }
	
	
	
}
