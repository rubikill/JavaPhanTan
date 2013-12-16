package co.hcmus.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PointLevel {

	private String VIP;
	private String status;
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVIP() {
		return VIP;
	}

	public String VIP() {
		return VIP;
	}

	public void setVIP(String VIP) {
		this.VIP = VIP;
	}
}
