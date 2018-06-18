package io.wisoft.capstone.error;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotImplementedMapper extends ErrorCommands implements ExceptionMapper<NotImplementedException> {

  @Override
  public Response toResponse(NotImplementedException exception) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(NOT_IMPLEMENTED))
        .build();
  }
}
