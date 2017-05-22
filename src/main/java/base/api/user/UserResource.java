package base.api.user;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.api.user.dto.UserFullDTO;
import base.core.dto.DtoUtils;
import base.model.user.AuthUser;
import base.model.user.User;
import base.model.user.dao.UserDAO;

@Service
@Path("/user/items{slash: /?}")
public class UserResource {
	
	@Autowired
    private UserDAO userDAO;
	
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO add(UserFullDTO dto) {
    	AuthUser authUser = DtoUtils.dtoToEntity(dto.getAuthUser(), AuthUser.class);
    	User user = DtoUtils.dtoToEntity(dto, User.class);
    	user.setAuthUser(authUser);
		return DtoUtils.entityToDto(userDAO.save(user), UserFullDTO.class);
    }
 
    @GET
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO get(@PathParam("uid") String uid) {
    	return DtoUtils.entityToDto(userDAO.getByUid(uid), UserFullDTO.class);
    }
 
    @PUT
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO update(@PathParam("uid") String uid,UserFullDTO dto) {
    	dto.setUid(uid);
    	return DtoUtils.entityToDto(userDAO.update(DtoUtils.dtoToEntity(dto, User.class)), UserFullDTO.class);
    }
 
    @DELETE
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO delete(@PathParam("uid") String uid) {
    	return DtoUtils.entityToDto(userDAO.delete(uid), UserFullDTO.class);
    }
 
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserFullDTO> list() {
    	return DtoUtils.entitysToDtoList(userDAO.list(), UserFullDTO.class);
    }

}
