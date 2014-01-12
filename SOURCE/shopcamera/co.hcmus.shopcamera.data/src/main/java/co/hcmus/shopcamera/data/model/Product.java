package co.hcmus.shopcamera.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product information
 * 
 * @author Thanh Toan
 * 
 */
@Document
public class Product {
	@Id
	private String id; // id of product
	private String name; // name of product
	private String productTypeId; // id of product type
	private String description; // description
	private int quantity; // quantity of product
	private int sellCount; // sell count of product
	private int importCount; // import Count of product
	private String manufacturerId; // manufacturer id of product
	private String productStateId; // product state id of product
	private double price; // price of product
	private String status; // status
	private int point; // Product's point
	private String url;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private ProductDetail productDetail;
	private ProductType productType;
	private ProductState productState;
	private Manufacturer manufacturer;

	/**
	 * 
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 * @param productTypeId
	 * @param description
	 * @param quantity
	 * @param sellCount
	 * @param importCount
	 * @param manufacturerId
	 * @param productStateId
	 * @param price
	 * @param status
	 * @param point
	 * @param productDetail
	 * @param productType
	 * @param productState
	 * @param manufacturer
	 */
	public Product(String name, String productTypeId, String description,
			int quantity, int sellCount, int importCount,
			String manufacturerId, String productStateId, double price,
			String status, int point, ProductDetail productDetail,
			ProductType productType, ProductState productState,
			Manufacturer manufacturer) {
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
		this.productDetail = productDetail;
		this.productType = productType;
		this.productState = productState;
		this.manufacturer = manufacturer;
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
	 * @return the productTypeId
	 */
	public String getProductTypeId() {
		return productTypeId;
	}

	/**
	 * @param productTypeId
	 *            the productTypeId to set
	 */
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the sellCount
	 */
	public int getSellCount() {
		return sellCount;
	}

	/**
	 * @param sellCount
	 *            the sellCount to set
	 */
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}

	/**
	 * @return the importCount
	 */
	public int getImportCount() {
		return importCount;
	}

	/**
	 * @param importCount
	 *            the importCount to set
	 */
	public void setImportCount(int importCount) {
		this.importCount = importCount;
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
	 * @return the productStateId
	 */
	public String getProductStateId() {
		return productStateId;
	}

	/**
	 * @param productStateId
	 *            the productStateId to set
	 */
	public void setProductStateId(String productStateId) {
		this.productStateId = productStateId;
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

	/**
	 * @return the point
	 */
	public int getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(int point) {
		this.point = point;
	}

	/**
	 * @return the productDetail
	 */
	public ProductDetail getProductDetail() {
		return productDetail;
	}

	/**
	 * @param productDetail
	 *            the productDetail to set
	 */
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}

	/**
	 * @return the productType
	 */
	public ProductType getProductType() {
		return productType;
	}

	/**
	 * @param productType
	 *            the productType to set
	 */
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	/**
	 * @return the productState
	 */
	public ProductState getProductState() {
		return productState;
	}

	/**
	 * @param productState
	 *            the productState to set
	 */
	public void setProductState(ProductState productState) {
		this.productState = productState;
	}

	/**
	 * @return the manufacturer
	 */
	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer
	 *            the manufacturer to set
	 */
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
}
