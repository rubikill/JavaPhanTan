package co.hcmus.services;

import java.util.List;

import com.mongodb.gridfs.GridFSDBFile;

import co.hcmus.models.Product;

/**
 * 
 * @author Thanh Toan
 * 
 */
public interface IProductService {
	/**
	 * 
	 * @param product
	 */
	public void addProduct(Product product);

	/**
	 * 
	 * @param product
	 */
	public void updateProduct(Product product);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Product getProductById(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteProduct(String id);

	/**
	 * 
	 * @return
	 */
	public List<Product> getProducts();

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<Product> getProductsByTypeId(String id, String status);

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<Product> getProductsByManufacturerId(String id, String status);

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<Product> getProductByProductStateId(String id, String status);

	/**
	 * 
	 * @param name
	 * @param path
	 */
	public void saveImage(String name, String path);

	/**
	 * 
	 * @param name
	 * @return
	 */
	public GridFSDBFile getImageByName(String name);

	/**
	 * 
	 * @param name
	 * @param path
	 */
	public void writeImage(String name, String path);

	/**
	 * 
	 * @param name
	 */
	public void deleteImageByName(String name);

	/**
	 * 
	 * @param name
	 * @param status
	 * @return
	 */
	public List<Product> searchProductByName(String name, String status);
	
	public Product getProductByName(String name);
	
	public void activeProduct(String id);
	
}
