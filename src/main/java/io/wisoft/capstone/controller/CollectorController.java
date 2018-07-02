package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.CollectorDao;
import io.wisoft.capstone.vo.Collector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/collectors")

@Produces(MediaType.APPLICATION_JSON)
public class CollectorController extends ResponseCommand {

  //TODO 싱글톤
  private static CollectorDao collectorDao = new CollectorDao();
  private static Gson gson = new Gson();

  @GET
  public Response getCollectors() {
    List<Collector> collectors = collectorDao.selectList();
    String result = gson.toJson(collectors);

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @GET
  @Path("{licensePlate}")
  public Response getCollector(final @PathParam("licensePlate")  String licensePlate) {
    System.out.println(licensePlate);

    List<Collector> collectors = collectorDao.selectCollectors(licensePlate);
    String result = gson.toJson(collectors);

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertCollector(final Collector collector) {
    try {
      System.out.println(collector.toString());
      System.out.println(collectorDao.insert(collector) + " 건의 사항이 처리되었습니다.");
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.FORBIDDEN).entity(getInternalServerError()).build();
    }

    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{licensePlate}")
  public Response deleteCollector(final @PathParam("licensePlate") String licensePlate) {
    System.out.println(collectorDao.delete(licensePlate));

    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
