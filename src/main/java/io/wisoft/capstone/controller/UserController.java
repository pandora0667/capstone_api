package io.wisoft.capstone.controller;

import io.wisoft.capstone.vo.Car;
import io.wisoft.capstone.vo.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserController extends ResponseCommand{

  @GET
  public Response getAllUser() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserInformation(@PathParam("id") final String id) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{id}/devices")
  public Response insertUserInformation(@PathParam("id") final String id) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{id}/devices/{deviceID}/sensors")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUserSensor(final @PathParam("id") String id, final @PathParam("deviceID") String deviceID) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerUser(final User user) {
    System.out.println(user.toString());
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @POST
  @Path("{id}/cars")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerCar(final Car car, final @PathParam("id") String id) {
    System.out.println(car.toString());
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @POST
  @Path("{id}/{deviceID}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertDeviceUser(final @PathParam("id") String id, final @PathParam("deviceID") String deviceID) {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @PUT
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modifyUser(final @PathParam("id") String id) {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @PUT
  @Path("{id}/{deviceID}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modifyDevice(final @PathParam("id") String id, final @PathParam("deviceID") String deviceID) {
    System.out.println(id);
    System.out.println(deviceID);
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteUserInformation(final @PathParam("id") String id) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
