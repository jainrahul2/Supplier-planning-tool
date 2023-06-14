package net.codejava.javaee.brand;

public class CategoryList {
	protected  String category_number="";
    protected  String major_category="";
	protected  String sourcing_category="";
	protected  String sourcing_sub_category="";
	protected  String classification="";
	protected  String status="";
	public CategoryList(String category_number, String major_category, String sourcing_category,
			String sourcing_sub_category, String classification, String status) {
		super();
		this.category_number = category_number;
		this.major_category = major_category;
		this.sourcing_category = sourcing_category;
		this.sourcing_sub_category = sourcing_sub_category;
		this.classification = classification;
		this.status = status;
	}
	public CategoryList(String major_category, String sourcing_category,
			String sourcing_sub_category, String classification, String status) {
		super();
		
		this.major_category = major_category;
		this.sourcing_category = sourcing_category;
		this.sourcing_sub_category = sourcing_sub_category;
		this.classification = classification;
		this.status = status;
	}
	public CategoryList(String category_number) {
		super();
		this.category_number = category_number;
	}
	public CategoryList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategory_number() {
		return category_number;
	}
	public void setCategory_number(String category_number) {
		this.category_number = category_number;
	}
	public String getMajor_category() {
		return major_category;
	}
	public void setMajor_category(String major_category) {
		this.major_category = major_category;
	}
	public String getSourcing_category() {
		return sourcing_category;
	}
	public void setSourcing_category(String sourcing_category) {
		this.sourcing_category = sourcing_category;
	}
	public String getSourcing_sub_category() {
		return sourcing_sub_category;
	}
	public void setSourcing_sub_category(String sourcing_sub_category) {
		this.sourcing_sub_category = sourcing_sub_category;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}