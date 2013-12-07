package co.hcmus.daoImps;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.hcmus.daos.ProductTypeDAO;
import co.hcmus.models.ProductType;

@Repository("productTypeDAO")
public class ProductTypeDAOImp implements ProductTypeDAO {
	@Autowired
	SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void addProductType(ProductType productType) {
		getCurrentSession().saveOrUpdate(productType);
	}

	public void updateProductType(ProductType productType) {
		getCurrentSession().update(productType);
	}

	public ProductType getProductType(int id) {
		ProductType productType = new ProductType();
		productType = (ProductType) getCurrentSession().get(ProductType.class, id);
		return productType;
	}

	public void deleteProductType(int id) {
		ProductType productType = getProductType(id);
		if (productType != null) {
			getCurrentSession().delete(productType);
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProductType> getProductTypes() {
		return getCurrentSession().createQuery("from ProductType").list();
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

}
