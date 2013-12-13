package co.hcmus.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private String id; // id of product
	private String name; // name of product
	private String productTypeId; // id of product type
	private String description; //description
	private int quantity; // quantity of product
	private int sellCount; // sell count of product
	private int importCount; // import Count of product
	private String manufacturerId; // manufacturer id of product
	private String productStateId;	// product state id of product
	private double price; // price of product
	private String status; // status
	private int point; // Product's point

	public Product(String name, String productTypeId, String description, int quantity,
			int sellCount, int importCount, String manufacturerId, String productStateId,
			double price, int point, String status) {
		super();
		this.name = name;
		this.productTypeId = productTypeId;
		this.description = description;
		this.quantity = quantity;
		this.sellCount = sellCount;
		this.importCount = importCount;
		this.manufacturerId = manufacturerId;
		this.productStateId = productStateId;
		this.price = price;
		this.status = status;
		this.point = point;
	}

	public Product() {

	}

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
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

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSellCount() {
		return sellCount;
	}

	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	public int getImportCount() {
		return importCount;
	}

	public void setImportCount(int importCount) {
		this.importCount = importCount;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProductStateId() {
		return productStateId;
	}

	public void setProductStateId(String productStateId) {
		this.productStateId = productStateId;
	}

}
