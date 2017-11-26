package com.inatel.dm107;


public class DeliveryModel {
	private int id;
	private int orderNumber;
	private int clientId;
	private String receiverName;
	private String receiverCpf;
	private String date;
	
	public DeliveryModel(){}

	public DeliveryModel(int id, int orderNumber, int clientId, String receiverName, String receiverCpf, String date) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.clientId = clientId;
		this.receiverName = receiverName;
		this.receiverCpf = receiverCpf;
		this.date = date;
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
