package io.wisoft.capstone.controller;

import io.wisoft.capstone.vo.Sensor;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/accidents")
@Produces(MediaType.APPLICATION_JSON)
public class AccidentsController extends ResponseCommand {

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response accidents(final Sensor sensor) {
    System.out.println(sensor.toString());
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
