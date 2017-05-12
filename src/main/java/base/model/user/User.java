package base.model.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {
	@Id 
	@GeneratedValue
	@Column(name = "USER_ID")
	private int userId;
	

	@ManyToOne (cascade = CascadeType.ALL)
	private AuthUser authUser;
	
	
	@Column(name = "ENABLE")
	private boolean enable;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;

	public int getUserId() {
		return userId;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public AuthUser getAuthUser() {
		return authUser;
	}
	
	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}
}
