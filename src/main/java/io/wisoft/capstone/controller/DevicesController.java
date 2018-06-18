package io.wisoft.capstone.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/devices")
public class DevicesController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllDevices() {
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  @GET
  @Path("{deviceID}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getDevicesID(final @PathParam("deviceID") String deviceID) {
    return Response.status(Response.Status.OK).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertDeviceID() {
    return Response.status(Response.Status.OK).build();
  }

  @DELETE
  @Path("{deviceID}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteDeviceID() {
    return Response.status(Response.Status.NO_CONTENT).build();
  }
}
