package base.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTH_USER")
public class AuthUser extends base.core.entity.Entity{
	public static final String PASSWORD = "PASSWORD";

	public static final String USERNAME = "USERNAME";

	public static final String UID = "UID";

	public static final String ID = "ID";

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = ID)
	private int id;
	
	@Column(name = UID, nullable = false, unique = true)
	private String uid;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = USERNAME)
	private String username;
	
	@Column(name = PASSWORD)
	private String password;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
