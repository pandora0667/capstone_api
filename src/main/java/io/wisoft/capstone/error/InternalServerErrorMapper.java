package io.wisoft.capstone.error;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalServerErrorMapper extends ErrorCommands implements ExceptionMapper<InternalServerErrorException> {

  @Override
  public Response toResponse(InternalServerErrorException exception) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(INTERNAL_SERVER_ERROR))
        .build();
  }
}
