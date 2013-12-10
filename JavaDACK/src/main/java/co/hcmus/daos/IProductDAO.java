package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.Product;

public interface IProductDAO {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public Product getProductById(String id);

	public void deleteProduct(String id);

	public List<Product> getProducts();

	public List<Product> getProductsByTypeId(String id);

	public List<Product> getProductsByManufacturerId(String id);
}
