package co.hcmus.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PointLevel {

	private String VIP;
	
	public String VIP() {
		return VIP;
	}
	public void setVIP(String VIP) {
		this.VIP = VIP;
	}
}
