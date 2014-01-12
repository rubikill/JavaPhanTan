package co.hcmus.shopcamera.manager;

import java.util.List;

import co.hcmus.shopcamera.data.model.ProductDetail;

/**
 * 
 * @author Thanh Toan
 *
 */
public interface IProductDetailService {
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
	
	public void activeProductDetail(String id);
}
