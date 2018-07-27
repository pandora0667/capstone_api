package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.CollectorDao;
import io.wisoft.capstone.vo.Collector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/collectors")

@Produces(MediaType.APPLICATION_JSON)
public class CollectorController extends ResponseCommand {
  private static Logger logger = LoggerFactory.getLogger(CollectorController.class);

  private static CollectorDao collectorDao = new CollectorDao();
  private static Gson gson = new Gson();

  @GET
  public Response getCollectors() {
    List<Collector> collectors = collectorDao.selectList();
    logger.info("Access to collectors/ controller");

    if (collectors.isEmpty()) {
      logger.warn("There is no information about the registered collector.");
      return Response.status(Response.Status.OK).entity(getNoContent()).build();
    }
    String result = gson.toJson(collectors);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @GET
  @Path("{serial}")
  public Response getCollector(final @PathParam("serial")  String serial) {
    List<Collector> collectors = collectorDao.selectCollectors(serial);
    logger.info("Access to collectors/{serial} controller");

    if (collectors.isEmpty()) {
      logger.warn("There is no collector for the serial you viewed.");
      return Response.status(Response.Status.OK).entity(getNoContent()).build();
    }
    String result = gson.toJson(collectors);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertCollector(final Collector collector) {
    try {
      logger.info(collector.toString());
      logger.info("{} 건의 사항이 처리되었습니다.", collectorDao.insert(collector));
    } catch (final Exception e) {
      logger.error("error : ",  e);
      return Response.status(Response.Status.FORBIDDEN).entity(getInternalServerError()).build();
    }

    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @PUT
  @Path("{serial}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response updateCollector(final @PathParam("serial") String serial, final Collector collector) {

    try {
      logger.info(collector.toString());
      logger.info("{} 건의 사항이 처리되었습니다.", collectorDao.update(collector));
    } catch (final Exception e) {
      logger.error("error : ",  e);
      return Response.status(Response.Status.FORBIDDEN).entity(getInternalServerError()).build();
    }
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @DELETE
  @Path("{serial}")
  public Response deleteCollector(final @PathParam("serial") String serial) {
    try {
      logger.info("{} 건의 사항이 처리되었습니다.",  collectorDao.delete(serial));
    } catch (final Exception e) {
      logger.error("Error : ", e);
      return Response.status(Response.Status.FORBIDDEN).entity(getForbbind()).build();
    }

    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
