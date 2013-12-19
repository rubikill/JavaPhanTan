package co.hcmus.daos;

import java.util.List;

import co.hcmus.models.ProductState;

/**
 * 
 * @author Thanh Toan
 *
 */
public interface IProductStateDAO {
	/**
	 * 
	 * @param productState
	 */
	public void addProductState(ProductState productState);

	/**
	 * 
	 * @param productState
	 */
	public void updateProductState(ProductState productState);

	/**
	 * 
	 * @param id
	 * @param status
	 * @return
	 */
	public ProductState getProductStateById(String id,String status);
	
	/**
	 * 
	 * @param name
	 * @param status
	 * @return
	 */
	public ProductState getProductStateByName(String name, String status);

	/**
	 * 
	 * @param id
	 */
	public void deleteProductState(String id);

	/**
	 * 
	 * @return
	 */
	public List<ProductState> getProductStates();
}
