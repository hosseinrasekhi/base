package base.api.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import base.model.user.User;

public class UserFullDTO {
	
	private int userId;
	private String username;
	private String role;
	
	public void saveTo(User user){
		user.setUserId(userId);
	}
	
	public void loadFrom(User user){
		this.setUsername(user.getAuthUser().getUsername());
		this.setUserId(user.getUserId());
	}
	@JsonProperty
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@JsonProperty
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonProperty
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
