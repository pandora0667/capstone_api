package io.wisoft.capstone.error;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper extends ErrorCommand implements ExceptionMapper<NotFoundException> {

  @Override
  public Response toResponse(final NotFoundException exception) {
    System.out.println(exception.getMessage());
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(NOT_FOUND))
        .build();
  }
}
