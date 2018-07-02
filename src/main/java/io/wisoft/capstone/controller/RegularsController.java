package io.wisoft.capstone.controller;

import io.wisoft.capstone.dao.RegularDao;
import io.wisoft.capstone.vo.Regular;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/regulars")
@Produces(MediaType.APPLICATION_JSON)

public class RegularsController extends ResponseCommand {

  private static RegularDao regularDao = new RegularDao();

  @GET
  @Path("{licensePlate}")
  public Response getRegular() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertRegular(final Regular regular) {

    try {
      System.out.println(regular.toString());
      int count = regularDao.insert(regular);
      System.out.println(count);

    } catch (Exception e) {
      System.out.println(e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
