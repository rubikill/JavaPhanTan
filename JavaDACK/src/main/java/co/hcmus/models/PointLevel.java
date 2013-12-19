package co.hcmus.models;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Point level
 * @author Thanh Toan
 *
 */
@Document
public class PointLevel {

	private String VIP;
	private String status;

	/**
	 * 
	 */
	public PointLevel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param vIP
	 * @param status
	 */
	public PointLevel(String vIP, String status) {
		super();
		VIP = vIP;
		this.status = status;
	}

	/**
	 * @return the vIP
	 */
	public String getVIP() {
		return VIP;
	}

	/**
	 * @param vIP
	 *            the vIP to set
	 */
	public void setVIP(String vIP) {
		VIP = vIP;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
