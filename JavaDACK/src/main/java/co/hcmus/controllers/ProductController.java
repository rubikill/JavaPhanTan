package co.hcmus.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.Product;
import co.hcmus.models.PromotionDetail;
import co.hcmus.services.IProductService;
import co.hcmus.services.IPromotionDetailService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	@Autowired
	private IProductService productService;

	@Autowired
	private IPromotionDetailService promotionDetailService;

	@RequestMapping(value = "/product_details", method = RequestMethod.GET)
	public String product_details(Locale locale, Model model) {
		return "product_details";
	}

	@RequestMapping(value = "/product_summary", method = RequestMethod.GET)
	public String product_summary(Locale locale, Model model) {
		return "product_summary";
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String products(Locale locale, Model model) {
		return "products";
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String getProducts(Locale locale, Model model) {
		return "products";
	}

	/**
	 * webservice for get all product
	 */
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProducts() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		List<Product> result = productService.getProducts();
		return new ResponseEntity<String>(Tools.toJsonArray(result), headers,
				HttpStatus.OK);
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
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		if (product == null) {
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
			List<Product> result = temp.subList(0, 9);
			return new ResponseEntity<String>(Tools.toJsonArray(result),
					headers, HttpStatus.OK);
		} catch (Exception e) {
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
			return new ResponseEntity<String>(Tools.toJsonArray(result),
					headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}
	}
}
