package io.wisoft.capstone.error;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotImplementedMapper extends ErrorCommand implements ExceptionMapper<NotImplementedException> {

  @Override
  public Response toResponse(final NotImplementedException exception) {
    System.out.println(exception.getMessage());
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(NOT_IMPLEMENTED))
        .build();
  }
}
