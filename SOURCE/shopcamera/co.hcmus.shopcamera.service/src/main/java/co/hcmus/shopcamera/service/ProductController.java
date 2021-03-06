package co.hcmus.shopcamera.service;




import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.shopcamera.data.model.Manufacturer;
import co.hcmus.shopcamera.data.model.Product;
import co.hcmus.shopcamera.data.model.ProductDetail;
import co.hcmus.shopcamera.data.model.ProductState;
import co.hcmus.shopcamera.data.model.ProductType;
import co.hcmus.shopcamera.data.model.PromotionDetail;
import co.hcmus.shopcamera.manager.IManufacturerService;
import co.hcmus.shopcamera.manager.IProductDetailService;
import co.hcmus.shopcamera.manager.IProductService;
import co.hcmus.shopcamera.manager.IProductStateService;
import co.hcmus.shopcamera.manager.IProductTypeService;
import co.hcmus.shopcamera.manager.IPromotionDetailService;
import co.hcmus.shopcamera.utility.STATUS;
import co.hcmus.shopcamera.utility.Tools;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory
			.getLogger(ProductController.class);

	@Autowired
	private IProductService productService;

	@Autowired
	private IPromotionDetailService promotionDetailService;

	@Autowired
	private IProductDetailService productDetailService;
	@Autowired
	private IProductTypeService productTypeService;
	@Autowired
	private IProductStateService productStateService;
	@Autowired
	private IManufacturerService manufacturerService;

	/**
	 * webservice for get all product
	 */

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@ResponseBody
	public List<Product> getProducts() {
		logger.info("Rest to get all Products");
		return productService.getProducts();
	}

	/**
	 * webservice for get all product
	 */
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addProduct(@RequestBody String json) {
		try{
			Product product = Tools.fromJsonTo(json, Product.class);
			productService.addProduct(product);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e){

		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * webservice for get all product
	 */
	@RequestMapping(value = "/product", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<String> updateProduct(@RequestBody String json) {
		try{
			Product product = Tools.fromJsonTo(json, Product.class);
			productService.updateProduct(product);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e){

		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * webservice for get all product
	 */
	@RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<String> deleteProduct(@PathVariable("id") String id) {
		try{
			logger.info("delete product: " + id);
			productService.deleteProduct(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		}catch(Exception e){

		}
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * 
	 * @param id
	 *            product id
	 * @return webservice for get product by id
	 */
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> getProductId(@PathVariable("id") String id) {
		// get product byID
		Product product = productService.getProductById(id);
		logger.info("Rest to get Product with Id : " + id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (product == null) {
			logger.error("Product not found with Id : " + id);
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(Tools.toJson(product), headers,
				HttpStatus.OK);
	}

	/**
	 * webservice to get products by productTypeId id = id of type of product
	 * 
	 */

	@RequestMapping(value = "/product/type/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProductByType(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product by type productID
		List<Product> result = productService.getProductsByTypeId(id,
				STATUS.ACTIVE.getStatusCode());
		logger.info("Get all product have productType with productTypeId : "
				+ id);
		return new ResponseEntity<String>(Tools.toJsonArray(result), headers,
				HttpStatus.OK);
	}

	/**
	 * webservice to get products by manufacturer id = id of manufacturer of
	 * product
	 * 
	 */

	@RequestMapping(value = "/product/manufacturer/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProductByManufacturer(
			@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product by manufacturer productID
		List<Product> result = productService.getProductsByManufacturerId(id,
				STATUS.ACTIVE.getStatusCode());
		logger.info("Get all product have manufacturer with ManufacturerId : "
				+ id);
		return new ResponseEntity<String>(Tools.toJsonArray(result), headers,
				HttpStatus.OK);
	}

	/**
	 * webservice to get products by productState id = id of productstate of
	 * product
	 * 
	 */

	@RequestMapping(value = "/product/productstate/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProductByProductStateId(
			@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			List<Product> temp = productService.getProductByProductStateId(id,
					STATUS.ACTIVE.getStatusCode());
			List<Product> result;
			if (temp.size() < 10)
				result = temp.subList(0, temp.size());
			else
				result = temp.subList(0, 10);
			logger.info("Get all product have productstate with productStateId : "
					+ id);
			return new ResponseEntity<String>(Tools.toJsonArray(result),
					headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error get all  product have productstate with productStateId : "
					+ id);
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * rest to get product with promotion id
	 * 
	 * @param promotionid
	 * @return
	 */
	@RequestMapping(value = "/product/promotion/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProductByPromotionId(
			@PathVariable("id") String promotionid) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			List<PromotionDetail> listPromotionDetail = promotionDetailService
					.getPromotionDetailsByPromotionId(promotionid,
							STATUS.ACTIVE.getStatusCode());
			List<Product> result = new ArrayList<Product>();
			for (PromotionDetail promotionDetail : listPromotionDetail) {
				String productId = promotionDetail.getProductId();
				Product product = productService.getProductById(productId);
				result.add(product);
			}
			logger.info("Get all product have promotion with promotionid : "
					+ promotionid);
			return new ResponseEntity<String>(Tools.toJsonArray(result),
					headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error get all  product have promotion with promotionid : "
					+ promotionid);
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * rest to search product by name
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/product/search/{name}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> searchProductByName(
			@PathVariable("name") String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		try {
			List<Product> listProduct = productService.searchProductByName(
					name, STATUS.ACTIVE.getStatusCode());
			logger.info("Get all product by name with name  : " + name);
			return new ResponseEntity<String>(Tools.toJsonArray(listProduct),
					headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error Get all product by name with name : " + name);
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Controller for admin
	 */

	/*
	 * @RequestMapping(value = "/admin/producttype", method = RequestMethod.GET)
	 * public String products(Locale locale, Model model, HttpServletRequest
	 * request) { request.setAttribute("nav", "producttype"); return "type"; }
	 * 
	 * @RequestMapping(value = "/admin/products", method = RequestMethod.GET)
	 * public String getProducts(Locale locale, Model model, HttpServletRequest
	 * request) { request.setAttribute("nav", "products"); return "products"; }
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/products", method = RequestMethod.GET)
	public String productsAdmin(Locale locale, Model model,
			HttpServletRequest request, @RequestParam("Page") int currentPage) {
		prepairData(request, currentPage);
		logger.info("Admin get all Products");
		return "products";
	}

	/**
	 * 
	 * admin crate product
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
	public String adminEditProduct(

			Locale locale,
			HttpServletRequest request,
			@RequestParam(value = "inputProductId", required = true) String id,
			@RequestParam(value = "inputName", required = false) String name,
			@RequestParam(value = "inputProductType", required = false) String productTypeId,
			@RequestParam(value = "inputQuantity", required = false) int quantity,
			@RequestParam(value = "inputSellCount", required = false) int sellCount,
			@RequestParam(value = "inputImportCount", required = false) int importCount,
			@RequestParam(value = "inputManufacturer", required = false) String manufacturerId,
			@RequestParam(value = "inputPrice", required = false) double price,
			@RequestParam(value = "inputDescription", required = false) String description,
			@RequestParam(value = "inputProductState", required = false) String productStateId,
			@RequestParam(value = "inputPoint", required = false) int point,
			@RequestParam(value = "inputWarranty", required = false) int warranty,
			@RequestParam(value = "inputWeight", required = false) Double weight,
			@RequestParam(value = "inputHeight", required = false) Double height,
			@RequestParam("inputCurrentPage") int currentPage,
			@RequestParam("inputFile") String url) {

		try {
			// update product
			logger.info("Admin edit  Product with Id : " + id);
			Product product = productService.getProductById(id);
			product.setName(name);
			product.setName(name);
			product.setProductTypeId(productTypeId);
			product.setQuantity(quantity);
			product.setSellCount(sellCount);
			product.setImportCount(importCount);
			product.setManufacturerId(manufacturerId);
			product.setPrice(price);
			product.setDescription(description);
			product.setProductStateId(productStateId);
			product.setPoint(point);
			product.setUrl(url);
			productService.updateProduct(product);

			// update productDetail

			ProductDetail productDetail = productDetailService
					.getProductDetailByProductId(id);
			productDetail.setWarranty(warranty);

			productDetail.setWeight(weight);
			productDetail.setHeight(height);
			productDetailService.updateProductDetail(productDetail);
		} catch (Exception e) {
			logger.error(" Error Admin edit  Product with Id : " + id);
		}
		prepairData(request, currentPage);
		return "redirect:/admin/products" + "?Page=" + currentPage;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/product/create", method = RequestMethod.POST)
	public String adminCreateProduct(

			Locale locale,
			HttpServletRequest request,
			@RequestParam(value = "inputName", required = false) String name,
			@RequestParam(value = "inputProductType", required = false) String productTypeId,
			@RequestParam(value = "inputQuantity", required = false) int quantity,
			@RequestParam(value = "inputSellCount", required = false) int sellCount,
			@RequestParam(value = "inputImportCount", required = false) int importCount,
			@RequestParam(value = "inputManufacturer", required = false) String manufacturerId,
			@RequestParam(value = "inputPrice", required = false) double price,
			@RequestParam(value = "inputDescription", required = false) String description,
			@RequestParam(value = "inputProductState", required = false) String productStateId,
			@RequestParam(value = "inputPoint", required = false) int point,
			@RequestParam(value = "inputWarranty", required = false) int warranty,
			@RequestParam(value = "inputWeight", required = false) Double weight,
			@RequestParam(value = "inputHeight", required = false) Double height,
			@RequestParam(value = "inputStatus", required = false) String status,
			@RequestParam("Page") int currentPage,
			@RequestParam("inputFile") String url) {

		try {
			logger.info("Admin crate  Product with name : " + name);
			// Create product
			
			Product product = new Product();
			product.setName(name);
			product.setProductTypeId(productTypeId);
			product.setQuantity(quantity);
			product.setSellCount(sellCount);
			product.setImportCount(importCount);
			product.setManufacturerId(manufacturerId);
			product.setPrice(price);
			product.setDescription(description);
			product.setProductStateId(productStateId);
			product.setPoint(point);
			product.setStatus(status);
			product.setUrl(url);
			productService.addProduct(product);
			
			// get productid of product have created
			Product productTemp = productService.getProductByName(name);
			String productId = productTemp.getId();

			// create product detail
			ProductDetail productDetail = new ProductDetail();
			productDetail.setProductId(productId);
			productDetail.setWarranty(warranty);
			productDetail.setWeight(weight);
			productDetail.setHeight(height);
			productDetail.setStatus(status);
			productDetailService.addProductDetail(productDetail);

		} catch (Exception e) {
			System.out.println(e.toString());
			logger.error(" Error Admin create  Product with name : " + name);
		}
		prepairData(request, currentPage);
		return "redirect:/admin/products" + "?Page=" + currentPage;
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/product/delete", method = RequestMethod.POST)
	public String adminDeleteProduct(Locale locale, HttpServletRequest request,
			@RequestParam(value = "inputProductId", required = true) String id,
			@RequestParam("inputCurrentPage") int currentPage) {
		try {
			logger.info("Admin inactive  Product with id : " + id);
			productService.deleteProduct(id);

		} catch (Exception e) {
			logger.error(" Error Admin inactive  Product with id : " + id);
		}
		prepairData(request, currentPage);
		return "redirect:/admin/products" + "?Page=" + currentPage;

	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/product/active", method = RequestMethod.POST)
	public String adminActiveProduct(Locale locale, HttpServletRequest request,
			@RequestParam(value = "inputProductId", required = true) String id,
			@RequestParam("inputCurrentPage") int currentPage) {
		try {
			logger.info("Admin active  Product with id : " + id);
			productService.activeProduct(id);

		} catch (Exception e) {
			logger.error(" Error Admin active  Product with id : " + id);
		}
		prepairData(request, currentPage);
		return "redirect:/admin/products" + "?Page=" + currentPage;

	}

	private void prepairData(HttpServletRequest request, int currentPage) {

		try {
			List<Product> listProduct = productService.getProducts();
			List<Product> listResult;
			if (listProduct.size() < 10 * currentPage) {
				listResult = listProduct.subList(10 * (currentPage - 1),
						listProduct.size());
			} else {
				listResult = listProduct.subList(10 * (currentPage - 1),
						(10 * currentPage));
			}
			List<ProductType> listProductType = productTypeService
					.getProductTypes();
			List<ProductState> listProductState = productStateService
					.getProductStates();
			List<Manufacturer> listManufacturer = manufacturerService
					.getManufacturers();
			int totalPage = getTotalPage(listProduct);
			request.setAttribute("totalPage", totalPage);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("listProduct", listResult);
			request.setAttribute("listProductType", listProductType);
			request.setAttribute("listProductState", listProductState);
			request.setAttribute("listManufacturer", listManufacturer);
			request.setAttribute("nav", "products");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private int getTotalPage(List<Product> listProduct) {
		if (listProduct.size() == 0)
			return 1;
		if (listProduct.size() <= 10)
			return 1;
		int totalPage = listProduct.size() / 10;
		if (listProduct.size() % 10 == 0)
			return totalPage;
		return totalPage + 1;

	}

}
