package co.hcmus.daos;

import java.util.List;
import co.hcmus.models.ProductDetail;

public interface IProductDetailDAO {
	public void addProductDetail(ProductDetail productDetail);

	public void updateProductDetail(ProductDetail productDetail);

	public ProductDetail getProductDetailById(String id);

	public void deleteProductDetail(String id);

	public List<ProductDetail> getProductDetails();

	public ProductDetail getProductDetailByProductId(String productId);
}
