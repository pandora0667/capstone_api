package io.wisoft.capstone.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class HelloController extends ResponseCommand {

  @GET
  public Response responseHello() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

}
