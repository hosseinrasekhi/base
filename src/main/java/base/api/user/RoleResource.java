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

import base.api.user.dto.RoleFullDTO;
import base.core.dto.DtoUtils;
import base.model.user.Role;
import base.model.user.dao.RoleDAO;

@Service
@Path("/role/items{slash: /?}")
public class RoleResource {
	
	@Autowired
    private RoleDAO roleDAO;
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RoleFullDTO add(RoleFullDTO dto) {
    	return DtoUtils.entityToDto(roleDAO.save(DtoUtils.dtoToEntity(dto, Role.class)), RoleFullDTO.class);
    }
 
    @GET
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public RoleFullDTO get(@PathParam("uid") String uid) {
    	return DtoUtils.entityToDto(roleDAO.getByUid(uid), RoleFullDTO.class);
    }
 
    @PUT
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RoleFullDTO update(@PathParam("uid") String uid,RoleFullDTO dto) {
    	dto.setUid(uid);
    	return DtoUtils.entityToDto(roleDAO.update(DtoUtils.dtoToEntity(dto, Role.class)), RoleFullDTO.class);
    }
 
    @DELETE
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public RoleFullDTO delete(@PathParam("uid") String uid) {
    	return DtoUtils.entityToDto(roleDAO.delete(uid), RoleFullDTO.class);
    }
 
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<RoleFullDTO> list() {
    	return DtoUtils.entitysToDtoList(roleDAO.list(), RoleFullDTO.class);
    }

}
