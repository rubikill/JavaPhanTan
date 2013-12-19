package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.ProductDetail;

/**
 * 
 * @author Thanh Toan
 *
 */
public interface IProductDetailDAO {
	/**
	 * 
	 * @param productDetail
	 */
	public void addProductDetail(ProductDetail productDetail);

	/**
	 * 
	 * @param productDetail
	 */
	public void updateProductDetail(ProductDetail productDetail);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProductDetail getProductDetailById(String id);

	/**
	 * 
	 * @param id
	 */
	public void deleteProductDetail(String id);

	/**
	 * 
	 * @return
	 */
	public List<ProductDetail> getProductDetails();

	/**
	 * 
	 * @param productId
	 * @return
	 */
	public ProductDetail getProductDetailByProductId(String productId);
}
