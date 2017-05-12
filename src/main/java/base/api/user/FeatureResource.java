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
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public FeatureFullDTO get(@PathParam("id") int featureId) {
    	return DtoUtils.entityToDto(featureDAO.getById(featureId), FeatureFullDTO.class);
    }
 
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public FeatureFullDTO update(@PathParam("id") int featureId,FeatureFullDTO dto) {
    	dto.setId(featureId);
    	return DtoUtils.entityToDto(featureDAO.update(DtoUtils.dtoToEntity(dto, Feature.class)), FeatureFullDTO.class);
    }
 
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public FeatureFullDTO delete(@PathParam("id") int featureId) {
    	return DtoUtils.entityToDto(featureDAO.delete(featureId), FeatureFullDTO.class);
    }
 
    @GET
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public List<FeatureFullDTO> list() {
    	return DtoUtils.entitysToDtoList(featureDAO.list(), FeatureFullDTO.class);
    }
}
