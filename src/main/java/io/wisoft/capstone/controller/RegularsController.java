package io.wisoft.capstone.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/regulars")
@Produces(MediaType.APPLICATION_JSON)

public class RegularsController extends ResponseCommand {

  @GET
  @Path("{licensePlate}")
  public Response getRegular() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertRegular() {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
