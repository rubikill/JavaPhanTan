package co.hcmus.daos;

import java.util.List;

import com.mongodb.gridfs.GridFSDBFile;

import co.hcmus.models.Product;

public interface IProductDAO {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public Product getProductById(String id);

	public void deleteProduct(String id);

	public List<Product> getProducts();

	public List<Product> getProductsByTypeId(String id, String status);

	public List<Product> getProductsByManufacturerId(String id, String status);

	public List<Product> getProductByProductStateId(String id, String status);

	public void saveImage(String name, String path);

	public GridFSDBFile getImageByName(String name);

	public void writeImage(String name, String path);

	public void deleteImageByName(String name);

	public List<Product> searchProductByName(String name, String status);

}
