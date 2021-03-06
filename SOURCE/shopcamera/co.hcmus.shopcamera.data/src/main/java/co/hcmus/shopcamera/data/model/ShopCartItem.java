package co.hcmus.shopcamera.data.model;

/**
 * Shop cart item
 * @author Thanh Toan
 * 
 */
public class ShopCartItem {
	private String id; // id of product
	private String name; // name of product
	private String manufacturerId; // manufacturer id of product
	private double price; // price of product
	private int count; // count of product

	/**
	 * 
	 */
	public ShopCartItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param manufacturerId
	 * @param price
	 * @param count
	 */
	public ShopCartItem(String id, String name, String manufacturerId,
			double price, int count) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturerId = manufacturerId;
		this.price = price;
		this.count = count;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the manufacturerId
	 */
	public String getManufacturerId() {
		return manufacturerId;
	}

	/**
	 * @param manufacturerId
	 *            the manufacturerId to set
	 */
	public void setManufacturerId(String manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
