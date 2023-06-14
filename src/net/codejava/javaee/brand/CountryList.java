package net.codejava.javaee.brand;

public class CountryList {
	protected  String country_code="";
    protected  String country_name="";
	protected  String status="";
	public CountryList(String country_code, String country_name, String status) {
		super();
		this.country_code = country_code;
		this.country_name = country_name;
		this.status = status;
	}
	public CountryList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCountry_code() {
		return country_code;
	}
	public void setCountry_code(String country_code) {
		this.country_code = country_code;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public CountryList(String country_code) {
		super();
		this.country_code = country_code;
	}




}