package base.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import base.core.dto.DTO;
import base.model.user.Feature;

public class FeatureFullDTO extends DTO<Feature>{
	
	private int id;
	private String description;
	private String name;
	@JsonProperty
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		this.setId(obj.getFeatureId());
	}
	@Override
	public void saveTo(Feature obj) {
		obj.setFeatureId(id);
		obj.setName(name);
		obj.setDescription(description);
	}

}
