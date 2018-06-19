package io.wisoft.capstone.controller;

import io.wisoft.capstone.dao.PgsqlDeviceDao;
import io.wisoft.capstone.vo.Device;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/devices")
@Produces(MediaType.APPLICATION_JSON)
public class DevicesController extends ResponseCommand{

  //TODO 싱글톤
  private PgsqlDeviceDao pgsqlDeviceDao = new PgsqlDeviceDao();

  @GET
  public Response getAllDevices() {
    try {
      List<Device> devices = pgsqlDeviceDao.selectAll();

      for (Device device: devices) {
        System.out.println(device.getDeviceID());
      }
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @GET
  @Path("{deviceID}")
  public Response getDevicesID(final @PathParam("deviceID")  String deviceID) {
    try {
      List<Device> devices = pgsqlDeviceDao.select(deviceID);
      for (Device device : devices) {
        System.out.println(device);
      }
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }
    return Response.status(Response.Status.OK).entity(getOK()).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response insertDeviceID(final Device device) {
    try {
      System.out.println(device.toString());
      System.out.println(pgsqlDeviceDao.insert(device));
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }

    return Response.status(Response.Status.CREATED).entity(getOK()).build();
  }

  @DELETE
  @Path("{deviceID}")
  public Response deleteDeviceID(final @PathParam("deviceID") String deviceID) {
    try {
      System.out.println(pgsqlDeviceDao.delete(deviceID));
    } catch (Exception e) {
      System.out.println("error : " + e);
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(getInternalServerError()).build();
    }

    return Response.status(Response.Status.OK).entity(getOK()).build();
  }
}
