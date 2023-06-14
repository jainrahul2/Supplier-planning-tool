package net.codejava.javaee.brand;

public class BrandList {
	protected  String brand_number="";
    protected  String rpt_brand="";
	protected  String child_brand="";
	protected  String brand_type="";
	protected  String status="";
	public BrandList(String brand_number, String rpt_brand, String child_brand, String brand_type, String status) {
		super();
		this.brand_number = brand_number;
		this.rpt_brand = rpt_brand;
		this.child_brand = child_brand;
		this.brand_type = brand_type;
		this.status = status;
	}
	
	
	
	public BrandList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BrandList(String brand_number) {
		// TODO Auto-generated constructor stub
		this.brand_number=brand_number;
	}
	
	
	

	public String getBrand_number() {
		return brand_number;
	}
	public void setBrand_number(String brand_number) {
		this.brand_number = brand_number;
	}
	public String getRpt_brand() {
		return rpt_brand;
	}
	public void setRpt_brand(String rpt_brand) {
		this.rpt_brand = rpt_brand;
	}
	public String getChild_brand() {
		return child_brand;
	}
	public void setChild_brand(String child_brand) {
		this.child_brand = child_brand;
	}
	public String getBrand_type() {
		return brand_type;
	}
	public void setBrand_type(String brand_type) {
		this.brand_type = brand_type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}