package base.model.auth_user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTH_USER")
public class AuthUser {
	@Id 
	@GeneratedValue
	@Column(name = "AUTH_USER_ID")
	private int authUserId;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Column(name = "PASSWORD")
	private String password;
	
	
	

}
