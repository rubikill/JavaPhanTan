package co.hcmus.services;

import java.util.List;

import com.mongodb.gridfs.GridFSDBFile;

import co.hcmus.models.Product;

public interface IProductService {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public Product getProductById(String id);

	public void deleteProduct(String id);

	public List<Product> getProducts();

	public List<Product> getProductsByTypeId(String id);

	public List<Product> getProductsByManufacturerId(String id);

	public void saveImage(String name, String path);

	public GridFSDBFile getImageByName(String name);

	public void writeImage(String name, String path);

	public void deleteImageByName(String name);
}
