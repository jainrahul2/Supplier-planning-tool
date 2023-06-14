package net.codejava.javaee.brand;
 
public class Login {
    private int user_id;
    private  String first_name;
    private String email_id;
    private String last_name;
    public Login(int user_id, String first_name, String email_id, String last_name, String password) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.email_id = email_id;
		this.last_name = last_name;
		this.password = password;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Login(int user_id) {
		super();
		this.user_id = user_id;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Login(String email_id) {
		// TODO Auto-generated constructor stub
	}
	public  String getFirst_name() {
		return first_name;
	}
	public Login(int user_id, String first_name, String email_id, String password) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.email_id = email_id;
		this.password = password;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
 
    // getters and setters are not shown for brevity   
     
}