package chenglulu.model;

import java.io.Serializable;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private int orderID;
	private String Title;
	private String publisher;
	private String orders;
	private String orders_type;
	private String StartTime;
	private String EndTime;
	private Float Cost;
	private String Receiver;
	private String receivePhone;
	private String ReceivePlace;
	private String Description;
	private String orderTime;
	private int isCheck;
	private int isCompleted;
	private int isGet;
	
	public Order() {
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String Title) {
		this.Title = Title;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String StartTime) {
		this.StartTime = StartTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String EndTime) {
		this.EndTime = EndTime;
	}

	public Float getCost() {
		return Cost;
	}

	public void setCost(Float Cost) {
		this.Cost = Cost;
	}

	public String getReceivePlace() {
		return ReceivePlace;
	}

	public void setReceivePlace(String ReceivePlace) {
		this.ReceivePlace = ReceivePlace;
	}

	public String getReceiver() {
		return Receiver;
	}

	public void setReceiver(String Receiver) {
		this.Receiver = Receiver;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String Description) {
		this.Description = Description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getOrders() {
		return orders;
	}

	public void setOrders(String orders) {
		this.orders = orders;
	}

	public String getOrders_type() {
		return orders_type;
	}

	public void setOrders_type(String orders_type) {
		this.orders_type = orders_type;
	}

	public String getReceivePhone() {
		return receivePhone;
	}

	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}

	public int getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(int isCheck) {
		this.isCheck = isCheck;
	}

	public int getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(int isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getIsGet() {
		return isGet;
	}

	public void setIsGet(int isGet) {
		this.isGet = isGet;
	}  
}
