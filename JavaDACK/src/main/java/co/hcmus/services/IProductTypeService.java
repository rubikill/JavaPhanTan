package co.hcmus.services;

import java.util.List;

import co.hcmus.models.ProductType;

public interface IProductTypeService {
	public void addProductType(ProductType producttype);

	public void updateProductType(ProductType producttype);

	public ProductType getProductType(int id);

	public void deleteProductType(int id);

	public List<ProductType> getProductTypes();

}
