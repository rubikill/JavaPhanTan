package co.hcmus.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * This model contain Cart information
 * 
 * @author Thanh Toan
 * 
 */
@Component
@Scope("session")
public class Cart {
	private String id; // id of product
	private String name; // name of product
	private String manufacturerId; // manufacturer id of product
	private double price; // price of product
	private String url;
	private int count; // count of product
	private int discount;

	/**
	 * 
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param manufacturerId
	 * @param price
	 * @param count
	 * @param discount
	 */
	public Cart(String id, String name, String manufacturerId, double price,
			int count, int discount, String url) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturerId = manufacturerId;
		this.price = price;
		this.count = count;
		this.discount = discount;
		this.url = url;
	}

	/**
	 * 
	 * @param product
	 */
	public Cart(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.manufacturerId = product.getManufacturerId();
		this.price = product.getPrice();
		this.url = product.getUrl();
		this.count = 1;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @return discount
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * set discount
	 * @param discount
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
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
