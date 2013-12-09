package co.hcmus.util;

public enum STATUS {
	DISABLE("Deleted"), ACTIVE("Aactive");
	 
	private String statusCode;
 
	private STATUS(String s) {
		statusCode = s;
	}
 
	public String getStatusCode() {
		return statusCode;
	}
}
