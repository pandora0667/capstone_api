package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.RegularDao;
import io.wisoft.capstone.vo.Regular;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/regulars")
@Produces(MediaType.APPLICATION_JSON)
public class RegularController extends ResponseCommand {
  private Logger logger = LoggerFactory.getLogger(RegularController.class);

  private static RegularDao regularDao = new RegularDao();
  private static Gson gson = new Gson();

  @GET
  @Path("{serial}")
  public Response getRegularsByCollectorSerial(final @PathParam("serial") String serial) {
    List<Regular> regulars = regularDao.selectList(serial);
    logger.info("GET request to regulars/{} controller", serial);

    if(regulars.isEmpty()) {
      logger.warn("There is no regular information in the serial information you viewed.");
      return Response.status(Response.Status.NO_CONTENT).entity(getNoContent()).build();
    }

    String result = gson.toJson(regulars);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertRegular(final Regular regular) {
    try {
      logger.info(regular.toString());
      logger.info("{} 건의 사항이 처리되었습니다.", regularDao.insert(regular));
    } catch (final Exception e) {
      logger.error("Error : ", e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }

    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{serial}")
  public Response deleteRegularByCollectorSerial(final @PathParam("serial") String serial) {
    try {
      logger.info("{} 건의 사항이 처리되었습니다.", regularDao.delete(serial));
    } catch (final Exception e) {
      logger.error("Error : ", e);
      return Response.status(Response.Status.FORBIDDEN).entity(getForbbind()).build();
    }

    return Response.status(Response.Status.NO_CONTENT).entity(getOK()).build();
  }
}
