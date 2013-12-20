package co.hcmus.services.Imp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IProductStateDAO;
import co.hcmus.models.Product;
import co.hcmus.models.ProductState;
import co.hcmus.services.IProductService;
import co.hcmus.services.IProductStateService;
import co.hcmus.util.STATUS;

@Service("productStateService")
@Transactional
public class ProductStateServiceMongo implements IProductStateService {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductStateServiceMongo.class);
	
	@Autowired
	private IProductStateDAO productStateDAO;
	@Autowired
	private IProductService productService;

	@Override
	public void addProductState(ProductState productState) {
		logger.info("productStateServiceMong add productState with Name : " + productState.getName());
		productStateDAO.addProductState(productState);

	}

	@Override
	public void updateProductState(ProductState productState) {
		// TODO Auto-generated method stub
		logger.info("productStateServiceMong update productState with id : " + productState.getId());
		productStateDAO.updateProductState(productState);

	}

	@Override
	public ProductState getProductStateById(String id, String status) {
		// TODO Auto-generated method stub
		logger.info("productStateServiceMong get productState by Id : " + id);
		return productStateDAO.getProductStateById(id, status);
	}

	@Override
	public void deleteProductState(String id) {
		List<Product> listProduct = productService.getProductByProductStateId(
				id, STATUS.ACTIVE.getStatusCode());
		for (Product product : listProduct)
			productService.deleteProduct(product.getId());
		logger.info("productStateServiceMong delete productState by Id : " + id);
		productStateDAO.deleteProductState(id);
	}

	@Override
	public List<ProductState> getProductStates() {
		// TODO Auto-generated method stub
		logger.info("productStateServiceMong get all ProductState");
		return productStateDAO.getProductStates();
	}

	@Override
	public ProductState getProductStateByName(String name, String status) {
		// TODO Auto-generated method stub
		logger.info("productStateServiceMong get productState by name : " + name);
		return productStateDAO.getProductStateByName(name, status);
	}
}
