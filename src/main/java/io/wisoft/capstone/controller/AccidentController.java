package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.AccidentDao;
import io.wisoft.capstone.vo.Accident;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/accidents")
@Produces(MediaType.APPLICATION_JSON)

public class AccidentController extends ResponseCommand {

  private static AccidentDao accidentDao = new AccidentDao();
  private static Gson gson = new Gson();

  @GET
  @Path("{serial}")
  public Response getAccidents(final @PathParam("serial") String serial) {
    List<Accident> accidents = accidentDao.selectList(serial);
    String result = gson.toJson(accidents);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertAccident(final Accident accident) {
    try {
      System.out.println(accident.toString());
      System.out.println(accidentDao.insert(accident) + " 건의 사항이 처리되었습니다.");

    } catch (Exception e) {
      System.out.println("Error : " + e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{serial}")
  public Response deleteAccident(final @PathParam("serial") String serial) {
    try {
      System.out.println(accidentDao.delete(serial) + " 건의 사항이 처리되었습니다.");
    } catch (Exception ignore) {}
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
