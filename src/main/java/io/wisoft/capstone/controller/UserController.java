package io.wisoft.capstone.controller;

import io.wisoft.capstone.vo.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllUser() {
    System.out.println("getAllUser called~~~~~~");
    return Response.status(Response.Status.OK).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserInformation(final @PathParam("id") String id) {
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  @GET
  @Path("{id}/devices")
  @Produces(MediaType.APPLICATION_JSON)
  public Response insertUserInformation(final @PathParam("id") String id) {
    return Response.status(Response.Status.OK).build();
  }

  @GET
  @Path("{id}/devices/{deviceID}/sensors")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserSensor(final @PathParam("id") String id, final @PathParam("deviceID") String deviceID) {
    return Response.status(Response.Status.OK).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerUser(final User user) {
    System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    System.out.println(user.toString());
    System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    return Response.status(Response.Status.OK).build();
  }

  @POST
  @Path("{id}/{deviceID}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertDeviceUser(final @PathParam("id") String id, final @PathParam("deviceID") String deviceID) {
    return Response.status(Response.Status.OK).build();
  }

  @PUT
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modifyUser(final @PathParam("id") String id) {
    return Response.status(Response.Status.OK).build();
  }

  @PUT
  @Path("{id}/{deviceID}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modifyDevice(final @PathParam("id") String id, final @PathParam("deviceID") String deviceID) {
    System.out.println(id);
    System.out.println(deviceID);
    return Response.status(Response.Status.OK).build();
  }

  @DELETE
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response deleteUserInformation(final @PathParam("id") String id) {
    return Response.status(Response.Status.OK).build();
  }
}
