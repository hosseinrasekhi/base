package base.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import base.core.dto.DTO;
import base.model.user.Feature;

public class FeatureFullDTO extends DTO<Feature>{
	
	private String uid;
	private String description;
	private String name;
	@JsonProperty
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	@JsonProperty
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonProperty
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void loadFrom(Feature obj) {
		this.setDescription(obj.getDescription());
		this.setName(obj.getName());
		this.setUid(obj.getUid());
	}
	@Override
	public void saveTo(Feature obj) {
		obj.setUid(uid);
		obj.setName(name);
		obj.setDescription(description);
	}

}
