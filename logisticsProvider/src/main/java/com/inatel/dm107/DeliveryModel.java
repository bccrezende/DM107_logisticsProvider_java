package com.inatel.dm107;


public class DeliveryModel {
	private int id;
	private int orderNumber;
	private int clientId;
	private String receiverName;
	private String receiverCpf;
	private String date;
	
	public DeliveryModel(){}

	public DeliveryModel(int id, int order_number, int client_id, String receiver_name, String receiver_cpf, String data) {
		this.id = id;
		this.setOrderNumber(order_number);
		this.setClientId(client_id);
		this.setReceiverName(receiver_name);
		this.setReceiverCpf(receiver_cpf);
		this.setDate(data);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverCpf() {
		return receiverCpf;
	}

	public void setReceiverCpf(String receiverCpf) {
		this.receiverCpf = receiverCpf;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
