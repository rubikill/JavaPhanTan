package co.hcmus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.hcmus.models.ProductType;
import co.hcmus.services.IProductTypeService;
import co.hcmus.util.Tools;


@Controller
public class ProductTypeController {

	@Autowired
	private IProductTypeService productTypeService;
	
	/**
	 * webservice to get ProductTypes
	 * @return
	 */
	@RequestMapping(value = "/type", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getTypes() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
	List<ProductType> listProductType = productTypeService.getProductTypes();
		return new ResponseEntity<String>(Tools.toJsonArray(listProductType), headers,
				HttpStatus.OK);
	}
}
