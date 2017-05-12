package base.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import base.core.dto.DTO;
import base.model.user.AuthUser;

public class AuthUserLightDTO extends DTO<AuthUser>{
	
	private int id;
	private String username;
	
	@JsonProperty
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public void loadFrom(AuthUser obj) {
		this.setId(obj.getAuthUserId());
		this.setUsername(obj.getUsername());
	}
	@Override
	public void saveTo(AuthUser obj) {
		obj.setAuthUserId(id);
		obj.setUsername(username);
	}
}
