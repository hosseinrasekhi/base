package base.api.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import base.core.dto.DTO;
import base.core.dto.DtoUtils;
import base.model.user.Feature;
import base.model.user.Role;

public class RoleFullDTO extends DTO<Role>{
	
	private int id;
	private String role;
	private List<FeatureFullDTO> features;
	
	@JsonProperty
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@JsonProperty
	public List<FeatureFullDTO> getFeatures() {
		return features;
	}
	public void setFeatures(List<FeatureFullDTO> features) {
		this.features = features;
	}
	@Override
	public void loadFrom(Role obj) {
		this.setId(obj.getId());
		this.setRole(obj.getRole());
		this.setFeatures(DtoUtils.entitysToDtoList(obj.getFeatures(), FeatureFullDTO.class));
		
	}
	@Override
	public void saveTo(Role obj) {
		obj.setId(id);
		obj.setRole(role);
		obj.setFeatures(DtoUtils.dtoListToEntitySet(features, Feature.class));
	}
}
