package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IProductDetailDAO;
import co.hcmus.shopcamera.data.model.ProductDetail;
import co.hcmus.shopcamera.manager.IProductDetailService;

@Service("productDetailService")
@Transactional
public class ProductDetailServiceMongo implements IProductDetailService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProductDetailServiceMongo.class);
	
	@Autowired
	private IProductDetailDAO productDetailDAO;

	@Override
	public void addProductDetail(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		logger.info("ProductDetailServiceMongo add productDetail");
		productDetailDAO.addProductDetail(productDetail);
	}

	@Override
	public void updateProductDetail(ProductDetail productDetail) {
		// TODO Auto-generated method stub
		logger.info("ProductDetailServiceMongo update productDetail with Id :" + productDetail.getId());
		productDetailDAO.updateProductDetail(productDetail);
	}

	@Override
	public ProductDetail getProductDetailById(String id) {
		// TODO Auto-generated method stub
		logger.info("ProductDetailServiceMongo get productDetail by Id : " + id);
		return productDetailDAO.getProductDetailById(id);
	}

	@Override
	public void deleteProductDetail(String id) {
		logger.info("ProductDetailServiceMongo delete productDetail with Id : " + id);
		productDetailDAO.deleteProductDetail(id);

	}

	@Override
	public List<ProductDetail> getProductDetails() {
		// TODO Auto-generated method stub
		logger.info("ProductDetailServiceMongo get all productDetails");
		return productDetailDAO.getProductDetails();
	}

	@Override
	public ProductDetail getProductDetailByProductId(String productId) {
		// TODO Auto-generated method stub
		logger.info("ProductDetailServiceMongo get productDetail by ProductId : " + productId);
		return productDetailDAO.getProductDetailByProductId(productId);
	}

	@Override
	public void activeProductDetail(String id) {
		logger.info("ProductDetailServiceMongo active productDetail with Id : " + id);
		productDetailDAO.activeProductDetail(id);

	}

}
