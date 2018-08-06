package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.CustomerDao;
import io.wisoft.capstone.encryption.Security;
import io.wisoft.capstone.vo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController extends ResponseCommand {
  private Logger logger = LoggerFactory.getLogger(CustomerController.class);

  private static CustomerDao customerDao = new CustomerDao();
  private static Gson gson = new Gson();
  private Security security = new Security();

  @GET
  public Response getCustomers() {
    List<Customer> customers = customerDao.selectList();
    logger.info("GET request to customers/ controller");

    if(customers.isEmpty()) {
      logger.warn("customers No results found.");
      return Response.status(Response.Status.OK).entity(getNoContent()).build();
    }

    String result = gson.toJson(customers);
    return Response.status(Response.Status.OK).entity(result).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCustomer(@PathParam("id") final String id) {
    logger.info("GET request to customers/{} controller", id);
    Customer customer = customerDao.selectOne(id);
    String result = gson.toJson(customer);

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerCustomer(final Customer customer) {

    try {
      logger.info(customer.toString());
      customer.setPassword(security.sha256(customer.getPassword()));
      logger.info("{} 건의 사항이 처리되었습니다.", customerDao.insert(customer));
    } catch (final Exception e) {
      logger.error("Error : ",  e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @PUT
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modifyCustomer(final @PathParam("id") String id, final Customer customer) {

    try {
      logger.info(customer.toString());
      customer.setPassword(security.sha256(customer.getPassword()));
      logger.info("{} 건의 사항이 처리되었습니다.", customerDao.update(customer));
    } catch (final Exception e) {
      logger.error("Error : " , e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteCustomer(final @PathParam("id") String id) {
    try {
      logger.info("{} 건의 사항이 처리되었습니다.", customerDao.delete(id));
    } catch (final Exception e) {
      logger.error("Error : ", e);
      return Response.status(Response.Status.FORBIDDEN).entity(getForbbind()).build();
    }

    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
