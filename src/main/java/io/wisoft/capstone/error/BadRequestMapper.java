package io.wisoft.capstone.error;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestMapper extends ErrorCommand implements ExceptionMapper<BadRequestException> {

  @Override
  public Response toResponse(BadRequestException exception) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(BAD_REQUEST))
        .build();
  }
}
