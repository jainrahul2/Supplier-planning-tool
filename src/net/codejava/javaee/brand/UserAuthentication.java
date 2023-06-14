package net.codejava.javaee.brand;
import javax.persistence.*;
 
@Entity
@Table(name = "SA_ANALYTICS.spt.user_authentication")
@NamedQueries({
    @NamedQuery(name = "UserAuthToken.findBySelector",
            query = "SELECT u FROM UserAuthentication c WHERE c.selector = :selector")
})
public class UserAuthentication implements java.io.Serializable {
    private String id;
    private String selector;
    private String validator;
    private UserSetting UserSetting;
 
    public UserAuthentication() {
    }
 
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getId() {
        return id;
    }
 
    public UserSetting getUserSetting() {
		return UserSetting;
	}


	


	public void setId(String id) {
		this.id = id;
	}


	public String getSelector() {
		return selector;
	}


	public void setSelector(String selector) {
		this.selector = selector;
	}


	public String getValidator() {
		return validator;
	}


	public void setValidator(String validator) {
		this.validator = validator;
	}


	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    public UserSetting UserSetting() {
        return UserSetting;
    }
     
    // other getters and setters are hidden for brevity
 
}