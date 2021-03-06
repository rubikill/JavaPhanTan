package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IProductTypeDAO;
import co.hcmus.shopcamera.data.model.Product;
import co.hcmus.shopcamera.data.model.ProductType;
import co.hcmus.shopcamera.manager.IProductService;
import co.hcmus.shopcamera.manager.IProductTypeService;
import co.hcmus.shopcamera.utility.STATUS;

@Service("productTypeService")
@Transactional
public class ProductTypeServiceMongo implements IProductTypeService {


	private static final Logger logger = LoggerFactory
			.getLogger(ProductTypeServiceMongo.class);
	
	@Autowired
	private IProductTypeDAO ProductTypeDAO;
	@Autowired
	private IProductService productService;

	@Override
	public void addProductType(ProductType productType) {
		logger.info("ProductTypeServiceMongo add ProductType with Name : " + productType.getName());
		ProductTypeDAO.addProductType(productType);
	}

	public void updateProductType(ProductType productType) {
		logger.info("ProductTypeServiceMongo update ProductType with Id : " + productType.getId());
		ProductTypeDAO.updateProductType(productType);
	}

	public List<ProductType> getProductTypes() {
		logger.info("ProductTypeServiceMongo get all ProductTypes");
		return ProductTypeDAO.getProductTypes();
	}

	@Override
	public ProductType getProductType(String id) {
		logger.info("ProductTypeServiceMongo get ProductType with Id : " + id);
		return ProductTypeDAO.getProductType(id);
	}

	@Override
	public void deleteProductType(String id) {
		List<Product> listProduct = productService.getProductsByTypeId(id, STATUS.ACTIVE.getStatusCode());
		for(Product product : listProduct)
			productService.deleteProduct(product.getId());
		logger.info("ProductTypeServiceMongo delete ProductType with id : " +id);
		ProductTypeDAO.deleteProductType(id);
	}
}
