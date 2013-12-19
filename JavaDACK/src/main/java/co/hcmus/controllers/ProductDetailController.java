package co.hcmus.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import co.hcmus.models.ProductDetail;
import co.hcmus.services.IProductDetailService;
import co.hcmus.util.Tools;


@Controller
public class ProductDetailController {
	private static final Logger logger = LoggerFactory.getLogger(ProductDetailController.class);
	@Autowired
	private IProductDetailService productDetailSerivce;
	
	
	/**
	 * web service to get productDetail by product Id
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "productDetail/{productId}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> getProductDetailByProductId(@PathVariable("productId") String productId) {
		// get product byID
		ProductDetail productDetail = productDetailSerivce.getProductDetailByProductId(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		logger.info("Rest get ProductDetail by ProductId : " + productId);
		if (productDetail == null) {
			logger.error("Error get ProductDetail by ProductId : " + productId);
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(Tools.toJson(productDetail), headers,
				HttpStatus.OK);
	}
}
