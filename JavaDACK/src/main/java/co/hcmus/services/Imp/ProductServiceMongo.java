package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.gridfs.GridFSDBFile;

import co.hcmus.daos.IProductDAO;
import co.hcmus.models.Product;
import co.hcmus.services.IProductService;

@Service("productService")
@Transactional
public class ProductServiceMongo implements IProductService {
	@Autowired
	private IProductDAO productDAO;

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDAO.updateProduct(product);
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		return productDAO.getProductById(id);
	}

	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productDAO.getProducts();
	}

	@Override
	public List<Product> getProductsByTypeId(String id, String status) {
		// TODO Auto-generated method stub
		return productDAO.getProductsByTypeId(id,status);
	}

	@Override
	public List<Product> getProductsByManufacturerId(String id, String status) {
		// TODO Auto-generated method stub
		return productDAO.getProductsByManufacturerId(id, status);
	}

	@Override
	public void saveImage(String name, String path) {
		productDAO.saveImage(name, path);
		
	}

	@Override
	public GridFSDBFile getImageByName(String name) {
		return productDAO.getImageByName(name);
	}

	@Override
	public void writeImage(String name, String path) {
		productDAO.writeImage(name, path);
		
	}

	@Override
	public void deleteImageByName(String name) {
		productDAO.deleteImageByName(name);
		
	}

	@Override
	public List<Product> getProductByProductStateId(String id, String status) {
		// TODO Auto-generated method stub
		return productDAO.getProductByProductStateId(id, status);
	}

}
