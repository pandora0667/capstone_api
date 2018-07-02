package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.CarDao;
import io.wisoft.capstone.vo.Car;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarController extends ResponseCommand {
  private static CarDao carDao = new CarDao();
  private static Gson gson = new Gson();

  @GET
  public Response getCars() {
    List<Car> cars = carDao.selectList();
    String result = gson.toJson(cars);

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @GET
  @Path("{id}")
  public Response getCar(final @PathParam("id") String id) {
    List<Car> cars = carDao.selectCars(id);
    String result = gson.toJson(cars);

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerCar(final Car car) {
    try {
      System.out.println(car.toString());
      System.out.println(carDao.insert(car) + " 건의 사항이 처리되었습니다.");
    } catch (Exception e) {
      System.out.println("Error : " + e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteCar(final @PathParam("id") String id) {
    System.out.println(carDao.delete(id) + " 건의 사항이 처리되었습니다.");

    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
