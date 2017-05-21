package base.api.file;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import base.model.file.File;
import base.model.file.dao.FileDAO;

@Path("/files")
public class FileService {
	@Autowired
	private FileDAO fileDao;

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces("text/html")
	public Response uploadFile(@FormDataParam("file") InputStream fileInputString,
			@FormDataParam("file") FormDataContentDisposition fileInputDetails) {

		String status = null;
		NumberFormat myFormat = NumberFormat.getInstance();
		myFormat.setGroupingUsed(true);

		// Save the file
		File file = new File();
		try {
			file.setFileName(fileInputDetails.getFileName());
			file.setData(IOUtils.toByteArray(fileInputString));
			fileDao.save(file);
		} catch (IOException e) {
			return Response.serverError().build();
		}
		status = "file has been uploaded with id: " + file.getId();
		return Response.status(200).entity(status).build();
	}

	@GET
	@Path("/download/{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadFile(@PathParam("id") long id) {
		final File file = fileDao.get(id);
		StreamingOutput fileStream = new StreamingOutput() {
			@Override
			public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
				output.write(file.getData());
				output.flush();
			}
		};
		return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition", "attachment; filename = " + file.getFileName()).build();
	}
}