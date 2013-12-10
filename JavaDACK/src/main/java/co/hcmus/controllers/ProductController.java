package co.hcmus.controllers;

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
import co.hcmus.services.IProductService;
import co.hcmus.util.Tools;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {
	@Autowired
	private IProductService productService;

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
		List<Product> result = productService.getProductsByTypeId(id);
		return new ResponseEntity<String>(Tools.toJsonArray(result), headers,
				HttpStatus.OK);
	}
	
	/**
	 * webservice to get products by manufacturer id = id of manufacturer of product
	 * 
	 */

	@RequestMapping(value = "/product/manufacturer/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProductByManufacturer(@PathVariable("id") String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product by manufacturer productID
		List<Product> result = productService.getProductsByManufacturerId(id);
		return new ResponseEntity<String>(Tools.toJsonArray(result), headers,
				HttpStatus.OK);
	}
}
