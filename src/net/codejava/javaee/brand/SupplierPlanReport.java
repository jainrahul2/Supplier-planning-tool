package net.codejava.javaee.brand;

public class SupplierPlanReport {

	protected String brand="";
	protected String division="";
	protected String sub="";
	protected String coo="";
	protected int Fob$;
	protected int Unit;
	protected String rpt_supplier="";
	
	public String getRpt_supplier() {
		return rpt_supplier;
	}
	public void setRpt_supplier(String rpt_supplier) {
		this.rpt_supplier = rpt_supplier;
	}
	public SupplierPlanReport(String brand, String division, String sub, String coo, int fob$, int unit,
			String rpt_supplier) {
		super();
		this.brand = brand;
		this.division = division;
		this.sub = sub;
		this.coo = coo;
		Fob$ = fob$;
		Unit = unit;
		this.rpt_supplier = rpt_supplier;
	}
	
	public SupplierPlanReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getCoo() {
		return coo;
	}
	public void setCoo(String coo) {
		this.coo = coo;
	}
	public int getFob$() {
		return Fob$;
	}
	public void setFob$(int fob$) {
		Fob$ = fob$;
	}
	public int getUnit() {
		return Unit;
	}
	public void setUnit(int unit) {
		Unit = unit;
	}
	

}