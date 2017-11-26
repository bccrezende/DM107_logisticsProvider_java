package com.inatel.dm107;

import java.sql.Connection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/apiDelivery")
public class DeliveryService {
	@GET
	@Path("/delivery/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listDeliveryByID(@PathParam("id") int orderId) {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		DeliveryModel delivery = null;
		try {
			Connection conn = connectionFactory.getConnection();
			DeliveryDAO deliveryDAO = new DeliveryDAO();
			delivery = deliveryDAO.listDeliveryByID(conn, orderId);
			return Response.status(Response.Status.OK).entity(delivery).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@POST
	@Path("/adddelivery/")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(DeliveryModel delivery) {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try {
			
			Connection conn = connectionFactory.getConnection();
			DeliveryDAO deliveryDAO = new DeliveryDAO();
			deliveryDAO.insert(conn, delivery);
			return Response.status(Response.Status.OK).build();
			
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}
