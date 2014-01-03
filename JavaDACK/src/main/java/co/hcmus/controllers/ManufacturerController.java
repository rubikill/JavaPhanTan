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

import co.hcmus.models.Manufacturer;
import co.hcmus.services.IManufacturerService;
import co.hcmus.util.STATUS;
import co.hcmus.util.Tools;

@Controller
public class ManufacturerController {

	private static final Logger logger = LoggerFactory
			.getLogger(ManufacturerController.class);
	
	@Autowired
	private IManufacturerService manufacturerService;

	/**
	 * ADMIN PAGE - get all manufacturers and render by return its name
	 * @param request
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer", method = RequestMethod.GET)
	public String getManufacturer(HttpServletRequest request, @RequestParam("Page") int currentPage) {
		prepairData(request,currentPage);
		logger.info("Admin get All manufacturer");
		return "manufacturer";
	}

	/**
	 * ADMIN PAGE - add new manufacturer and redirect to /admin/manufacturer   
	 * @param manufacturer
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer/add", method = RequestMethod.POST)
	public String addManufacturer(Manufacturer manufacturer,@RequestParam("Page") int currentPage) {
		manufacturerService.addManufacturer(manufacturer);
		logger.info("Admin create  manufacturer with name : "  + manufacturer.getName());
		return "redirect:/admin/manufacturer"+ "?Page=" + currentPage;
	}

	/**
	 * ADMIN PAGE - active a manufacturer and redirect to /admin/manufacturer 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer/active/{id}/Page/{currentPage}", method = RequestMethod.GET)
	public String activeManufacturer(@PathVariable String id,@PathVariable int currentPage) {
		Manufacturer Manufacturer = manufacturerService.getManufacturerById(id);
		Manufacturer.setStatus(STATUS.ACTIVE.getStatusCode());
		manufacturerService.updateManufacturer(Manufacturer);
		logger.info("Admin active  manufacturer with Id : " + id);
		return "redirect:/admin/manufacturer " + "?Page=" + currentPage;
	}

	/**
	 * ADMIN PAGE - inactive a manufacturer and redirect to /admin/manufacturer 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer/deactive/{id}/Page/{currentPage}", method = RequestMethod.GET)
	public String deactiveManufacturer(@PathVariable String id,@PathVariable int currentPage) {
		Manufacturer Manufacturer = manufacturerService.getManufacturerById(id);
		Manufacturer.setStatus(STATUS.INACTIVE.getStatusCode());
		manufacturerService.updateManufacturer(Manufacturer);
		logger.info("Admin deacitve  manufacturer with Id : " + id);
		return "redirect:/admin/manufacturer " + "?Page=" + currentPage;
	}

	/**
	 * ADMIN PAGE - edit a manufacturer and redirect to /admin/manufacturer 
	 * @param manufacturer
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer/edit", method = RequestMethod.POST)
	public String editManufacturer(Manufacturer manufacturer, @RequestParam("inputCurrentPage") int currentPage) {
		manufacturerService.updateManufacturer(manufacturer);
		logger.info("Admin edit  manufacturer with Id : " + manufacturer.getId());
		return "redirect:/admin/manufacturer" + "?Page=" + currentPage;
	}
	
	/**
	 * ADMIN PAGE - get total page of listManufacturer
	 * @param listManufacturer
	 * @return
	 */
	private int getTotalPage(List<Manufacturer> listManufacturer) {
		if (listManufacturer.size() == 0)
			return 1;
		if (listManufacturer.size() <= 10)
			return 1;
		int totalPage = listManufacturer.size() / 10;
		if (listManufacturer.size() % 10 == 0)
			return totalPage;
		return totalPage + 1;

	}
	
	/**
	 * ADMIN PAGE - Prepare data for loading /admin/manufacturer
	 * @param request
	 */
	private void prepairData(HttpServletRequest request, int currentPage) {
		List<Manufacturer> listManufacturer = manufacturerService
				.getManufacturers();
		List<Manufacturer> listResult;
		if (listManufacturer.size() < 10 * currentPage) {
			listResult = listManufacturer.subList(10 * (currentPage - 1),
					listManufacturer.size());
		} else {
			listResult = listManufacturer.subList(10 * (currentPage - 1),
					(10 * currentPage));
		}
		int totalPage = getTotalPage(listManufacturer);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listManufacturer", listResult);
		request.setAttribute("manufacturer", new Manufacturer());
		request.setAttribute("nav", "manufacturer");
	}

	/**
	 * web service to get manufacturers
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getManufacturers() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		// get all product
		List<Manufacturer> listManufacturer = manufacturerService
				.getManufacturers();
		logger.info("Rest get all manufacturer");
		return new ResponseEntity<String>(Tools.toJsonArray(listManufacturer),
				headers, HttpStatus.OK);
	}
}
