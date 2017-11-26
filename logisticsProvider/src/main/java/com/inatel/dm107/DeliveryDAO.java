package com.inatel.dm107;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DeliveryDAO {
	public void insert(Connection conn, DeliveryModel delivery) throws SQLException{
		String sql = "insert into delivery (order_number, client_id, receiver_name, receiver_cpf, data) values (?, ?, ?, ?, ?);";
		PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, delivery.getOrderNumber());
			pstm.setInt(2, delivery.getClientId());
			pstm.setString(3, delivery.getReceiverName());
			pstm.setString(4, delivery.getReceiverCpf());
			pstm.setString(5, delivery.getDate());
			pstm.execute();
	}
	public DeliveryModel listDeliveryByID(Connection conn, int orderId) throws SQLException{
			String sql = "select * from delivery where order_number = ?";
			PreparedStatement pstm;
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, orderId);
			ResultSet rs = pstm.executeQuery();
			
			DeliveryModel delivery = new DeliveryModel();
			 while (rs.next())
		      {
		        int id = rs.getInt("id");
		        int order_number = rs.getInt("order_number");
		        int client_id = rs.getInt("client_id");
				String receiver_name = rs.getString("receiver_name");
				String receiver_cpf = rs.getString("receiver_cpf");
				String data = rs.getString("data");
				delivery = new DeliveryModel(id, order_number, client_id, receiver_name, receiver_cpf, data);
		      }
		return delivery;
	}
}
