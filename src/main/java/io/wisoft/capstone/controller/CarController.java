package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.CarDao;
import io.wisoft.capstone.vo.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
public class CarController extends ResponseCommand {
  private Logger logger = LoggerFactory.getLogger(CarController.class);

  private static CarDao carDao = new CarDao();
  private static Gson gson = new Gson();

  @GET
  public Response getCars() {
    List<Car> cars = carDao.selectList();
    logger.info("GET request to cars/ controller");

    if(cars.isEmpty()) {
      logger.warn("The registered car information does not exist.");
      return Response.status(Response.Status.FORBIDDEN).entity(getNoContent()).build();
    }
    String result = gson.toJson(cars);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @GET
  @Path("{id}")
  public Response getCar(final @PathParam("id") String id) {
    logger.info("GET request to cars/{} controller", id);
    List<Car> cars = carDao.selectCars(id);

    if(cars.isEmpty()) {
      logger.warn("The registered car information does not exist.");
      return Response.status(Response.Status.FORBIDDEN).entity(getNoContent()).build();
    }
    String result = gson.toJson(cars);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerCar(final Car car) {
    try {
      logger.info(car.toString());
      logger.info("{} 건의 사항이 처리되었습니다.", carDao.insert(car));
    } catch (final Exception e) {
      logger.error("Error : ",  e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteCar(final @PathParam("id") String id) {
    try {
      logger.info("{} 건의 사항이 처리되었습니다.", carDao.delete(id));
    } catch (final Exception e) {
      logger.error("Error : " , e);
      return Response.status(Response.Status.FORBIDDEN).entity(getForbbind()).build();
    }

    return Response.status(Response.Status.NO_CONTENT).entity(getOK()).build();
  }
}
