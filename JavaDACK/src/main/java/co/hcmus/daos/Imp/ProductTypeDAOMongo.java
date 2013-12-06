package co.hcmus.daos.Imp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.IProductTypeDAO;
import co.hcmus.models.ProductType;

@Repository("productTypeDAO")
public class ProductTypeDAOMongo implements IProductTypeDAO {

	@Override
	public void addProductType(ProductType producttype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductType(ProductType producttype) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductType getProductType(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProductType(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductType> getProductTypes() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
