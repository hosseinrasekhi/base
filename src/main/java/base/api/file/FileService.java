package base.api.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;

import base.model.file.dao.FileDAO;


@Path("/files")
public class FileService {
  private static final String SAVE_FOLDER = "c://Users/hosse/upload/";
  @Autowired
  private FileDAO fileDao;
  
  
  @POST
  @Path("/upload")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces("text/html")
  public Response uploadFile(
      @FormDataParam("file") InputStream fileInputString,
      @FormDataParam("file") FormDataContentDisposition fileInputDetails) {
 
    String fileLocation = SAVE_FOLDER + fileInputDetails.getFileName();
    String status = null;
    NumberFormat myFormat = NumberFormat.getInstance();
    myFormat.setGroupingUsed(true);
    
    // Save the file 
    try {
     OutputStream out = new FileOutputStream(new File(fileLocation));
     byte[] buffer = new byte[1024];
     int bytes = 0;
     long file_size = 0; 
     while ((bytes = fileInputString.read(buffer)) != -1) {
      out.write(buffer, 0, bytes);
      file_size += bytes;
     }
     out.flush();  
     out.close();
            
     base.model.file.File file = new base.model.file.File();
     file.setFileName(fileInputDetails.getFileName());
     file.setData(IOUtils.toByteArray(fileInputString));
     fileDao.save(file);
     status = "File has been uploaded to:" + fileLocation 
                 + ", size: " + myFormat.format(file_size) + " bytes";
    } catch (IOException ex) {
    }

    return Response.status(200).entity(status).build();
  }
}