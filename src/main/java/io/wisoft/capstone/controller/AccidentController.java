package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.AccidentDao;
import io.wisoft.capstone.vo.Accident;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

// 임베디드 제티 변경
// 데이터 수집기에 따른 데이터베이스 변경
// 스네이크 표기법 카멜 표기법 변경

@Path("/accidents")
@Produces(MediaType.APPLICATION_JSON)

public class AccidentController extends ResponseCommand {
  private Logger logger =  LoggerFactory.getLogger(AccidentController.class);

  private static AccidentDao accidentDao = new AccidentDao();
  private static Gson gson = new Gson();

  @GET
  @Path("{serial}")
  public Response getAccidents(final @PathParam("serial") String serial) {
    List<Accident> accidents = accidentDao.selectList(serial);
    logger.info("GET request to accidents/{} controller", serial);

    if(accidents.isEmpty()) {
      logger.warn("accidents No information is available.");
      return Response.status(Response.Status.OK).entity(getNoContent()).build();
    }

    String result = gson.toJson(accidents);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertAccident(final Accident accident) {
    try {
      logger.info(accident.toString());
      logger.info("{} 건의 사항이 처리되었습니다.", accidentDao.insert(accident));
    } catch (final Exception e) {
      logger.error("Error : ", e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{serial}")
  public Response deleteAccident(final @PathParam("serial") String serial) {
    try {
      logger.info("{} 건의 사항이 처리되었습니다.", accidentDao.delete(serial));
    } catch (final Exception e) {
      logger.error("Error : ", e);
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }
}
