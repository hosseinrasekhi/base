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
import base.model.user.dao.AuthUserDAO;
import base.model.user.dao.UserDAO;

@Service
@Path("/user/items{slash: /?}")
public class UserResource {
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
	private AuthUserDAO authUserDAO;
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO add(UserFullDTO dto) {
    	User user = new User();
    	AuthUser authUser = new AuthUser();
    	dto.getAuthUser().saveTo(authUser);
    	dto.saveTo(user);
    	authUserDAO.save(authUser);
    	userDAO.save(user);
    	UserFullDTO userFullDTO = new UserFullDTO();
    	userFullDTO.loadFrom(user);
    	return userFullDTO;
    }
 
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO get(@PathParam("id") int userId) {
    	User user = userDAO.getById(userId);
    	UserFullDTO userFullDTO = new UserFullDTO();
    	userFullDTO.loadFrom(user);
    	return userFullDTO;
    }
 
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO update(@PathParam("id") int userId,UserFullDTO dto) {
    	User user = userDAO.getById(userId);
    	userDAO.update(user);
    	UserFullDTO userFullDTO = new UserFullDTO();
    	userFullDTO.loadFrom(user);
    	return userFullDTO;
    }
 
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public UserFullDTO delete(@PathParam("id") int userId) {
    	User user = userDAO.delete(userId);
    	UserFullDTO userFullDTO = new UserFullDTO();
    	userFullDTO.loadFrom(user);
    	return userFullDTO;
    	
    }
 
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserFullDTO> list() {
    	return DtoUtils.entitysToDtoList(userDAO.list(), UserFullDTO.class);
    }

}
