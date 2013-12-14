package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IProductStateDAO;
import co.hcmus.models.ProductState;
import co.hcmus.services.IProductStateService;

@Service("productStateService")
@Transactional
public class ProductStateServiceMongo implements IProductStateService {

	@Autowired
	private IProductStateDAO productStateDAO;

	@Override
	public void addProductState(ProductState productState) {
		productStateDAO.addProductState(productState);

	}

	@Override
	public void updateProductState(ProductState productState) {
		// TODO Auto-generated method stub
		productStateDAO.updateProductState(productState);

	}

	@Override
	public ProductState getProductStateById(String id, String status) {
		// TODO Auto-generated method stub
		return productStateDAO.getProductStateById(id, status);
	}

	@Override
	public void deleteProductState(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductState> getProductStates() {
		// TODO Auto-generated method stub
		return productStateDAO.getProductStates();
	}

	@Override
	public ProductState getProductStateByName(String name, String status) {
		// TODO Auto-generated method stub
		return productStateDAO.getProductStateByName(name, status);
	}
}
