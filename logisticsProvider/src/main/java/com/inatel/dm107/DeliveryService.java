package com.inatel.dm107;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/apiContato")
public class DeliveryService {
	  @GET
	  @Path("/contatos")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response listAllContatos() {
		  ConnectionFactory connectionFactory = new ConnectionFactory();
		  List<DeliveryModel> delivery = null;
		  try {
			Connection conn = connectionFactory.getConnection();
			DeliveryDAO deliveryDAO = new DeliveryDAO();
			delivery = deliveryDAO.list(conn);
			
			if(delivery == null){
				return Response.status(Response.Status.NOT_FOUND).build();
			} else {
				return Response.status(Response.Status.OK).entity(delivery).build();
			}
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	 }
	  
	  @GET
	  @Path("/contatoId/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response listContatoById(@PathParam("id") int contatoId) {
		  ConnectionFactory connectionFactory = new ConnectionFactory();
		  DeliveryModel delivery = null;
		  try {
			Connection conn = connectionFactory.getConnection();
			DeliveryDAO deliveryDAO = new DeliveryDAO();
			delivery = deliveryDAO.listById(conn, contatoId);
			return Response.status(Response.Status.OK).entity(delivery).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	 }
	  
	  @GET
	  @Path("/contato/{name}")
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response listContatoByNameEmail(@PathParam("name") String contatoName, @QueryParam("email") String contatoEmail) {
		  ConnectionFactory connectionFactory = new ConnectionFactory();
		  DeliveryModel delivery = null;
		  try {
			Connection conn = connectionFactory.getConnection();
			DeliveryDAO deliveryDAO = new DeliveryDAO();
			delivery = deliveryDAO.listByNameEmail(conn, contatoName, contatoEmail);
			return Response.status(Response.Status.OK).entity(delivery).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	 }
	  
      	@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Response create( DeliveryModel contato){
	    	 ConnectionFactory connectionFactory = new ConnectionFactory();
			  try {
				Connection conn = connectionFactory.getConnection();
				DeliveryDAO deliveryDAO = new DeliveryDAO();
				deliveryDAO.insert(conn, contato);
				return Response.status(Response.Status.OK).build();
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
	    }

      	@PUT
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
	    @Path("/{id}")
		public Response update( DeliveryModel contato, @PathParam("id") int id){
	    	 ConnectionFactory connectionFactory = new ConnectionFactory();
			  try {
				Connection conn = connectionFactory.getConnection();
				DeliveryDAO deliveryDAO = new DeliveryDAO();
				deliveryDAO.update(conn, contato, id);
				return Response.status(Response.Status.OK).build();
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
	    }

      	@DELETE
	    @Path("/{id}")
	    public Response delete( @PathParam("id") int id){
	    	 ConnectionFactory connectionFactory = new ConnectionFactory();
			  try {
				Connection conn = connectionFactory.getConnection();
				DeliveryDAO deliveryDAO = new DeliveryDAO();
				deliveryDAO.delete(conn, id);
				return Response.status(Response.Status.OK).build();
			} catch (Exception e) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			}
	    }


}
