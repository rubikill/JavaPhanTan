package co.hcmus.services;

import java.util.List;

import co.hcmus.models.ProductDetail;

public interface IProductDetailService {
	public void addProductDetail(ProductDetail productDetail);

	public void updateProductDetail(ProductDetail productDetail);

	public ProductDetail getProductDetailById(String id);

	public void deleteProductDetail(String id);

	public List<ProductDetail> getProductDetails();
	
	public ProductDetail getProductDetailByProductId(String productId);
	
	public void activeProductDetail(String id);
}
