package net.codejava.javaee.brand;

public class UserManagement
{
	
	protected String user_id="";
	protected String first_name="";
	protected String last_name="";
	protected String email_id="";
	protected String contact_number="";
	protected String role="";
	protected String Category="";
	protected String supporting="";
	protected String status="";
	public UserManagement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserManagement(String user_id, String first_name, String last_name, String email_id, String contact_number,
			String role, String category, String supporting, String status) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.contact_number = contact_number;
		this.role = role;
		this.Category = category;
		this.supporting=supporting;
		this.status = status;
	}
	public String getSupporting() {
		return supporting;
	}
	public UserManagement(String user_id) {
		super();
		this.user_id = user_id;
	}
	public void setSupporting(String supporting) {
		this.supporting = supporting;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

















}