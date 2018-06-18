package io.wisoft.capstone.controller;

import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class Hello {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response responseHello() {
    JSONObject serverStatus = new JSONObject();
    Response response;

    try {
      serverStatus.put("result", "ok");
      response = Response.status(Response.Status.OK).entity(serverStatus.toString()).build();
    } catch (NullPointerException e) {
      response = Response.status(Response.Status.NO_CONTENT).build();
      System.out.println("server json passing error");
    }

    return response;
  }
}
