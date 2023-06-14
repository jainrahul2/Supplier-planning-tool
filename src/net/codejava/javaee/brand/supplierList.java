package net.codejava.javaee.brand;

/**
 * Book.java
 * This is a model class represents a book entity
 * @author www.codejava.net
 *
 */
public class supplierList{
	protected String supplier_number;
    protected String rpt_supplier=""; 
	protected String child_supplier="";
	protected String origin_indicator="";
	protected String major_category="";
	protected String country="";
	protected String ibo="";
	protected String region="";
	protected String supplier_plan="";
	protected String grade="";
	protected String status="";


	public supplierList() {
	}

	public supplierList(String supplier_number) {
		this.supplier_number = supplier_number;
	}

	public String getSupplier_number() {
		return supplier_number;
	}

	public void setSupplier_number(String supplier_number) {
		this.supplier_number = supplier_number;
	}

	public String getRpt_supplier() {
		return rpt_supplier;
	}

	public void setRpt_supplier(String rpt_supplier) {
		this.rpt_supplier = rpt_supplier;
	}

	public String getChild_supplier() {
		return child_supplier;
	}

	public void setChild_supplier(String child_supplier) {
		this.child_supplier = child_supplier;
	}

	public String getOrigin_indicator() {
		return origin_indicator;
	}

	public void setOrigin_indicator(String origin_indicator) {
		this.origin_indicator = origin_indicator;
	}

	public String getMajor_category() {
		return major_category;
	}

	public void setMajor_category(String major_category) {
		this.major_category = major_category;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIbo() {
		return ibo;
	}

	public void setIbo(String ibo) {
		this.ibo = ibo;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSupplier_plan() {
		return supplier_plan;
	}

	public void setSupplier_plan(String supplier_plan) {
		this.supplier_plan = supplier_plan;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public supplierList(String supplier_number, String rpt_supplier, String child_supplier, String origin_indicator,
			String major_category, String country, String ibo, String region, String supplier_plan, String grade,
			String status) {
		super();
		this.supplier_number = supplier_number;
		this.rpt_supplier = rpt_supplier;
		this.child_supplier = child_supplier;
		this.origin_indicator = origin_indicator;
		this.major_category = major_category;
		this.country = country;
		this.ibo = ibo;
		this.region = region;
		this.supplier_plan = supplier_plan;
		this.grade = grade;
		this.status = status;
	}
}
	