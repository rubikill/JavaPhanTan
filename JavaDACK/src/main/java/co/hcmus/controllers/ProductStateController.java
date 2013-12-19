package co.hcmus.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.ProductState;
import co.hcmus.services.IProductStateService;
import co.hcmus.util.Tools;

@Controller
public class ProductStateController {
	private static final Logger logger = LoggerFactory.getLogger(ProductStateController.class);
	@Autowired
	private IProductStateService productStateService;

	/**
	 * webservice to get all productstates
	 * 
	 * @return
	 */
	@RequestMapping(value = "/productstate", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getProductStates() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		try {
			logger.info("Rest get all product State");
			List<ProductState> listProductState = productStateService
					.getProductStates();
			return new ResponseEntity<String>(
					Tools.toJsonArray(listProductState), headers, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Error get all product State");
			return new ResponseEntity<String>(headers, HttpStatus.BAD_REQUEST);
		}

	}

}
