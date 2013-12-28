package co.hcmus.models;

public class ExchangeRate {
	private String curencyCode;
	private String curencyName;
	private String buy;
	private String transfer;
	private String sell;

	public String getCurencyCode() {
		return curencyCode;
	}

	public void setCurencyCode(String curencyCode) {
		this.curencyCode = curencyCode;
	}

	public String getCurencyName() {
		return curencyName;
	}

	public void setCurencyName(String curencyName) {
		this.curencyName = curencyName;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getSell() {
		return sell;
	}

	public void setSell(String sell) {
		this.sell = sell;
	}

}
