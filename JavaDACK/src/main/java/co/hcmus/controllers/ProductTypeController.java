package co.hcmus.controllers;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

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

import co.hcmus.models.ProductType;
import co.hcmus.services.IProductTypeService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class ProductTypeController {

	@Autowired
	private IProductTypeService productTypeService;

	/**
	 * ADMIN PAGE - Get all product type
	 * 
	 * @param locale
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/admin/producttype", method = RequestMethod.GET)
	public String getProducType(Locale locale, Model model,
			HttpServletRequest request) {
		repairData(request);
		return "producttype";
	}

	/**
	 * ADMIN PAGE - Add new product type
	 * @param locale
	 * @param model
	 * @param request
	 * @param productType
	 * @return
	 */
	@RequestMapping(value = "/admin/producttype/add", method = RequestMethod.POST)
	public String addProductType(Locale locale, Model model,
			HttpServletRequest request, ProductType productType) {
		System.out.println("id:" + productType.getId());
		System.out.println("Name:" + productType.getName());
		System.out.println("Status:" + productType.getStatus());
		
		productTypeService.addProductType(productType);
		return "redirect:/admin/producttype";
	}
	
	/**
	 * ADMIN PAGE - edit a product type
	 * @param locale
	 * @param model
	 * @param request
	 * @param productType
	 * @return
	 */
	@RequestMapping(value = "/admin/producttype/edit", method = RequestMethod.POST)
	public String editProductType(Locale locale, Model model,
			HttpServletRequest request, ProductType productType) {
		productTypeService.updateProductType(productType);
		return "redirect:/admin/producttype";
	}

	/**
	 * ADMIN PAGE - Set product type to active
	 * @param locale
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/producttype/active/{id}", method = RequestMethod.GET)
	public String activeProductType(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		ProductType productType = productTypeService.getProductType(id);
		productType.setStatus(STATUS.ACTIVE.getStatusCode());
		productTypeService.updateProductType(productType);
		
		return "redirect:/admin/producttype";
	}

	/**
	 * ADMIN PAGE - Set product type to deactive
	 * @param locale
	 * @param model
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/admin/producttype/deactive/{id}", method = RequestMethod.GET)
	public String deactiveProductType(Locale locale, Model model,
			HttpServletRequest request, @PathVariable String id) {
		ProductType productType = productTypeService.getProductType(id);
		productType.setStatus(STATUS.INACTIVE.getStatusCode());
		productTypeService.updateProductType(productType);
		return "redirect:/admin/producttype";
	}

	/**
	 * Prepair data for loading product type
	 * @param request
	 */
	private void repairData(HttpServletRequest request) {
		List<ProductType> listProductType = productTypeService
				.getProductTypes();
		ProductType productType = new ProductType();
		request.setAttribute("productType", productType);
		request.setAttribute("listProductType", listProductType);
		request.setAttribute("nav", "producttype");
	}

	/**
	 * webservice to get ProductTypes
	 * 
	 * @return
	 */
	@RequestMapping(value = "/type", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getTypes() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		List<ProductType> listProductType = productTypeService
				.getProductTypes();
		return new ResponseEntity<String>(Tools.toJsonArray(listProductType),
				headers, HttpStatus.OK);
	}
}
