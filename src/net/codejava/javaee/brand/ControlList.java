package net.codejava.javaee.brand;

public class ControlList {
	protected  String id="";
    protected  String control_office="";
	protected  String region="";
	protected  String status="";
	public ControlList() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ControlList(String id, String control_office, String region, String status) {
		super();
		this.id = id;
		this.control_office = control_office;
		this.region = region;
		this.status = status;
	}
	public ControlList(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getControl_office() {
		return control_office;
	}
	public void setControl_office(String control_office) {
		this.control_office = control_office;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}




}