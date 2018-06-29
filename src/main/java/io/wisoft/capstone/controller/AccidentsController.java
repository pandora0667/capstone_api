package io.wisoft.capstone.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accidents")
@Produces(MediaType.APPLICATION_JSON)

public class AccidentsController extends ResponseCommand {

  @GET
  @Path("{licensePlate}")
  public Response getAccident() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertAccident() {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
