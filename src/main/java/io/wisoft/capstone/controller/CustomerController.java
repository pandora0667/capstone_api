package io.wisoft.capstone.controller;

import com.google.gson.Gson;
import io.wisoft.capstone.dao.CustomerDao;
import io.wisoft.capstone.vo.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController extends ResponseCommand {
  private static CustomerDao customerDao = new CustomerDao();
  private static Gson gson = new Gson();

  @GET
  public Response getCustomers() {
    List<Customer> customers = customerDao.selectList();
    String result = gson.toJson(customers);

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getCustomer(@PathParam("id") final String id) {
    Customer customer = customerDao.selectOne(id);
    String result = gson.toJson(new Customer(customer.getId(), customer.getName(), customer.getEmail(),
        customer.getPhone(), customer.getPassword()));

    return Response.status(Response.Status.OK).entity(result).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registerCustomer(final Customer customer) {

    try {
      System.out.println(customer.toString());
      System.out.println(customerDao.insert(customer) + " 건의 사항이 처리되었습니다.");
    } catch (Exception e) {
      System.out.println("Error : " + e);
      return Response.status(Response.Status.FORBIDDEN).entity(getExist()).build();
    }
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  // 수정 범위를 어디까지 할 것인가?
  @PUT
  @Path("{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response modifyCustomer(final @PathParam("id") String id) {
    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteCustomer(final @PathParam("id") String id) {
    System.out.println(customerDao.delete(id) + " 건의 사항이 처리되었습니다.");

    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
