package io.wisoft.capstone.error;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MethodNotAllowedMapper extends ErrorCommand implements ExceptionMapper<NotAllowedException> {

  @Override
  public Response toResponse(final NotAllowedException exception) {
    System.out.println(exception.getMessage());
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(METHOD_NOT_ALLOWED))
        .build();
  }
}
