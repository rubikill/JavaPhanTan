package co.hcmus.controllers;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import co.hcmus.models.ProductType;
import co.hcmus.services.IProductTypeService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class ProductTypeController {
	private static final Logger logger = LoggerFactory.getLogger(ProductTypeController.class);
	@Autowired
	private IProductTypeService productTypeService;

	/**
	 * ADMIN PAGE - Get all product type
	 * 
	 * @param request
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/producttype", method = RequestMethod.GET)
	public String getProducType(HttpServletRequest request,@RequestParam("Page") int currentPage) {
		repairData(request,currentPage);
		logger.info("Admin get all ProductType");
		return "producttype";
	}

	/**
	 * ADMIN PAGE - Add new product type
	 * 
	 * @param productType
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/producttype/add", method = RequestMethod.POST)
	public String addProductType(ProductType productType,@RequestParam("Page") int currentPage) {
		productTypeService.addProductType(productType);
		logger.info("Admin create  ProductType with name : " + productType.getName());
		return "redirect:/admin/producttype" + "?Page=" + currentPage;
	}

	/**
	 * ADMIN PAGE - edit a product type
	 * 
	 * @param productType
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/producttype/edit", method = RequestMethod.POST)
	public String editProductType(ProductType productType,@RequestParam("inputCurrentPage") int currentPage) {
		productTypeService.updateProductType(productType);
		logger.info("Admin eidt  ProductType with id : " + productType.getId());
		return "redirect:/admin/producttype" + "?Page=" + currentPage;
	}

	/**
	 * ADMIN PAGE - Set product type to active
	 * 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/producttype/active/{id}/Page/{currentPage}", method = RequestMethod.GET)
	public String activeProductType(@PathVariable String id,@PathVariable int currentPage) {
		ProductType productType = productTypeService.getProductType(id);
		productType.setStatus(STATUS.ACTIVE.getStatusCode());
		productTypeService.updateProductType(productType);
		logger.info("Admin active  ProductType with id : " + productType.getId());
		return "redirect:/admin/producttype" + "?Page=" + currentPage;
	}

	/**
	 * ADMIN PAGE - Set product type to deactive
	 * 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/producttype/deactive/{id}/Page/{currentPage}", method = RequestMethod.GET)
	public String deactiveProductType(@PathVariable String id,@PathVariable int currentPage) {
		ProductType productType = productTypeService.getProductType(id);
		productType.setStatus(STATUS.INACTIVE.getStatusCode());
		productTypeService.updateProductType(productType);
		logger.info("Admin deactive  ProductType with id : " + productType.getId());
		return "redirect:/admin/producttype" + "?Page=" + currentPage;
	}

	/**
	 * ADMIN PAGE - Prepair data for loading product type
	 * 
	 * @param request
	 */
	private void repairData(HttpServletRequest request, int currentPage) {
		List<ProductType> listProductType = productTypeService
				.getProductTypes();
		List<ProductType> listResult;
		if (listProductType.size() < 10 * currentPage) {
			listResult = listProductType.subList(10 * (currentPage - 1),
					listProductType.size());
		} else {
			listResult = listProductType.subList(10 * (currentPage - 1),
					(10 * currentPage));
		}
		int totalPage = getTotalPage(listProductType);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage);
		ProductType productType = new ProductType();
		request.setAttribute("productType", productType);
		request.setAttribute("listProductType", listResult);
		request.setAttribute("nav", "producttype");
	}

	/*
	 * total page in admin
	 */
	private int getTotalPage(List<ProductType> listProductType) {
		if (listProductType.size() == 0)
			return 1;
		if (listProductType.size() <= 10)
			return 1;
		int totalPage = listProductType.size() / 10;
		if (listProductType.size() % 10 == 0)
			return totalPage;
		return totalPage + 1;

	}
	
	/**
	 * web service to get ProductTypes
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
		logger.info("Rest get all ProductType");
		return new ResponseEntity<String>(Tools.toJsonArray(listProductType),
				headers, HttpStatus.OK);
	}
}
