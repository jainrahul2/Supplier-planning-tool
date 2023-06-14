package net.codejava.javaee.brand;

public class reprotingSupplierReport {
	
	protected int FOB_DOL;
	protected int UNITS;
	protected String Rpt__Brand;
	protected String Division;
	protected String Sub;
	protected String Country;
	public int getFOB_DOL() {
		return FOB_DOL;
	}
	public void setFOB_DOL(int fOB_DOL) {
		FOB_DOL = fOB_DOL;
	}
	public int getUNITS() {
		return UNITS;
	}
	public void setUNITS(int uNITS) {
		UNITS = uNITS;
	}
	public String getRpt__Brand() {
		return Rpt__Brand;
	}
	public void setRpt__Brand(String rpt__Brand) {
		Rpt__Brand = rpt__Brand;
	}
	public String getDivision() {
		return Division;
	}
	public void setDivision(String division) {
		Division = division;
	}
	public String getSub() {
		return Sub;
	}
	public void setSub(String sub) {
		Sub = sub;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public reprotingSupplierReport(int fOB_DOL, int uNITS, String rpt__Brand, String division, String sub,
			String country) {
		super();
		FOB_DOL = fOB_DOL;
		UNITS = uNITS;
		Rpt__Brand = rpt__Brand;
		Division = division;
		Sub = sub;
		Country = country;
	}
	public reprotingSupplierReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
