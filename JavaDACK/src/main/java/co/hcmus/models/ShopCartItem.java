package co.hcmus.models;

public class ShopCartItem {
	private String id; // id of product
	private String name; // name of product
	private String manufacturerId; // manufacturer id of product
	private double price; // price of product
	private int count; // count of product

	public ShopCartItem() {

	}

	public ShopCartItem(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.manufacturerId = product.getManufacturerId();
		this.price = product.getPrice();
		this.count = 0;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
