package base.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import base.core.dto.DTO;
import base.model.user.AuthUser;

public class AuthUserLightDTO extends DTO<AuthUser>{
	
	private String uid;
	private String username;
	
	@JsonProperty
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
		this.setUid(obj.getUid());
		this.setUsername(obj.getUsername());
	}
	@Override
	public void saveTo(AuthUser obj) {
		obj.setUid(uid);
		obj.setUsername(username);
	}
}
