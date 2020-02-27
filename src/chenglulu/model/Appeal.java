package chenglulu.model;

import java.io.Serializable;

public class Appeal implements Serializable{
	private int appealID;
	private int orderID;
	private String reason;
	private String descriptions;
	private String complainant;
	private String becomplainant;
	private int ishandled;
	public Appeal() { }
	public int getAppealID() {
		      return appealID;
	}
	public void setAppealID(int appealID) {
		this.appealID = appealID;
	}
	public int getOrderID() {
		      return orderID;
	}
	public void setOrderID(int orderID) {
		      this.orderID = orderID;
	}
	public String getReason() {
		      return reason;
	}
	public void setReason(String reason) {
		      this.reason = reason;
	}
	public String getComplainant() {
		      return complainant;
	}
	public void setComplainant(String complainant) {
		      this.complainant = complainant;
	}
	public String getDescriptions() {
	    return descriptions;
	}
	public void setDescriptions(String descriptions) {
	    this.descriptions = descriptions;
	}
	public String getBecomplainant() {
		return becomplainant;
	}
	public void setBecomplainant(String becomplainant) {
		this.becomplainant = becomplainant;
	}
	public int getIshandled() {
		return ishandled;
	}
	public void setIshandled(int ishandled) {
		this.ishandled = ishandled;
	}
}
