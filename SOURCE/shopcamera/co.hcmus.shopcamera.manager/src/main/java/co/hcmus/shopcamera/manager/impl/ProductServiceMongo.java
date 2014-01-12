package co.hcmus.shopcamera.manager.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.hcmus.shopcamera.data.dao.IProductDAO;
import co.hcmus.shopcamera.data.model.Comment;
import co.hcmus.shopcamera.data.model.Product;
import co.hcmus.shopcamera.data.model.ProductDetail;
import co.hcmus.shopcamera.data.model.PromotionDetail;
import co.hcmus.shopcamera.manager.ICommentService;
import co.hcmus.shopcamera.manager.IManufacturerService;
import co.hcmus.shopcamera.manager.IProductDetailService;
import co.hcmus.shopcamera.manager.IProductService;
import co.hcmus.shopcamera.manager.IProductStateService;
import co.hcmus.shopcamera.manager.IProductTypeService;
import co.hcmus.shopcamera.manager.IPromotionDetailService;
import co.hcmus.shopcamera.utility.STATUS;

import com.mongodb.gridfs.GridFSDBFile;

@Service("productService")
@Transactional
public class ProductServiceMongo implements IProductService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProductServiceMongo.class);
	
	@Autowired
	private IProductDAO productDAO;
	@Autowired
	private IProductDetailService productDetailService;
	@Autowired
	private IPromotionDetailService promotionDetailService;
	@Autowired
	private ICommentService commentService;
	@Autowired
	private IProductStateService productStateService;
	@Autowired
	private IProductTypeService productTypeSerivce;
	@Autowired
	private IManufacturerService manufacturerService;

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		logger.info("ProductServiceMongo add product with Name : " + product.getName());
		productDAO.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		logger.info("ProductServiceMongo update product with Id : " + product.getName());
		productDAO.updateProduct(product);
	}

	@Override
	public Product getProductById(String id) {
		// TODO Auto-generated method stub
		Product product = productDAO.getProductById(id);
		product.setProductDetail(productDetailService
				.getProductDetailByProductId(id));
		product.setProductState(productStateService.getProductStateById(
				product.getProductStateId(), STATUS.ACTIVE.getStatusCode()));
		product.setProductType(productTypeSerivce.getProductType(product
				.getProductTypeId()));
		product.setManufacturer(manufacturerService.getManufacturerById(product
				.getManufacturerId()));
		logger.info("ProductServiceMongo get product with Id : " + id);
		return product;
	}

	@Override
	public void deleteProduct(String id) {
		ProductDetail productDetail = productDetailService
				.getProductDetailByProductId(id);
		productDetailService.deleteProductDetail(productDetail.getId());
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByProductId(id,
						STATUS.ACTIVE.getStatusCode());
		for (PromotionDetail promotionDetail : listPromotionDetail)
			promotionDetailService.deletePromotionDetail(promotionDetail
					.getId());
		List<Comment> listComment = commentService.getCommentByProductId(id,
				STATUS.ACTIVE.getStatusCode());
		for (Comment cm : listComment)
			commentService.deleteComment(cm.getId());
		logger.info("ProductServiceMongo delete product with Id : " + id);
		productDAO.deleteProduct(id);

	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> listProduct = productDAO.getProducts();
		for (int i = 0; i < listProduct.size(); i++) {
			listProduct.get(i).setProductDetail(
					productDetailService
							.getProductDetailByProductId(listProduct.get(i)
									.getId()));
			listProduct.get(i)
					.setProductState(
							productStateService.getProductStateById(listProduct
									.get(i).getProductStateId(), STATUS.ACTIVE
									.getStatusCode()));
			listProduct.get(i).setProductType(
					productTypeSerivce.getProductType(listProduct.get(i)
							.getProductTypeId()));
			listProduct.get(i).setManufacturer(
					manufacturerService.getManufacturerById(listProduct.get(i)
							.getManufacturerId()));
		}
		logger.info("ProductServiceMongo get all  product");
		return listProduct;
	}

	@Override
	public List<Product> getProductsByTypeId(String id, String status) {
		// TODO Auto-generated method stub
		List<Product> listProduct = productDAO.getProductsByTypeId(id, status);
		for (int i = 0; i < listProduct.size(); i++) {
			listProduct.get(i).setProductDetail(
					productDetailService
							.getProductDetailByProductId(listProduct.get(i)
									.getId()));
			listProduct.get(i)
					.setProductState(
							productStateService.getProductStateById(listProduct
									.get(i).getProductStateId(), STATUS.ACTIVE
									.getStatusCode()));
			listProduct.get(i).setProductType(
					productTypeSerivce.getProductType(listProduct.get(i)
							.getProductTypeId()));
			listProduct.get(i).setManufacturer(
					manufacturerService.getManufacturerById(listProduct.get(i)
							.getManufacturerId()));
		}
		logger.info("ProductServiceMongo get product by productTypeId : " + id);
		return listProduct;
	}

	@Override
	public List<Product> getProductsByManufacturerId(String id, String status) {
		// TODO Auto-generated method stub
		List<Product> listProduct = productDAO.getProductsByManufacturerId(id,
				status);
		for (int i = 0; i < listProduct.size(); i++) {
			listProduct.get(i).setProductDetail(
					productDetailService
							.getProductDetailByProductId(listProduct.get(i)
									.getId()));
			listProduct.get(i)
					.setProductState(
							productStateService.getProductStateById(listProduct
									.get(i).getProductStateId(), STATUS.ACTIVE
									.getStatusCode()));
			listProduct.get(i).setProductType(
					productTypeSerivce.getProductType(listProduct.get(i)
							.getProductTypeId()));
			listProduct.get(i).setManufacturer(
					manufacturerService.getManufacturerById(listProduct.get(i)
							.getManufacturerId()));
		}
		logger.info("ProductServiceMongo get product by ManufactuerId : " + id);
		return listProduct;
	}

	@Override
	public void saveImage(String name, String path) {
		logger.info("ProductServiceMongo save Image with Name : " + name);
		productDAO.saveImage(name, path);

	}

	@Override
	public GridFSDBFile getImageByName(String name) {
		logger.info("ProductServiceMongo get Image by name: " + name);
		return productDAO.getImageByName(name);
	}

	@Override
	public void writeImage(String name, String path) {
		logger.info("ProductServiceMongo write image by name : " + name);
		productDAO.writeImage(name, path);

	}

	@Override
	public void deleteImageByName(String name) {
		logger.info("ProductServiceMongo delete Image by Name : " + name);
		productDAO.deleteImageByName(name);

	}

	@Override
	public List<Product> getProductByProductStateId(String id, String status) {
		// TODO Auto-generated method stub
		List<Product> listProduct = productDAO.getProductByProductStateId(id,
				status);
		for (int i = 0; i < listProduct.size(); i++) {
			listProduct.get(i).setProductDetail(
					productDetailService
							.getProductDetailByProductId(listProduct.get(i)
									.getId()));
			listProduct.get(i)
					.setProductState(
							productStateService.getProductStateById(listProduct
									.get(i).getProductStateId(), STATUS.ACTIVE
									.getStatusCode()));
			listProduct.get(i).setProductType(
					productTypeSerivce.getProductType(listProduct.get(i)
							.getProductTypeId()));
			listProduct.get(i).setManufacturer(
					manufacturerService.getManufacturerById(listProduct.get(i)
							.getManufacturerId()));
		}
		logger.info("ProductServiceMongo get product by productStateId : " + id);
		return listProduct;
	}

	@Override
	public List<Product> searchProductByName(String name, String status) {
		// TODO Auto-generated method stub
		List<Product> listProduct = productDAO
				.searchProductByName(name, status);
		for (int i = 0; i < listProduct.size(); i++) {
			listProduct.get(i).setProductDetail(
					productDetailService
							.getProductDetailByProductId(listProduct.get(i)
									.getId()));
			listProduct.get(i)
					.setProductState(
							productStateService.getProductStateById(listProduct
									.get(i).getProductStateId(), STATUS.ACTIVE
									.getStatusCode()));
			listProduct.get(i).setProductType(
					productTypeSerivce.getProductType(listProduct.get(i)
							.getProductTypeId()));
			listProduct.get(i).setManufacturer(
					manufacturerService.getManufacturerById(listProduct.get(i)
							.getManufacturerId()));
		}
		logger.info("ProductServiceMongo search product by name : " + name);
		return listProduct;
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		logger.info("ProductServiceMongo get product by name : " + name);
		return productDAO.getProductByName(name);
	}

	@Override
	public void activeProduct(String id) {
		ProductDetail productDetail = productDetailService
				.getProductDetailByProductId(id);
		productDetailService.activeProductDetail(productDetail.getId());
		List<PromotionDetail> listPromotionDetail = promotionDetailService
				.getPromotionDetailsByProductId(id,
						STATUS.INACTIVE.getStatusCode());
		for (PromotionDetail promotionDetail : listPromotionDetail)
			promotionDetailService.activePromotionDetail(promotionDetail
					.getId());
		List<Comment> listComment = commentService.getCommentByProductId(id,
				STATUS.INACTIVE.getStatusCode());
		for (Comment cm : listComment)
			commentService.activeComment(cm.getId());
		logger.info("ProductServiceMongo active product by Id : " + id);
		productDAO.activeProduct(id);

	}

}
