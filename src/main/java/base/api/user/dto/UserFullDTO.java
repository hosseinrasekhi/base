package base.api.user.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import base.core.dto.DTO;
import base.core.dto.DtoUtils;
import base.model.user.AuthUser;
import base.model.user.Role;
import base.model.user.User;

public class UserFullDTO extends DTO<User>{
	
	private String uid;
	private boolean enable;
	private AuthUserLightDTO authUser;
	private List<RoleFullDTO> roles;
	
	public void saveTo(User user){
		user.setUid(uid);
		user.setEnable(enable);
		user.setAuthUser(DtoUtils.dtoToEntity(authUser, AuthUser.class));
		user.setRoles(DtoUtils.dtoListToEntitySet(roles, Role.class));
		
	}
	
	public void loadFrom(User user){
		this.setUid(user.getUid());
		this.setEnable(user.isEnable());
		this.setRoles(DtoUtils.entitysToDtoList(user.getRoles(), RoleFullDTO.class));
		this.setAuthUser(DtoUtils.entityToDto(user.getAuthUser(), AuthUserLightDTO.class));
	}

	@JsonProperty
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public AuthUserLightDTO getAuthUser() {
		return authUser;
	}

	public void setAuthUser(AuthUserLightDTO authUser) {
		this.authUser = authUser;
	}

	public List<RoleFullDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleFullDTO> roles) {
		this.roles = roles;
	}
}
