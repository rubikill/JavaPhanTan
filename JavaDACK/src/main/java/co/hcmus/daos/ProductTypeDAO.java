package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.ProductType;

public interface ProductTypeDAO {
	public void addProductType(ProductType producttype);
	public void updateProductType(ProductType producttype);
	public ProductType getProductType(String id);
	public void deleteProductType(String id);
	public List<ProductType> getProductTypes();
	
}
