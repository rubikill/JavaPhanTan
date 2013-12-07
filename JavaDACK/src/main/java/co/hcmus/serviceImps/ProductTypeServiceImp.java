package co.hcmus.serviceImps;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.ProductTypeDAO;
import co.hcmus.models.ProductType;
import co.hcmus.services.ProductTypeService;

@Service("productTypeService")
@Transactional
public class ProductTypeServiceImp implements ProductTypeService {

	@Autowired
	private ProductTypeDAO productTypeDAO;

	@Override
	public void addProductType(ProductType producttype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductType(ProductType producttype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductType getProductType(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductType(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductType> getProductTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
