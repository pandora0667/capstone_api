package io.wisoft.capstone.error;

import com.sun.xml.internal.ws.server.UnsupportedMediaException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UnsupportedMediaMapper extends ErrorCommand implements ExceptionMapper<UnsupportedMediaException> {

  @Override
  public Response toResponse(final UnsupportedMediaException exception) {
    System.out.println(exception.getMessage());
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(UNSUPPORTED_MEDIA))
        .build();
  }
}
