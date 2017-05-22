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

import base.api.user.dto.FeatureFullDTO;
import base.core.dto.DtoUtils;
import base.model.user.Feature;
import base.model.user.dao.FeatureDAO;

@Service
@Path("/feature/items{slash: /?}")
public class FeatureResource {
	
	@Autowired
    private FeatureDAO featureDAO;
 
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public FeatureFullDTO add(FeatureFullDTO dto) {
    	return DtoUtils.entityToDto(featureDAO.save(DtoUtils.dtoToEntity(dto, Feature.class)), FeatureFullDTO.class);
    }
 
    @GET
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public FeatureFullDTO get(@PathParam("uid") String uid) {
    	return DtoUtils.entityToDto(featureDAO.getByUid(uid), FeatureFullDTO.class);
    }
 
    @PUT
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public FeatureFullDTO update(@PathParam("uid") String uid,FeatureFullDTO dto) {
    	dto.setUid(uid);
    	return DtoUtils.entityToDto(featureDAO.update(DtoUtils.dtoToEntity(dto, Feature.class)), FeatureFullDTO.class);
    }
 
    @DELETE
    @Path("{uid}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public FeatureFullDTO delete(@PathParam("uid") String uid) {
    	return DtoUtils.entityToDto(featureDAO.delete(uid), FeatureFullDTO.class);
    }
 
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<FeatureFullDTO> list() {
    	return DtoUtils.entitysToDtoList(featureDAO.list(), FeatureFullDTO.class);
    }
}
