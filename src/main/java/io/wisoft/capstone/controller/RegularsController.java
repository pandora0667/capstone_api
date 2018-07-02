package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.RegularDao;
import io.wisoft.capstone.vo.Regular;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/regulars")
@Produces(MediaType.APPLICATION_JSON)

public class RegularsController extends ResponseCommand {

  private static RegularDao regularDao = new RegularDao();
  private static Gson gson = new Gson();

  @GET
  @Path("{serial}")
  public Response getRegulars(final @PathParam("serial") String serial) {
    List<Regular> regulars = regularDao.selectList(serial);
    String result = gson.toJson(regulars);

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertRegular(final Regular regular) {
    try {
      System.out.println(regular.toString());
      System.out.println(regularDao.insert(regular) + " 건의 사항이 처리되었습니다.");

    } catch (Exception e) {
      System.out.println("Error : " + e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }

    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{serial}")
  public Response deleteRegular(final @PathParam("serial") String serial) {
    try {
      System.out.println(regularDao.delete(serial) + " 건의 사항이 처리되었습니다.");
    } catch (Exception ignore) {}
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
