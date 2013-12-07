package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.daos.IProductTypeDAO;
import co.hcmus.models.ProductType;
import co.hcmus.services.IProductTypeService;

@Service("productTypeService")
@Transactional
public class ProductTypeServiceMongo implements IProductTypeService {

	@Autowired
	private IProductTypeDAO ProductTypeDAO;

	@Override
	public void addProductType(ProductType productType) {
		ProductTypeDAO.addProductType(productType);
	}

	public void updateProductType(ProductType productType) {
		ProductTypeDAO.updateProductType(productType);
	}

	public List<ProductType> getProductTypes() {
		return ProductTypeDAO.getProductTypes();
	}

	@Override
	public ProductType getProductType(String id) {
		return ProductTypeDAO.getProductType(id);
	}

	@Override
	public void deleteProductType(String email) {
		ProductTypeDAO.deleteProductType(email);
	}

}
