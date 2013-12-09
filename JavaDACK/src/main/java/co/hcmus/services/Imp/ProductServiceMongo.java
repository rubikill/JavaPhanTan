package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
