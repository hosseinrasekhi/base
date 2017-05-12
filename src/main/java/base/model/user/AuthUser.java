package base.model.user;

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
	
	public int getAuthUserId() {
		return authUserId;
	}

	public void setAuthUserId(int authUserId) {
		this.authUserId = authUserId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
