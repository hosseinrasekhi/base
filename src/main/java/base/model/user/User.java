package base.model.user;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User extends base.core.entity.Entity{
	private static final String UID = "UID";

	public static final String ID = "ID";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = UID, nullable = false, unique = true)
	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private AuthUser authUser;

	@Column(name = "ENABLE")
	private boolean enable;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
