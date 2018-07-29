package io.wisoft.capstone.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BadRequestMapper extends ErrorCommand implements ExceptionMapper<BadRequestException> {
  private final Logger logger = LoggerFactory.getLogger(BadRequestMapper.class);

  @Override
  public Response toResponse(final BadRequestException exception) {
    logger.error(exception.getMessage());
    return Response.status(Response.Status.NOT_FOUND)
        .entity(error(BAD_REQUEST))
        .build();
  }
}
