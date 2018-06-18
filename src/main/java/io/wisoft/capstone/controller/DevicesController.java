package io.wisoft.capstone.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
public class DevicesController extends ResponseCommand{

  @GET
  public Response getAllDevices() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{deviceID}")
  public Response getDevicesID(@PathParam("deviceID") final String deviceID) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertDeviceID() {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{deviceID}")
  public Response deleteDeviceID() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
