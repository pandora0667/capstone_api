package io.wisoft.capstone.controller;

import io.wisoft.capstone.dao.CustomerDao;
import io.wisoft.capstone.vo.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController extends ResponseCommand{
  private static CustomerDao customerDao = new CustomerDao();

  @GET
  public Response getAllCustomers() {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCustomerInformation(@PathParam("id") final String id) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerCustomer(final Customer customer) {
    try {
      System.out.println(customer.toString());
      int count = customerDao.insert(customer);
      System.out.println(count);
    } catch (Exception e) {
      System.out.println("Error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @PUT
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modifyCustomer(final @PathParam("id") String id) {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteCustomer(final @PathParam("id") String id) {
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
