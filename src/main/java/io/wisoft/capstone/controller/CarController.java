package io.wisoft.capstone.controller;

import io.wisoft.capstone.dao.CarDao;
import io.wisoft.capstone.vo.Car;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarController extends ResponseCommand {
  private static CarDao carDao = new CarDao();

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
  public Response registerCar(final Car car) {
    try {
      System.out.println(car.toString());
      int count = carDao.insert(car);
      System.out.println(count);
    } catch (Exception e) {
      e.printStackTrace();
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteCar() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
