package io.wisoft.capstone.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotAllowedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MethodNotAllowedMapper extends ErrorCommand implements ExceptionMapper<NotAllowedException> {
  private final Logger logger = LoggerFactory.getLogger(MethodNotAllowedMapper.class);

  @Override
  public Response toResponse(final NotAllowedException exception) {
    logger.error(exception.getMessage());
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(METHOD_NOT_ALLOWED))
        .build();
  }
}
