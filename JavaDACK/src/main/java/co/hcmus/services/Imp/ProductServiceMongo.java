package co.hcmus.services.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongodb.gridfs.GridFSDBFile;

import co.hcmus.daos.IProductDAO;
import co.hcmus.models.Comment;
import co.hcmus.models.Product;
import co.hcmus.models.ProductDetail;
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.ICommentService;
import co.hcmus.services.IManufacturerService;
import co.hcmus.services.IProductDetailService;
import co.hcmus.services.IProductService;
import co.hcmus.services.IProductStateService;
import co.hcmus.services.IProductTypeService;
import co.hcmus.services.IPromotionDetailService;
import co.hcmus.util.STATUS;

@Service("productService")
@Transactional
public class ProductServiceMongo implements IProductService {
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
		productDAO.addProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
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
		return listProduct;
	}

	@Override
	public void saveImage(String name, String path) {
		productDAO.saveImage(name, path);

	}

	@Override
	public GridFSDBFile getImageByName(String name) {
		return productDAO.getImageByName(name);
	}

	@Override
	public void writeImage(String name, String path) {
		productDAO.writeImage(name, path);

	}

	@Override
	public void deleteImageByName(String name) {
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
		return listProduct;
	}

	@Override
	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
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
		productDAO.activeProduct(id);

	}

}
