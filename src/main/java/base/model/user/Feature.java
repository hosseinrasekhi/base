package base.model.user;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "FEATURE")
public class Feature {
	
	@Id 
	@GeneratedValue
	@Column(name = "FEATURE_ID")
	private int featureId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@ManyToMany(mappedBy = "features")
	private Set<Role> roles;
}
