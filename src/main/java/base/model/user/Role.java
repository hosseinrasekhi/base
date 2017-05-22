package base.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = Role.ROLE)
public class Role extends base.core.entity.Entity{
	
	public static final String ROLE = "ROLE";

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
	

	@Column(name = ROLE)
	private String role;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Feature> features;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Feature> getFeatures() {
		return features;
	}
	
	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

}
