package co.hcmus.shopcamera.utility;

/**
 * This Enum use for set User Status
 * @author Thanh Toan
 *
 */
public enum STATUS {
	DISABLE("Disable"), ACTIVE("Active"), INACTIVE("Inactive"), BLOCK("Block");

	private String statusCode;

	private STATUS(String s) {
		statusCode = s;
	}

	public String getStatusCode() {
		return statusCode;
	}
}
