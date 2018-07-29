package io.wisoft.capstone.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper extends ErrorCommand implements ExceptionMapper<NotFoundException> {
  private final Logger logger = LoggerFactory.getLogger(NotFoundExceptionMapper.class);

  @Override
  public Response toResponse(final NotFoundException exception) {
    logger.error(exception.getMessage());
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(NOT_FOUND))
        .build();
  }
}
