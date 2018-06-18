package io.wisoft.capstone.controller;

import io.wisoft.capstone.vo.Sensor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sensors")
public class SensingController extends ResponseCommand{

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response normally(final Sensor sensor) {
    System.out.println(sensor.toString());
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
