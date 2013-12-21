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
	public String getManufacturer(HttpServletRequest request) {
		prepairData(request);
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
	public String addManufacturer(Manufacturer manufacturer) {
		manufacturerService.addManufacturer(manufacturer);
		logger.info("Admin create  manufacturer with name : "  + manufacturer.getName());
		return "redirect:/admin/manufacturer";
	}

	/**
	 * ADMIN PAGE - activea a manufacturer and redirect to /admin/manufacturer 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer/active/{id}", method = RequestMethod.GET)
	public String activeManufacturer(@PathVariable String id) {
		Manufacturer Manufacturer = manufacturerService.getManufacturerById(id);
		Manufacturer.setStatus(STATUS.ACTIVE.getStatusCode());
		manufacturerService.updateManufacturer(Manufacturer);
		logger.info("Admin active  manufacturer with Id : " + id);
		return "redirect:/admin/manufacturer";
	}

	/**
	 * ADMIN PAGE - deactive a manufacturer and redirect to /admin/manufacturer 
	 * @param id
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer/deactive/{id}", method = RequestMethod.GET)
	public String deactiveManufacturer(@PathVariable String id) {
		Manufacturer Manufacturer = manufacturerService.getManufacturerById(id);
		Manufacturer.setStatus(STATUS.INACTIVE.getStatusCode());
		manufacturerService.updateManufacturer(Manufacturer);
		logger.info("Admin deacitve  manufacturer with Id : " + id);
		return "redirect:/admin/manufacturer";
	}

	/**
	 * ADMIN PAGE - edit a manufacturer and redirect to /admin/manufacturer 
	 * @param manufacturer
	 * @return
	 */
	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/admin/manufacturer/edit", method = RequestMethod.POST)
	public String editManufacturer(Manufacturer manufacturer) {
		manufacturerService.updateManufacturer(manufacturer);
		logger.info("Admin edit  manufacturer with Id : " + manufacturer.getId());
		return "redirect:/admin/manufacturer";
	}

	/**
	 * Prepair data for loading /admin/manufacturer
	 * @param request
	 */
	private void prepairData(HttpServletRequest request) {
		List<Manufacturer> listManufacturer = manufacturerService
				.getManufacturers();

		request.setAttribute("listManufacturer", listManufacturer);
		request.setAttribute("manufacturer", new Manufacturer());
		request.setAttribute("nav", "manufacturer");
	}

	/**
	 * webservice to get manufacturers
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
