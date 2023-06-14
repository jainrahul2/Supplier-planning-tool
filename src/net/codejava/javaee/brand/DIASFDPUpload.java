package net.codejava.javaee.brand;

public class DIASFDPUpload {
	
	

	protected  String country_name="";
	protected String rpt_brand="";

	public String getRpt_brand() {
		return rpt_brand;
	}

	public void setRpt_brand(String rpt_brand) {
		this.rpt_brand = rpt_brand;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public DIASFDPUpload(String country_name) {
		super();
		this.country_name = country_name;
	}

}
