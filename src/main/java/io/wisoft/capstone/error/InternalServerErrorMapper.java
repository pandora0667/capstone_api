package io.wisoft.capstone.error;

import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class InternalServerErrorMapper extends ErrorCommand implements ExceptionMapper<InternalServerErrorException> {

  @Override
  public Response toResponse(final InternalServerErrorException exception) {
    System.out.println(exception.getMessage());
    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(error(INTERNAL_SERVER_ERROR))
        .build();
  }
}
