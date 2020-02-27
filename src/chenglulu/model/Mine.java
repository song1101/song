package chenglulu.model;

import java.io.Serializable;

public class Mine implements Serializable{
	private String pubDescriptions;
	private String ordDescriptions;
	private String appDescriptions;
	public Mine() {}
	public String getpubDescriptions(){
		return pubDescriptions;
	}
	public void setpubDescriptions(String pubDescriptions) {
		this.pubDescriptions=pubDescriptions;
	}
	public String getordDescriptions(){
		return ordDescriptions;
	}
	public void setordDescriptions(String ordDescriptions) {
		this.ordDescriptions=ordDescriptions;
	}
	public String getappDescriptions(){
		return appDescriptions;
	}
	public void setappDescriptions(String appDescriptions) {
		this.appDescriptions=appDescriptions;
	}
}
