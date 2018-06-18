package io.wisoft.capstone.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class Hello extends ResponseCommand{

  @GET
  public Response responseHello() {
    Response response;
    response = Response.status(Response.Status.OK).entity(getOK()).build();

    return response;
  }
}
