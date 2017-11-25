package com.inatel.dm107;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
	public void insert(Connection conn, DeliveryModel delivery) throws SQLException{
		String sql = "insert into delivery (nome, email, cel) values (?, ?, ?);";
		PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, delivery.getName());
			pstm.setString(2, delivery.getEmail());
			pstm.setString(3, delivery.getCel());
			pstm.execute();
	}
	
	public void update(Connection conn, DeliveryModel delivery, int deliveryId) throws SQLException{
		String sql = "update delivery set nome  = ?,  email = ?,  cel = ? where id = ?";
		PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, delivery.getName());
			pstm.setString(2, delivery.getEmail());
			pstm.setString(3, delivery.getCel());
			pstm.setInt(4, deliveryId);
			pstm.execute();
	}
	
	public List<DeliveryModel> list(Connection conn) throws SQLException{
		String sql = "select * from delivery";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			DeliveryModel delivery;
			List<DeliveryModel> deliverys = new ArrayList<>();
			 while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String name = rs.getString("nome");
		        String email = rs.getString("email");
				String cel = rs.getString("cel");
		        delivery = new DeliveryModel(id, name, cel, email );
		        deliverys.add(delivery);
		      }
		return deliverys;
	}
	
	public DeliveryModel listById(Connection conn, int deliveryId) throws SQLException{
		String sql = "select * from delivery where id = ?";
			PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, deliveryId);
			
			ResultSet rs = pstm.executeQuery();
			DeliveryModel delivery  = new DeliveryModel();
			 while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String name = rs.getString("nome");
		        String email = rs.getString("email");
				String cel = rs.getString("cel");
				delivery = new DeliveryModel(id, name, cel, email );
		      }
		return delivery;
	}
	
	public DeliveryModel listByNameEmail(Connection conn, String deliveryName, String deliveryEmail) throws SQLException{
		String sql = "select * from delivery where nome = ?";
		
			if(deliveryEmail != null){
				sql += " and email = ?";
			}
			
			PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, deliveryName);
			
			if(deliveryEmail != null){
				pstm.setString(2, deliveryEmail);
			}
			
			ResultSet rs = pstm.executeQuery();
			DeliveryModel delivery  = new DeliveryModel();
			 while (rs.next())
		      {
		        int id = rs.getInt("id");
		        String name = rs.getString("nome");
		        String email = rs.getString("email");
				String cel = rs.getString("cel");
				delivery = new DeliveryModel(id, name, cel, email );
		      }
		return delivery;
	}
	
	public  void delete(Connection conn, int deliveryId) throws SQLException{
		PreparedStatement ps;
			 ps = conn.prepareStatement("delete from delivery where id = ?");
			 ps.setInt(1, deliveryId);
		     ps.executeUpdate();
       
	}
}
