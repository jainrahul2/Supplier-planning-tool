package net.codejava.javaee.brand;
import java.util.*;

import javax.persistence.*;

@Entity
public class UserSetting implements java.io.Serializable {
    
	private int user_id;
    private String first_name;
    private String last_name;
    private String email_id;
    private String newpassword;
    private String confirmpassword;
    
    private Set<UserAuthentication> UserAuthTokens = new HashSet<>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "SA_ANALYTICS.dbo.user_login")  
    public Set<UserAuthentication> getUserAuthTokens() {
        return UserAuthTokens;
    }
    
    public UserSetting(String email_id, String newpassword) {
		super();
		this.email_id = email_id;
		this.newpassword = newpassword;
	}

	public UserSetting(int user_id, String first_name, String last_name, String email_id, String newpassword,
			String confirmpassword) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
	}
	public UserSetting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserSetting(String email_id, String newpassword, String confirmpassword) {
		super();
		this.email_id = email_id;
		this.newpassword = newpassword;
		this.confirmpassword = confirmpassword;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
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
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
}