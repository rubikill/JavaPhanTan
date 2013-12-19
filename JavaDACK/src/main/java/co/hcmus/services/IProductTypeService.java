package co.hcmus.services;

import java.util.List;

import co.hcmus.models.ProductType;

/**
 * 
 * @author Thanh Toan
 *
 */
public interface IProductTypeService {
	/**
	 * 
	 * @param producttype
	 */
	public void addProductType(ProductType producttype);

	/**
	 * 
	 * @param producttype
	 */
	public void updateProductType(ProductType producttype);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProductType getProductType(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteProductType(String id);

	/**
	 * 
	 * @return
	 */
	public List<ProductType> getProductTypes();

}
