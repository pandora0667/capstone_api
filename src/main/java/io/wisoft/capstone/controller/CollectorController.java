package io.wisoft.capstone.controller;

import io.wisoft.capstone.dao.CollectorDao;
import io.wisoft.capstone.vo.Collector;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/collectors")

@Produces(MediaType.APPLICATION_JSON)
public class CollectorController extends ResponseCommand{

  //TODO 싱글톤
  private static CollectorDao CollectorDao = new CollectorDao();

  @GET
  public Response getCollectors() {
    try {
      List<Collector> collectors = CollectorDao.selectAll();

      for (Collector collector : collectors) {
        System.out.println(collector.getSerial());
      }
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{licensePlate}")
  public Response getCollector(final @PathParam("licensePlate")  String licensePlate) {
    try {
      List<Collector> collectors = CollectorDao.select(licensePlate);
      for (Collector collector : collectors) {
        System.out.println(collector);
      }
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertCollector(final Collector collector) {
    try {
      System.out.println(collector.toString());
      System.out.println(CollectorDao.insert(collector));
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }

    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{licensePlate}")
  public Response deleteCollector(final @PathParam("licensePlate") String licensePlate) {
    try {
      System.out.println(CollectorDao.delete(licensePlate));
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }

    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
