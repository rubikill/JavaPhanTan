package co.hcmus.util;

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
