package co.hcmus.daos;

import java.util.List;

import com.mongodb.gridfs.GridFSDBFile;

import co.hcmus.models.Product;

/**
 * Interface of product DAO
 * 
 * @author Thanh Toan
 * 
 */
public interface IProductDAO {
	/**
	 * create
	 * 
	 * @param product
	 */
	public void addProduct(Product product);

	/**
	 * update
	 * 
	 * @param product
	 */
	public void updateProduct(Product product);

	/**
	 * get
	 * 
	 * @param id
	 * @return
	 */
	public Product getProductById(String id);

	/**
	 * delete
	 * 
	 * @param id
	 */
	public void deleteProduct(String id);

	/**
	 * get all
	 * 
	 * @return
	 */
	public List<Product> getProducts();

	/**
	 * get by type id
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<Product> getProductsByTypeId(String id, String status);

	/**
	 * get by manufacture id
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<Product> getProductsByManufacturerId(String id, String status);

	/**
	 * get by state
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public List<Product> getProductByProductStateId(String id, String status);

	/**
	 * save img
	 * 
	 * @param name
	 * @param path
	 */
	public void saveImage(String name, String path);

	/**
	 * get img
	 * 
	 * @param name
	 * @return
	 */
	public GridFSDBFile getImageByName(String name);

	/**
	 * write img
	 * 
	 * @param name
	 * @param path
	 */
	public void writeImage(String name, String path);

	/**
	 * delete img
	 * 
	 * @param name
	 */
	public void deleteImageByName(String name);

	/**
	 * search by name
	 * 
	 * @param name
	 * @param status
	 * @return
	 */
	public List<Product> searchProductByName(String name, String status);
	
	public Product getProductByName(String name);
	
	public void activeProduct(String id);
}
