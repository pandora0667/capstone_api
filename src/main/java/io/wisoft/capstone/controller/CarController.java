package io.wisoft.capstone.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarController extends ResponseCommand {

  @GET
  public Response getCars() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{id}")
  public Response getCar(final @PathParam("id") String id) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerCar() {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteCar() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
