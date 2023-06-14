package net.codejava.javaee.brand;

public class MDSEList {

protected String code="";
protected String division_number="";
protected String division_name="";
protected String entity_number="";
protected String entity_name="";
protected String subdivison_number="";
protected String subdivision_name="";
protected String cls="";
protected String status="";
public MDSEList( String code,String division_number, String division_name, String entity_number, String entity_name,
		String subdivison_number, String subdivision_name, String cls, String status) {
	super();
	this.code=code;
	this.division_number = division_number;
	this.division_name = division_name;
	this.entity_number = entity_number;
	this.entity_name = entity_name;
	this.subdivison_number = subdivison_number;
	this.subdivision_name = subdivision_name;
	this.cls = cls;
	this.status = status;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public MDSEList(String code) {
	super();
	this.code = code;
}
public MDSEList() {
	super();
	// TODO Auto-generated constructor stub
}
public String getDivision_number() {
	return division_number;
}
public void setDivision_number(String division_number) {
	this.division_number = division_number;
}
public String getDivision_name() {
	return division_name;
}
public void setDivision_name(String division_name) {
	this.division_name = division_name;
}
public String getEntity_number() {
	return entity_number;
}
public void setEntity_number(String entity_number) {
	this.entity_number = entity_number;
}
public String getEntity_name() {
	return entity_name;
}
public void setEntity_name(String entity_name) {
	this.entity_name = entity_name;
}
public String getSubdivison_number() {
	return subdivison_number;
}
public void setSubdivison_number(String subdivison_number) {
	this.subdivison_number = subdivison_number;
}
public String getSubdivision_name() {
	return subdivision_name;
}
public void setSubdivision_name(String subdivision_name) {
	this.subdivision_name = subdivision_name;
}
public String getCls() {
	return cls;
}
public void setCls(String cls) {
	this.cls = cls;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}





}


