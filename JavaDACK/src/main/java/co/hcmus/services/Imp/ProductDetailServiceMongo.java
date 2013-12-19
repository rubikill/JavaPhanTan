package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.hcmus.daos.IProductDetailDAO;
import co.hcmus.models.ProductDetail;
import co.hcmus.services.IProductDetailService;

@Service("productDetailService")
@Transactional
public class ProductDetailServiceMongo implements IProductDetailService {
	@Autowired
	private IProductDetailDAO productDetailDAO;

	@Override
	public void addProductDetail(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		productDetailDAO.addProductDetail(productDetail);
	}

	@Override
	public void updateProductDetail(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		productDetailDAO.updateProductDetail(productDetail);
	}

	@Override
	public ProductDetail getProductDetailById(String id) {
		// TODO Auto-generated method stub
		return productDetailDAO.getProductDetailById(id);
	}

	@Override
	public void deleteProductDetail(String id) {
		productDetailDAO.deleteProductDetail(id);

	}

	@Override
	public List<ProductDetail> getProductDetails() {
		// TODO Auto-generated method stub
		return productDetailDAO.getProductDetails();
	}

	@Override
	public ProductDetail getProductDetailByProductId(String productId) {
		// TODO Auto-generated method stub
		return productDetailDAO.getProductDetailByProductId(productId);
	}

	@Override
	public void activeProductDetail(String id) {
		productDetailDAO.activeProductDetail(id);

	}

}
