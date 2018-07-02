package io.wisoft.capstone.controller;

import io.wisoft.capstone.dao.AccidentDao;
import io.wisoft.capstone.vo.Accident;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accidents")
@Produces(MediaType.APPLICATION_JSON)

public class AccidentsController extends ResponseCommand {

  private static AccidentDao accidentDao = new AccidentDao();

  @GET
  @Path("{licensePlate}")
  public Response getAccident() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertAccident(final Accident accident) {

    try {
      System.out.println(accident.toString());
      int count = accidentDao.insert(accident);
      System.out.println(count);

    } catch (Exception e) {
      System.out.println(e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
