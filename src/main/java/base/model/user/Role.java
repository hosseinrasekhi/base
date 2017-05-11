package base.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role {
	
	@Id 
	@GeneratedValue
	@Column(name = "ROLE_ID")
	private int roleId;
	
	@Column(name = "ROLE")
	private String role;
	
	@ManyToMany(mappedBy="roles")
	private Set<User> users;
	
	@ManyToMany
	private Set<Feature> features;
	
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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


}
